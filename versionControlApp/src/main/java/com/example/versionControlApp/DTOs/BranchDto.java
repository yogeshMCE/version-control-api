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
public class BranchDto {
    private Long id;

    private String name;
    private List<Version> versions;

}
