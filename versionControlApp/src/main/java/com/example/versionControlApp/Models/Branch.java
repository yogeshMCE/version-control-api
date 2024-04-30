package com.example.versionControlApp.Models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name="branch")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Branch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    // Relationship with Version: Many-to-Many (Many branches can have multiple versions, and each version can belong to multiple branches)
    @ManyToMany
    @JoinTable(name = "branch_version",
            joinColumns = @JoinColumn(name = "branch_id"),
            inverseJoinColumns = @JoinColumn(name = "version_id"))
    private List<Version> versions;

    // Getters and setters
}
