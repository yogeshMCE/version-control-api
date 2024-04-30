package com.example.versionControlApp.ServiceImpl;

import com.example.versionControlApp.DTOs.FolderDto;
import com.example.versionControlApp.Models.Folder;
import com.example.versionControlApp.Repositories.FolderRepository;
import com.example.versionControlApp.Services.FolderService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FolderServiceImpl  implements FolderService {
    @Autowired
    private FolderRepository folderRepository;

    @Autowired
    private ModelMapper modelMapper;

    public FolderDto createFolder(FolderDto folder) {
        Folder folder1= modelMapper.map(folder, Folder.class);
        Folder folder2= folderRepository.save(folder1);
        return modelMapper.map(folder2, FolderDto.class);
    }

    public FolderDto getFolderById(Long id) {

        Folder folder= folderRepository.findById(id).orElse(null);
        return modelMapper.map(folder, FolderDto.class);
    }

    public FolderDto updateFolder(Long id, FolderDto folderDetails) {
        Folder folder = folderRepository.findById(id).orElse(null);
        if(folder != null) {
            folder.setName(folderDetails.getName());
            // Update other attributes as needed
            folderRepository.save(folder);
        }
        return modelMapper.map(folder, FolderDto.class);
    }

    public void deleteFolder(Long id) {
        folderRepository.deleteById(id);
    }
}