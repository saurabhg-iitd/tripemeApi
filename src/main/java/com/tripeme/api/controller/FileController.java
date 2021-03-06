	package com.tripeme.api.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.tripeme.api.enums.ResourceType;
import com.tripeme.api.exception.FileStorageException;
import com.tripeme.api.property.FileStorageProperties;
import com.tripeme.api.response.UploadFileResponse;
import com.tripeme.api.service.ResourceService;
import com.tripeme.api.service.impl.FileStorageService;

@RestController
public class FileController {

    private static final Logger logger = LoggerFactory.getLogger(FileController.class);

    @Autowired
    private FileStorageService fileStorageService;
    
    @Autowired
    private FileStorageProperties fileStorageProperties;
    
    @Autowired
    private ResourceService resourceService;
    
    @PostMapping("/uploadFile")
    public com.tripeme.api.bo.Resource uploadFile(@RequestParam("file") MultipartFile file, @RequestParam("imageType") ResourceType resourceType, @RequestParam("id") Long id, @RequestParam("caption") String caption) {
    	Path fileStorageLocation = getFileStorageLocation(resourceType,id);
    	String fileName = fileStorageService.storeFile(file,resourceType,id,fileStorageLocation);
        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/downloadFile/"+resourceType.toString()+"/"+id+"/")
                .path(fileName)
                .toUriString();
        
       com.tripeme.api.bo.Resource resource = new com.tripeme.api.bo.Resource();
       resource.setResourceType(resourceType);
		resource.setSourceId(id);
		resource.setImageUrl(fileDownloadUri);
		resource.setImageCaption(caption);
		resource.setCreatedOn(new Date());
		resource.setUpdatedOn(new Date());
		resource = resourceService.saveResource(resource);
        
		/*Resource resource = new Resource();
		resource.setResourceType(resourceType);
		resource.setSourceId(id);
		resource.setImageUrl(fileDownloadUri);
		resource.setCreatedOn(new Date());
		resource.setUpdatedOn(new Date());
		resource = imageService.saveImage(resource);*/
		return resource;

    }

    @PostMapping("/uploadMultipleFiles")
    public List<com.tripeme.api.bo.Resource> uploadMultipleFiles(@RequestParam("files") MultipartFile[] files, @RequestParam("resourceType") ResourceType resourceType, @RequestParam("id") Long id) {
        return Arrays.asList(files)
                .stream()
                .map(file -> uploadFile(file,resourceType,id,""))
                .collect(Collectors.toList());
    }
    
    @GetMapping("/resource/{resourceType}/{id}")
    public List<com.tripeme.api.bo.Resource> getResources(@PathVariable ResourceType resourceType, @PathVariable Long id){
    	return resourceService.getResources(id, resourceType);
    }
    
    @GetMapping("/resource/{id}")
    public com.tripeme.api.bo.Resource getResourceById(@PathVariable Long id){
    	return resourceService.getResourceById(id);
    }
    
    @PostMapping("/resource")
    public com.tripeme.api.bo.Resource getResourceById(@RequestBody com.tripeme.api.bo.Resource resource){
    	return resourceService.saveResource(resource);
    }
    
    @DeleteMapping("/resource/{id}")
    public com.tripeme.api.bo.Resource deleteResourceById(@PathVariable Long id){
    	com.tripeme.api.bo.Resource resource = getResourceById(id);
    	resourceService.deleteResource(resource);
    	return resource;
    }

    @GetMapping("/downloadFile/{resourceType}/{id}/{fileName:.+}")
    public ResponseEntity<Resource> downloadFile(@PathVariable ResourceType resourceType, @PathVariable Long id,@PathVariable String fileName, HttpServletRequest request) {
        // Load file as Resource
    	Path fileStorageLocation = getFileStorageLocation(resourceType,id);
        Resource resource = fileStorageService.loadFileAsResource(fileName,fileStorageLocation);

        // Try to determine file's content type
        String contentType = null;
        try {
            contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
        } catch (IOException ex) {
            logger.info("Could not determine file type.");
        }

        // Fallback to the default content type if type could not be determined
        if(contentType == null) {
            contentType = "application/octet-stream";
        }

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }
   
    
	Path getFileStorageLocation(ResourceType resourceType, Long id) {
		Path fileStorageLocation = null;
		if (resourceType.equals(ResourceType.destination)) {
			fileStorageLocation = Paths.get(fileStorageProperties.getLocationUploadDir()+"/"+id)
					.toAbsolutePath().normalize();
		}else if (resourceType.equals(ResourceType.theme)) {
			fileStorageLocation = Paths.get(fileStorageProperties.getThemeUploadDir()+"/"+id)
					.toAbsolutePath().normalize();
		}else if (resourceType.equals(ResourceType.trip)) {
			fileStorageLocation = Paths.get(fileStorageProperties.getTripUploadDir()+"/"+id)
					.toAbsolutePath().normalize();
		}
			try {
				Files.createDirectories(fileStorageLocation);
			} catch (Exception ex) {
				throw new FileStorageException(
						"Could not create the directory where the uploaded files will be stored.", ex);
			}
		return fileStorageLocation;
	}
}