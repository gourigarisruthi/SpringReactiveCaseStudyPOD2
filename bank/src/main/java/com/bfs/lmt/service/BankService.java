package com.bfs.lmt.service;

import com.bfs.lmt.entities.User;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface BankService {
	public Flux<User> getAllUsers();
	public Mono<User> getUser(Integer userName);
	public Mono<User> createUser(User user);
}
