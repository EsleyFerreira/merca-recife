package br.edu.uniaeso.merca_recife.resource;

import br.edu.uniaeso.merca_recife.config.FileStorageProperties;
import org.springframework.http.ResponseEntity;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@RequestMapping("/api/files")
public class FileStorageResource {

    private final Path fileStorageLocation;

    public FileStorageResource(FileStorageProperties fileStorageProperties) {
        this.fileStorageLocation = Paths.get(fileStorageProperties.getUploadDir())
                .toAbsolutePath().normalize();
    }

    @PostMapping("upload")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        try {
            Path targetLocation = this.fileStorageLocation.resolve(fileName);
            file.transferTo(targetLocation);

            return ResponseEntity.ok("Uploaded file successfully: " + fileName);

        } catch (IOException ex) {
            return ResponseEntity.badRequest().body("Error uploading file: " + ex.getMessage());
        }
    }
}
