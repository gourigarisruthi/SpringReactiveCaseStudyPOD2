package com.bfs.lmt.repo;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.bfs.lmt.entities.User;

public interface UserRepository extends ReactiveCrudRepository<User, Integer>{
	
}
