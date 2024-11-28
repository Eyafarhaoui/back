package com.example.back.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Service
public class FileStorageService {
    private final String uploadDir = "C:/Users/tabar/Desktop/pi";


    public String 
    storeFile(MultipartFile file) throws IOException {
        String fileName = file.getOriginalFilename();
        File destinationFile = new File(uploadDir + File.separator + fileName);
        file.transferTo(destinationFile);  // Sauvegarde du fichier
        return fileName;   
    }
    
}
