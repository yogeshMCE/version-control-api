package com.example.versionControlApp.Controllers;

import com.example.versionControlApp.DTOs.FileDto;
import com.example.versionControlApp.Models.File;
import com.example.versionControlApp.Services.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/files")
public class FileController {

    @Autowired
    private FileService fileService;

    @PostMapping
    public FileDto createFile(@RequestBody FileDto file,@RequestParam("folder_id") long folderID) {
        return fileService.createFile(file,folderID);
    }

    @GetMapping("/{id}")
    public FileDto getFileById(@PathVariable Long id) {
        return fileService.getFileById(id);
    }


    @PutMapping("/{id}")
    public ResponseEntity<FileDto> updateFile(@PathVariable Long id, @RequestBody FileDto file) {
        FileDto fileDto= fileService.updateFile(id,file );
        return new ResponseEntity<>(fileDto, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void deleteFile(@PathVariable Long id) {
        fileService.deleteFile(id);
    }
}
