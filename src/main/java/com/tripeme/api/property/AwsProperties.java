package com.tripeme.api.property;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "amazon")
public class AwsProperties {
	private String s3BucketName;
	private String accessKey;
	private String secretKey;
	public String getS3BucketName() {
		return s3BucketName;
	}
	public void setS3BucketName(String s3BucketName) {
		this.s3BucketName = s3BucketName;
	}
	public String getAccessKey() {
		return accessKey;
	}
	public void setAccessKey(String accessKey) {
		this.accessKey = accessKey;
	}
	public String getSecretKey() {
		return secretKey;
	}
	public void setSecretKey(String secretKey) {
		this.secretKey = secretKey;
	}
	
	

}
