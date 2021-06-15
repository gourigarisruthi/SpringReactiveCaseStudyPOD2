package com.bfs.lmt.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bfs.lmt.entities.User;
import com.bfs.lmt.repo.UserRepository;
import com.bfs.lmt.service.BankService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class BankServiceImpl implements BankService {
	
	@Autowired
	UserRepository userRepo;

	@Override
	public Mono<User> getUser(Integer userName) {
		return userRepo.findById(userName);
	}

	@Override
	public Mono<User> createUser(User user) {
		return userRepo.save(user);
	}

	@Override
	public Flux<User> getAllUsers() {
		return userRepo.findAll();
	}
	
/*
	@Override
	public Mono<Boolean> updateUser(User user) {
		try {		

			userRepo.save(emuserployee).block();
		}catch(Exception e) {
			return Mono.just(Boolean.FALSE);
		}
		return Mono.just(Boolean.TRUE);
	}

	@Override
	public Mono<Boolean> deleteUser(User user) {
		try {
			userRepo.deleteById(user).block();
		}catch(Exception e) {
			return Mono.just(Boolean.FALSE);
		}
		return Mono.just(Boolean.TRUE);
	}
*/
}
