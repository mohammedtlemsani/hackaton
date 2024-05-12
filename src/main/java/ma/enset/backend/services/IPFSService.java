package ma.enset.backend.services;

import io.ipfs.api.IPFS;
import io.ipfs.api.MerkleNode;
import io.ipfs.api.NamedStreamable;
import io.ipfs.multihash.Multihash;
import lombok.AllArgsConstructor;
import ma.enset.backend.entities.Patient;
import ma.enset.backend.services.IPFSConfig;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.nio.file.Files;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;


@Service
@AllArgsConstructor
public class IPFSService implements FileService {



    IPFSConfig ipfsConfig;

    public String readFileContent(String filePath) throws IOException {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
        }
        return content.toString();
    }

    public void saveHashToFile(String content, String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(content);
        } catch (IOException e) {
            throw new RuntimeException("Error while writing hash to file", e);
        }
    }

    @Override
    public String saveFile(MultipartFile file) {


        try {
            String content = new String(file.getBytes());
            byte[] key = "HZirJx9IwoVyk0r53ywZt2MGPpboF/rA".getBytes();
            SecretKey secretKey = new SecretKeySpec(key, 0, key.length, "AES");//KeyGenerator.getInstance("AES").generateKey();

            FileEncrypterDecrypter fileEncrypterDecrypter
                    = new FileEncrypterDecrypter(secretKey, "AES/CBC/PKCS5Padding");
            //fileEncrypterDecrypter.encrypt(content, file.getResource().getFile());
            // Create a temporary file to hold the encrypted content
            File tempFile = File.createTempFile("encrypted", null);
            fileEncrypterDecrypter.encrypt(content, tempFile);

            // Read the content of the temporary file as a byte array
            byte[] encryptedContent = Files.readAllBytes(tempFile.toPath());

            // Delete the temporary file
            tempFile.delete();

            InputStream inputStream = new ByteArrayInputStream(encryptedContent);
            IPFS ipfs = ipfsConfig.ipfs;

            NamedStreamable.InputStreamWrapper is = new NamedStreamable.InputStreamWrapper(inputStream);
            MerkleNode response = ipfs.add(is).get(0);
            System.out.println("Hash (base 58): " + response.name.get() + " - " + response.hash.toBase58());
            return response.hash.toBase58();

        } catch (IOException ex) {
            throw new RuntimeException("Error whilst communicating with the IPFS node", ex);
        } catch (NoSuchPaddingException | NoSuchAlgorithmException | InvalidKeyException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public byte[] loadFile(String hash) {
        try {
            IPFS ipfs = ipfsConfig.ipfs;
            Multihash filePointer = Multihash.fromBase58(hash);
            byte[] fileEncryptedBytes = ipfs.cat(filePointer);
            byte[] key = "HZirJx9IwoVyk0r53ywZt2MGPpboF/rA".getBytes();
            SecretKey secretKey = new SecretKeySpec(key, 0, key.length, "AES");
            FileEncrypterDecrypter fileEncrypterDecrypter
                    = new FileEncrypterDecrypter(secretKey, "AES/CBC/PKCS5Padding");
            File tempFile = File.createTempFile("encrypted", null);
            OutputStream outputStream = new FileOutputStream(tempFile);
            outputStream.write(fileEncryptedBytes);
            byte[] result = fileEncrypterDecrypter.decrypt(tempFile).getBytes();
            tempFile.delete();
            return result;
        } catch (IOException ex) {
            throw new RuntimeException("Error whilst communicating with the IPFS node", ex);
        } catch (NoSuchPaddingException | NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
    public MultipartFile writePatientToFile(Patient patient) {
            try {
                // Create a temporary file
                File file = File.createTempFile("patient_", ".txt");
                try (FileWriter writer = new FileWriter(file)) {
                    // Write patient information to the file
                    writer.write("Name: " + patient.getName() + "\n");
                    writer.write("Age: " + patient.getAge() + "\n");
                    writer.write("Sex: " + patient.getSex() + "\n");
                    writer.write("Chest Pain Type: " + patient.getChestPainType() + "\n");
                    writer.write("Resting Blood Pressure: " + patient.getRestingBloodPressure() + "\n");
                    writer.write("Serum Cholesterol: " + patient.getSerumCholesterol() + "\n");
                    writer.write("Fasting Blood Sugar: " + patient.getFastingBloodSugar() + "\n");
                    writer.write("Resting Electrocardiographic Results: " + patient.getRestingElectrocardiographicResults() + "\n");
                    writer.write("Maximum Heart Rate Achieved: " + patient.getMaximumHeartRateAchieved() + "\n");
                    writer.write("Exercise Induced Angina: " + patient.getExerciseInducedAngina() + "\n");
                    writer.write("ST Depression Induced by Exercise Relative to Rest: " + patient.getStDepressionInducedByExerciseRelativeToRest() + "\n");
                    writer.write("Slope of the Peak Exercise ST Segment: " + patient.getSlopeOfPeakExerciseSTSegment() + "\n");
                    writer.write("Number of Major Vessels Colored by Flourosopy: " + patient.getNumberOfMajorVesselsColoredByFlourosopy() + "\n");
                    writer.write("Thalassemia: " + patient.getThalassemia() + "\n");
                    writer.write("Heart Disease Diagnosis: " + patient.getHeartDiseaseDiagnosis() + "\n");
                    writer.write("Card: " + patient.getCard() + "\n");
                }
                MultipartFile multipartFile = new MockMultipartFile("test.xlsx", new FileInputStream(file));
                return multipartFile;
            } catch (IOException e) {
                System.err.println("An error occurred while writing to the file: " + e.getMessage());
                return null;
            }
        }


    public String readFileContent(File file) throws IOException {
        StringBuilder content = new StringBuilder();
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
        } finally {
            if (reader != null) {
                reader.close();
            }
        }
        return content.toString();
    }
    public void writeFileContent(File file, String content) throws IOException {
        BufferedWriter writer = null;
        try{
            writer = new BufferedWriter(new FileWriter(file));
            writer.write(content);
        } finally {
            if (writer != null) {
                writer.close();
            }
        }
    }
}
