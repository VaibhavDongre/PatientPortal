package com.learning.PatientPortal.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "documents")
@Data
public class FileMetadata {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String filename;
    private String contentType;
    private Long size;
    private String storagePath;
    private LocalDateTime createdAt = LocalDateTime.now();

}
