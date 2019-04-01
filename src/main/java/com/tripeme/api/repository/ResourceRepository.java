package com.tripeme.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tripeme.api.bo.Resource;
import com.tripeme.api.enums.ResourceType;

@Repository
public interface ResourceRepository extends CrudRepository<Resource, Long>{
	@Query(value="select * from resource where source_id=?1 and resource_type=?2 ", nativeQuery=true)
	List<Resource> getResources(Long sourceId, ResourceType resourceType);
}
