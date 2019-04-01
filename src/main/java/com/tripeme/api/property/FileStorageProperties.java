package com.tripeme.api.property;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "file")
public class FileStorageProperties {
    private String uploadDir;
    private String themeUploadDir;
    private String tripUploadDir;
    private String locationUploadDir;

    public String getUploadDir() {
        return uploadDir;
    }

    public void setUploadDir(String uploadDir) {
        this.uploadDir = uploadDir;
    }

	public String getThemeUploadDir() {
		return themeUploadDir;
	}

	public void setThemeUploadDir(String themeUploadDir) {
		this.themeUploadDir = themeUploadDir;
	}

	public String getTripUploadDir() {
		return tripUploadDir;
	}

	public void setTripUploadDir(String tripUploadDir) {
		this.tripUploadDir = tripUploadDir;
	}

	public String getLocationUploadDir() {
		return locationUploadDir;
	}

	public void setLocationUploadDir(String locationUploadDir) {
		this.locationUploadDir = locationUploadDir;
	}
    
}