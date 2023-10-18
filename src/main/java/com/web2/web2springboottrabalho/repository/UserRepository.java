package com.web2.web2springboottrabalho.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.web2.web2springboottrabalho.models.User;

public interface UserRepository extends JpaRepository<User, String> {
	User findByUsername(String username);
}
