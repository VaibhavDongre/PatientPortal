package com.learning.PatientPortal.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "documents")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FileMetadata {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String originalFilename;
    private String storedFilename;
    private String contentType;
    private Long size;
    private String storagePath;
    private LocalDateTime createdAt = LocalDateTime.now();

    public FileMetadata(String originalFilename,
                        String storedFilename,
                        String contentType,
                        Long size,
                        String storagePath) {
        this.originalFilename = originalFilename;
        this.storedFilename = storedFilename;
        this.contentType = contentType;
        this.size = size;
        this.storagePath = storagePath;
    }

}
