package com.example.versionControlApp.Repositories;

import com.example.versionControlApp.Models.Folder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FolderRepository extends JpaRepository<Folder, Long> {
}
