package com.example.versionControlApp.Services;

import com.example.versionControlApp.DTOs.BranchDto;

import java.util.List;

public interface BranchService {
    BranchDto createBranch(BranchDto branchDto,long versionId);
    BranchDto getBranch(Long id);
    BranchDto updateBranch(Long id, BranchDto branchDto);
    void deleteBranch(Long id);
    List<BranchDto> getAllBranches();
}
