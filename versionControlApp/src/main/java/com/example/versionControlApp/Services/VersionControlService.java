package com.example.versionControlApp.Services;

import com.example.versionControlApp.DTOs.VersionDto;
import com.example.versionControlApp.Models.File;
import com.example.versionControlApp.Models.Version;

public interface VersionControlService {
    VersionDto merge(File baseFile, File branchFile);
    String diff(File baseFile, File branchFile);

    void commit(VersionDto versionDto, long fileId);

    boolean hasConflict(File baseFile, File branchFile);
}