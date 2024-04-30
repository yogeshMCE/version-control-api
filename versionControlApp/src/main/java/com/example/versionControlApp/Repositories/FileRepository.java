package com.example.versionControlApp.Repositories;

import com.example.versionControlApp.Models.File;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileRepository extends JpaRepository<File, Long> {
}
