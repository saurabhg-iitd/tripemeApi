package com.tripeme.api.service.impl;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.sql.Timestamp;
import java.util.Date;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.tripeme.api.enums.ResourceType;
import com.tripeme.api.exception.FileStorageException;
import com.tripeme.api.exception.MyFileNotFoundException;

@Service
public class FileStorageService {

    /*private final Path fileStorageLocation;*/
    

//    @Autowired
//    public FileStorageService(FileStorageProperties fileStorageProperties, ImageType imageType) {
//        this.fileStorageLocation = Paths.get(fileStorageProperties.getUploadDir()+"/"+imageType.toString())
//                .toAbsolutePath().normalize();
//
//        try {
//            Files.createDirectories(this.fileStorageLocation);
//        } catch (Exception ex) {
//            throw new FileStorageException("Could not create the directory where the uploaded files will be stored.", ex);
//        }
//    }

    public String storeFile(MultipartFile file, ResourceType resourceType, Long id, Path fileStorageLocation) {
        // Normalize file name
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        /*fileName =  new Timestamp(System.currentTimeMillis()).toString();*/

        try {
            // Check if the file's name contains invalid characters
            if(fileName.contains("..")) {
                throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
            }

            // Copy file to the target location (Replacing existing file with the same name)
            Path targetLocation = fileStorageLocation.resolve(fileName);
            Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);

            return fileName;
        } catch (IOException ex) {
            throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ex);
        }
    }

    public Resource loadFileAsResource(String fileName,Path fileStorageLocation) {
        try {
            Path filePath = fileStorageLocation.resolve(fileName).normalize();
            Resource resource = new UrlResource(filePath.toUri());
            if(resource.exists()) {
                return resource;
            } else {
                throw new MyFileNotFoundException("File not found " + fileName);
            }
        } catch (MalformedURLException ex) {
            throw new MyFileNotFoundException("File not found " + fileName, ex);
        }
    }
}