package com.example.versionControlApp.ServiceImpl;

import com.example.versionControlApp.DTOs.FileDto;
import com.example.versionControlApp.Models.File;
import com.example.versionControlApp.Models.Folder;
import com.example.versionControlApp.Repositories.FileRepository;
import com.example.versionControlApp.Repositories.FolderRepository;
import com.example.versionControlApp.Services.FileService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FileServiceImpl implements FileService {

    @Autowired
    private FileRepository fileRepository;

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private FolderRepository folderRepository;



    @Override
    public FileDto createFile(FileDto file, long folderID) {
        Folder folder= folderRepository.findById(folderID).orElse(null);
        File file1= modelMapper.map(file, File.class);
        file1.setFolder(folder);
        File updatedFile = fileRepository.save(file1);
        return modelMapper.map(updatedFile, FileDto.class);

    }

    @Override
    public FileDto getFileById(Long id) {

        File file= fileRepository.findById(id).orElse(null);
        return modelMapper.map(file, FileDto.class);
    }

    @Override
    public FileDto updateFile(Long id, FileDto updatedFile) {
    File file= modelMapper.map(updatedFile, File.class);
            file.setId(id);
            File updatedFile1 = fileRepository.save(file);
            return modelMapper.map(updatedFile1, FileDto.class);
    }

    @Override
    public void deleteFile(Long id) {
        fileRepository.deleteById(id);
    }
}
