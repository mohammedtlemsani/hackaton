package ma.enset.backend.web;


import lombok.AllArgsConstructor;
import ma.enset.backend.entities.Patient;
import ma.enset.backend.services.IPFSService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@AllArgsConstructor
public class IPFSController {


    private IPFSService ipfsService;

    @PostMapping(value = "upload")
    public String uploadFile(@RequestBody Patient patient) {
        MultipartFile file = ipfsService.writePatientToFile(patient);
        return ipfsService.saveFile(file);
    }

    @GetMapping(value = "file/{hash}")
    public ResponseEntity<byte[]> getFile(@PathVariable("hash") String hash) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-type", MediaType.ALL_VALUE);
        byte[] bytes = ipfsService.loadFile(hash);
        return ResponseEntity.status(HttpStatus.OK).headers(headers).body(bytes);
    }

}

