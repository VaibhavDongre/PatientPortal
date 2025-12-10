package com.learning.PatientPortal.repository;

import com.learning.PatientPortal.entity.FileMetadata;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileRepository extends JpaRepository<FileMetadata, Long> {
}
