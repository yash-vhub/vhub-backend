package com.yash.vhub.repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.yash.vhub.domain.Resource;
import com.yash.vhub.domain.ResourceSummary;
import com.yash.vhub.domain.Skill;

@RepositoryRestResource(excerptProjection=ResourceSummary.class)
public interface ResourceRepository extends JpaRepository<Resource, Long> {

//	Set<Resource> findByNameAndSkill_Skill(String name, String skill);

	List<Resource> findByNameContaining(String name);

//	@Query("SELECT r FROM Resource r WHERE :skill member of r.skills")
//	Set<Resource> findBySkill(@Param(value = "skill") Skill skill);
}
