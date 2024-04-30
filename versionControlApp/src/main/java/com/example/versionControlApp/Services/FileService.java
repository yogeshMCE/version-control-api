package com.example.versionControlApp.Services;

import com.example.versionControlApp.DTOs.FileDto;
import com.example.versionControlApp.Models.File;

public interface FileService {


    FileDto createFile(FileDto file, long folderID);

    FileDto getFileById(Long id);
    FileDto updateFile(Long id, FileDto updatedFile);
    void deleteFile(Long id);
}
