package com.learning.PatientPortal.controller;

import com.learning.PatientPortal.entity.FileMetadata;
import com.learning.PatientPortal.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@RestController
@RequestMapping("/v1.0/files")
@CrossOrigin("*")
public class FileController {

    @Autowired
    private final FileService fileService;

    public FileController(FileService fileService) {
        this.fileService = fileService;
    }

    //upload api
    @PostMapping("/upload")
    public ResponseEntity<?> uplaod(@RequestParam("file")MultipartFile file) {
        try {
            FileMetadata save = fileService.saveFile(file);
            return ResponseEntity.status(HttpStatus.CREATED).body(save);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Upload failed: " + e.getMessage());
        }
    }

    //List all the files
    @GetMapping
    public ResponseEntity<?> list() {
        return ResponseEntity.ok(fileService.listFiles());
    }

    //Download api
    @GetMapping("/{id}/download")
    public ResponseEntity<Resource> download(@PathVariable Long id) {

        File file = fileService.downloadFile(id);
        Resource resource = new FileSystemResource(file);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION,
                        "attachment; filename=\"" + file.getName() + "\"")
                .contentLength(file.length())
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(resource);
    }

    //Delete api
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        try{
            fileService.deleteFile(id);
            return ResponseEntity.ok("File delete successfully");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Delete failed: " + e.getMessage());
        }
    }

}
