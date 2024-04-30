package com.example.versionControlApp.DTOs;

import com.example.versionControlApp.Models.File;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class FolderDto {
    private Long id;

    private String name;
    private List<FileForFolderDto> files;
}
