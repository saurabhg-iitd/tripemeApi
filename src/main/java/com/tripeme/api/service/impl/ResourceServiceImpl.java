package com.tripeme.api.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tripeme.api.bo.Resource;
import com.tripeme.api.enums.ResourceType;
import com.tripeme.api.repository.ResourceRepository;
import com.tripeme.api.service.ResourceService;

@Service
public class ResourceServiceImpl implements ResourceService {
	
	@Autowired
	ResourceRepository resourceRepository;

	@Override
	public List<Resource> saveResources(List<Resource> resources) {
		Iterable<Resource> ti =  resourceRepository.saveAll(resources);
		List<Resource> response = new ArrayList<>();
		ti.forEach(response::add);
		return response;
	}

	@Override
	public Resource saveResource(Resource resource) {
		return resourceRepository.save(resource);
	}

	@Override
	public List<Resource> getResources(Long sourceId, ResourceType resourceType) {
		return resourceRepository.getResources(sourceId, resourceType.toString());
	}
	
	public Resource getResourceById(Long id) {
		return resourceRepository.getOne(id);
	}
	
	public void deleteResource(Resource resource) {
		resourceRepository.delete(resource);
	}

}
