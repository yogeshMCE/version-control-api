package com.example.versionControlApp.DTOs;


import com.example.versionControlApp.Models.Version;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class FileDto {
    private Long id;

    private String name;

    private List<VersionDto> versions;
}
