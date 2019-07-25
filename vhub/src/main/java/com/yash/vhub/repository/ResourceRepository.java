package com.yash.vhub.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yash.vhub.domain.Resource;

@Repository
public interface ResourceRepository extends JpaRepository<Resource, Long> {

}
