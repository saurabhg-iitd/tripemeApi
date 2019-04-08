/*package com.tripeme.api.util;

import java.io.ByteArrayInputStream;
import java.io.File;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.S3ObjectSummary;
import com.tripeme.api.enums.ResourceType;
import com.tripeme.api.property.AwsProperties;

public class AwsS3Util {

	protected static Log log = LogFactory.getLog(AwsS3Util.class);
	
    public static void upload(AwsProperties properties, String fileName, File file, ResourceType type, Long id ) throws Exception {
    	AWSCredentials credentials = new BasicAWSCredentials(
    			  properties.getAccessKey(), 
    			  properties.getSecretKey()
    			);
    	AmazonS3 amazonS3 = AmazonS3ClientBuilder
    			  .standard()
    			  .withCredentials(new AWSStaticCredentialsProvider(credentials))
    			  .withRegion(Regions.US_EAST_1)
    			  .build();
    	AmazonS3 amazonS3 = AmazonS3ClientBuilder.defaultClient();
        ObjectMetadata metaData = new ObjectMetadata();
        metaData.setSSEAlgorithm(ObjectMetadata.AES_256_SERVER_SIDE_ENCRYPTION);
        amazonS3.putObject(properties.getS3BucketName()+"/trip/"+id, fileName,file);
    }
    
    public static void createFolder(AwsProperties properties, String bucketName) {
    	AWSCredentials credentials = new BasicAWSCredentials(
  			  properties.getAccessKey(), 
  			  properties.getSecretKey()
  			);
  	AmazonS3 amazonS3 = AmazonS3ClientBuilder
  			  .standard()
  			  .withCredentials(new AWSStaticCredentialsProvider(credentials))
  			  .withRegion(Regions.US_EAST_1)
  			  .build();
  	amazonS3.createfo
    }

    public static String download(String bucketName, String fileName) {
        AmazonS3 amazonS3 = AmazonS3ClientBuilder.defaultClient();
        return amazonS3.getObjectAsString(bucketName, fileName);
    }
    
	public static void upload(String bucketName, String fileName, ByteArrayInputStream  inputStream) throws Exception {
		AmazonS3 amazonS3 = AmazonS3ClientBuilder.defaultClient();
        ObjectMetadata metaData = new ObjectMetadata();
        metaData.setSSEAlgorithm(ObjectMetadata.AES_256_SERVER_SIDE_ENCRYPTION);
		try {
			amazonS3.putObject(bucketName, fileName, inputStream, metaData);	// Try uploading 
		}
		catch(Exception e) {
			log.error("Could not upload object to S3: " + e.getMessage(), e);
			throw e;
		}
	}
	
	public static void delete(String bucketName, String fileName) {
        AmazonS3 amazonS3 = AmazonS3ClientBuilder.defaultClient();
        try {
        	amazonS3.deleteObject(bucketName, fileName);
        } catch(Exception e) {
        	log.error("Could not delete object to S3:-" + e.getMessage(), e);
        	throw e;
        }
    }
	
	public static void deleteObjectsInFolder(String bucketName, String folderPath) {
		AmazonS3 amazonS3 = AmazonS3ClientBuilder.defaultClient();
		try {
			for (S3ObjectSummary file : amazonS3.listObjects(bucketName, folderPath).getObjectSummaries()){
				   amazonS3.deleteObject(bucketName, file.getKey());
			    }
        } catch(Exception e) {
        	log.error("Could not delete objects to S3:-" + e.getMessage(), e);
        	throw e;
        }
		
	}
	
	public static void uploadFile(String bucketName, String fileName, File file) throws Exception {
		AmazonS3 amazonS3 = AmazonS3ClientBuilder.defaultClient();
		try {
			amazonS3.putObject(bucketName, fileName, file);
		}
		catch(Exception e) {
			log.error("Could not upload object to S3: " + e.getMessage(), e);
			throw e;
		}
	}
}
*/