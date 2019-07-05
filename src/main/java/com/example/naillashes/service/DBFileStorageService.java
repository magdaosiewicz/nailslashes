package com.example.naillashes.service;

import com.example.naillashes.entity.Photo;
import com.example.naillashes.exception.FileStorageException;
import com.example.naillashes.exception.MyFileNotFoundException;
import com.example.naillashes.repository.PhotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class DBFileStorageService {

    @Autowired
    private PhotoRepository photoRepository;

    public Photo storeFile(MultipartFile file) {
        // Normalize file name
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        try {
            // Check if the file's name contains invalid characters
            if(fileName.contains("..")) {
                throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
            }

            Photo dbFile = new Photo(fileName, file.getContentType()  ,file.getBytes());

            return photoRepository.save(dbFile);
        } catch (IOException ex) {
            throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ex);
        }
    }

    public Photo getFile(String fileId) {
        return photoRepository.findById(fileId)
                .orElseThrow(() -> new MyFileNotFoundException("File not found with id " + fileId));
    }


}