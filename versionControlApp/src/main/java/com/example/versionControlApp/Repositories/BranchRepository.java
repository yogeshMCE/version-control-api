package com.example.versionControlApp.Repositories;

import com.example.versionControlApp.Models.Branch;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BranchRepository extends JpaRepository<Branch, Long> {
}
