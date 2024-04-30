package com.example.versionControlApp.Repositories;

import com.example.versionControlApp.Models.Version;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VersionRepository extends JpaRepository<Version, Long> {
}
