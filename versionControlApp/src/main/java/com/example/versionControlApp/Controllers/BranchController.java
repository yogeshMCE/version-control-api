package com.example.versionControlApp.Controllers;

import com.example.versionControlApp.DTOs.BranchDto;
import com.example.versionControlApp.Services.BranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/branch")
public class BranchController {

    @Autowired
    private BranchService branchService;

    @PostMapping("/create")
    public BranchDto createBranch(@RequestBody BranchDto branchDto, @RequestParam long versionId) {
        return branchService.createBranch(branchDto, versionId);
    }

    @GetMapping("/{id}")
    public BranchDto getBranch(@PathVariable Long id) {
        return branchService.getBranch(id);
    }

    @PutMapping("/update/{id}")
    public BranchDto updateBranch(@PathVariable Long id, @RequestBody BranchDto branchDto) {
        return branchService.updateBranch(id, branchDto);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteBranch(@PathVariable Long id) {
        branchService.deleteBranch(id);
    }

    @GetMapping("/all")
    public List<BranchDto> getAllBranches() {
        return branchService.getAllBranches();
    }
}