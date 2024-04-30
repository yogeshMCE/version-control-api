package com.example.versionControlApp.Controllers;

import com.example.versionControlApp.DTOs.FolderDto;
import com.example.versionControlApp.Models.Folder;
import com.example.versionControlApp.Services.FolderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/folders")
public class FolderController {

    @Autowired
    private FolderService folderService;

    @PostMapping
    public ResponseEntity<FolderDto> createFolder(@RequestBody FolderDto folder) {
         FolderDto folderDto= folderService.createFolder(folder);
         return new ResponseEntity<>(folderDto, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FolderDto> getFolderById(@PathVariable Long id) {

        FolderDto folderDto= folderService.getFolderById(id);
        return ResponseEntity.ok(folderDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FolderDto> updateFolder(@PathVariable Long id, @RequestBody FolderDto folder) {
        FolderDto folderDto=  folderService.updateFolder(id, folder);
        return ResponseEntity.ok(folderDto);
    }

    @DeleteMapping("/{id}")
    public void deleteFolder(@PathVariable Long id) {
        folderService.deleteFolder(id);
    }
}
