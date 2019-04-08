/*package com.tripeme.api.controller;

import java.io.File;
import java.io.FileOutputStream;
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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.tripeme.api.enums.ResourceType;
import com.tripeme.api.exception.FileStorageException;
import com.tripeme.api.property.AwsProperties;
import com.tripeme.api.property.FileStorageProperties;
import com.tripeme.api.response.UploadFileResponse;
import com.tripeme.api.service.ResourceService;
import com.tripeme.api.service.impl.FileStorageService;
import com.tripeme.api.util.AwsS3Util;

@RestController
public class AwsFileController {

    private static final Logger logger = LoggerFactory.getLogger(FileController.class);

    @Autowired
    private FileStorageService fileStorageService;
    
    @Autowired
    private FileStorageProperties fileStorageProperties;
    
    @Autowired
    private ResourceService resourceService;
       
    @Autowired
    private AwsProperties awsProperties;
    
    @PostMapping("/uploadFile")
    public UploadFileResponse uploadFile(@RequestParam("file") MultipartFile mFile, @RequestParam("imageType") ResourceType resourceType, @RequestParam("id") Long id) {
    	AwsS3Util  awsService = new AwsS3Util();
    	Path fileStorageLocation = getFileStorageLocation(resourceType,id);
    	String fileName = fileStorageService.storeFile(file,resourceType,id,fileStorageLocation);
    	try {
    		File file = convert(mFile);
    		awsService.upload(awsProperties, file.getName(), file, resourceType, id);
			
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/downloadFile/"+resourceType.toString()+"/"+id+"/")
                .path(mFile.getName())
                .toUriString();
        
       com.tripeme.api.bo.Resource resource = new com.tripeme.api.bo.Resource();
       resource.setResourceType(resourceType);
		resource.setSourceId(id);
		resource.setImageUrl(fileDownloadUri);
		resource.setCreatedOn(new Date());
		resource.setUpdatedOn(new Date());
		resource = resourceService.saveResource(resource);
        
		Resource resource = new Resource();
		resource.setResourceType(resourceType);
		resource.setSourceId(id);
		resource.setImageUrl(fileDownloadUri);
		resource.setCreatedOn(new Date());
		resource.setUpdatedOn(new Date());
		resource = imageService.saveImage(resource);
		

        return new UploadFileResponse(mFile.getName(), fileDownloadUri,
                mFile.getContentType(), mFile.getSize());
    }

    @PostMapping("/uploadMultipleFiles")
    public List<UploadFileResponse> uploadMultipleFiles(@RequestParam("files") MultipartFile[] files, @RequestParam("resourceType") ResourceType resourceType, @RequestParam("id") Long id) {
        return Arrays.asList(files)
                .stream()
                .map(file -> uploadFile(file,resourceType,id))
                .collect(Collectors.toList());
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
			fileStorageLocation = Paths.get(fileStorageProperties.getTripUploadDir()+"/"+id)
					.toAbsolutePath().normalize();
		}else if (resourceType.equals(ResourceType.trip)) {
			fileStorageLocation = Paths.get(fileStorageProperties.getThemeUploadDir()+"/"+id)
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
	
	public File convert(MultipartFile file) throws IOException
	{    
	    File convFile = new File(file.getOriginalFilename());
	    convFile.createNewFile(); 
	    FileOutputStream fos = new FileOutputStream(convFile); 
	    fos.write(file.getBytes());
	    fos.close(); 
	    return convFile;
	}
}*/