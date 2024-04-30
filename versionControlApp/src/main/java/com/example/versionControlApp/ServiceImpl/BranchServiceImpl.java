package com.example.versionControlApp.ServiceImpl;

import com.example.versionControlApp.DTOs.BranchDto;
import com.example.versionControlApp.Models.Branch;
import com.example.versionControlApp.Models.Version;
import com.example.versionControlApp.Repositories.BranchRepository;
import com.example.versionControlApp.Repositories.VersionRepository;
import com.example.versionControlApp.Services.BranchService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BranchServiceImpl implements BranchService {

    @Autowired
    private BranchRepository branchRepository;

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private VersionRepository versionRepository;

    @Override
    public BranchDto createBranch(BranchDto branchDto, long versionId) {
        Version version= versionRepository.findById(versionId).orElse(null);
        Branch branch = modelMapper.map(branchDto, Branch.class);
        assert version != null;
        branch.setVersions(List.of(version));
        Branch savedBranch = branchRepository.save(branch);
        return modelMapper.map(savedBranch, BranchDto.class);
    }

    @Override
    public BranchDto getBranch(Long id) {
        Branch branch = branchRepository.findById(id).orElseThrow(() -> new RuntimeException("Branch not found"));
        return modelMapper.map(branch, BranchDto.class);
    }

    @Override
    public BranchDto updateBranch(Long id, BranchDto branchDto) {
        Branch branch = branchRepository.findById(id).orElseThrow(() -> new RuntimeException("Branch not found"));
        branch.setName(branchDto.getName());
        branch.setVersions(branchDto.getVersions());
        Branch updatedBranch = branchRepository.save(branch);
        return modelMapper.map(updatedBranch, BranchDto.class);
    }

    @Override
    public void deleteBranch(Long id) {
        branchRepository.deleteById(id);
    }

    @Override
    public List<BranchDto> getAllBranches() {
        List<Branch> branches = branchRepository.findAll();
        return branches.stream()
                .map(branch -> modelMapper.map(branch, BranchDto.class))
                .collect(Collectors.toList());
    }
}