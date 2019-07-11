package com.yash.vhub.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yash.vhub.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
