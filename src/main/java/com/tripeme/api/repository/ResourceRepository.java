package com.tripeme.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.tripeme.api.bo.Resource;

@Repository
public interface ResourceRepository extends JpaRepository<Resource, Long>{
	@Query(value="select * from resource where source_id=?1 and resource_type=?2 ", nativeQuery=true)
	List<Resource> getResources(Long sourceId, String resourceType);
}
