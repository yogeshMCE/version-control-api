package com.example.versionControlApp.Services;

import com.example.versionControlApp.DTOs.FolderDto;
import com.example.versionControlApp.Models.Folder;

public interface FolderService {
    FolderDto createFolder(FolderDto folder);
    FolderDto getFolderById(Long id);
    FolderDto updateFolder(Long id, FolderDto updatedFolder);
    void deleteFolder(Long id);
}
