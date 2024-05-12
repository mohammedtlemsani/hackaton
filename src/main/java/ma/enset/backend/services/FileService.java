package ma.enset.backend.services;

import org.springframework.web.multipart.MultipartFile;

public interface FileService {
    String saveFile(MultipartFile file);
    byte[] loadFile(String hash);
}

