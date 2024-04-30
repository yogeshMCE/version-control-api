package com.example.versionControlApp.ServiceImpl;

import com.example.versionControlApp.DTOs.VersionDto;
import com.example.versionControlApp.Models.File;
import com.example.versionControlApp.Models.Version;
import com.example.versionControlApp.Repositories.FileRepository;
import com.example.versionControlApp.Repositories.VersionRepository;
import com.example.versionControlApp.Services.VersionControlService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VersionControlServiceImpl implements VersionControlService {

    @Autowired
    private FileRepository fileRepository;

    @Autowired
    private VersionRepository versionRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public VersionDto merge(File baseFile, File branchFile) {
        // Implementation goes here
        // This is a simple merge strategy that just appends the content of the branch file to the base file
        Version baseVersion = baseFile.getVersions().get(baseFile.getVersions().size() - 1);
        Version branchVersion = branchFile.getVersions().get(branchFile.getVersions().size() - 1);

        String mergedContent = baseVersion.getContent() + "\n" + branchVersion.getContent();

        Version mergedVersion = new Version();
        mergedVersion.setContent(mergedContent);
        mergedVersion.setFile(baseFile);

       Version version= versionRepository.save(mergedVersion);
       return modelMapper.map(version,VersionDto.class);

    }

    @Override
    public String diff(File baseFile, File branchFile) {
        // Implementation goes here
        // This is a simple diff strategy that just compares the content of the base file and the branch file
        Version baseVersion = baseFile.getVersions().get(baseFile.getVersions().size() - 1);
        Version branchVersion = branchFile.getVersions().get(branchFile.getVersions().size() - 1);

        return baseVersion.getContent().equals(branchVersion.getContent()) ? "No differences" : "Files are different";
    }


    @Override
    public void commit(VersionDto versionDto, long fileId) {
        // Implementation goes here
        // This method creates a new version for the file with the given content

        File file = fileRepository.findById(fileId).orElseThrow(() -> new RuntimeException("File not found"));
        Version version = new Version();
        version.setContent(versionDto.getContent());
        version.setFile(file);
        versionRepository.save(version);
    }

    @Override
    public boolean hasConflict(File baseFile, File branchFile) {
        // Implementation goes here
        // This is a simple conflict detection strategy that just checks if the content of the base file and the branch file are different
        Version baseVersion = baseFile.getVersions().get(baseFile.getVersions().size() - 1);
        Version branchVersion = branchFile.getVersions().get(branchFile.getVersions().size() - 1);

        return !baseVersion.getContent().equals(branchVersion.getContent());
    }
}