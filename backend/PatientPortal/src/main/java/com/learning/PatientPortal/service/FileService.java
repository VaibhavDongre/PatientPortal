package com.learning.PatientPortal.service;

import com.learning.PatientPortal.entity.FileMetadata;
import com.learning.PatientPortal.repository.FileRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.UUID;

@Service
public class FileService {

    private final FileRepository fileRepository;

    private final Path storageDirectory;

    public FileService(FileRepository fileRepository, @Value("${file.storage.location}") String storageDir) throws IOException {
        this.fileRepository = fileRepository;
        this.storageDirectory = Paths.get(storageDir).toAbsolutePath().normalize();

        //Create directory if missing
        if (!Files.exists(storageDirectory)) {
            Files.createDirectories(storageDirectory);
        }
    }

    //Save File
    public FileMetadata saveFile(MultipartFile file) throws IOException {
        String originalFilename = file.getOriginalFilename();
        String extension = "";

        int index = originalFilename.lastIndexOf(".");
        if (index > 0) {
            extension = originalFilename.substring(index);
        }

        //We will generate unique name for stored files (for duplicates)
        String storedFilename = UUID.randomUUID() + extension;

        Path targetPath = storageDirectory.resolve(storedFilename);

        //Save file in given directry
        Files.copy(file.getInputStream(), targetPath, StandardCopyOption.REPLACE_EXISTING);

        //Save metadata in database;
        FileMetadata metadata = new FileMetadata(
                originalFilename,
                storedFilename,
                file.getContentType(),
                file.getSize(),
                targetPath.toString()
        );
        return fileRepository.save(metadata);
    }

    //List files
    public List<FileMetadata> listFiles() {
        return fileRepository.findAll();
    }

    //Get file metadata
    public FileMetadata getFile(Long id) {
        return fileRepository.findById(id)
                .orElseThrow(()->new RuntimeException("File not found in the database"));
    }

    //Download file
    public File downloadFile(Long id){
        FileMetadata metadata = getFile(id);

        File file = new File(metadata.getStoragePath());
        if(!file.exists()) throw new RuntimeException("File not found");

        return file;
    }

    //Delete file
    public void deleteFile(Long id) {
        FileMetadata metadata = getFile(id);

        File file = new File(metadata.getStoragePath());
        if (file.exists()) {
            file.delete();
        }
        fileRepository.delete(metadata);
    }
}
