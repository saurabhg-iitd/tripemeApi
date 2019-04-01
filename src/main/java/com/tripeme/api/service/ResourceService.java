package com.tripeme.api.service;

import java.util.List;

import com.tripeme.api.bo.Resource;
import com.tripeme.api.enums.ResourceType;

public interface ResourceService {
	List<Resource> saveResources(List<Resource> resources);
	Resource saveResource(Resource resource);
	
	List<Resource> getResources(Long sourceId, ResourceType resourceType);

}
