package com.devguimsjesus.workshopmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.devguimsjesus.workshopmongo.domain.User;
import com.devguimsjesus.workshopmongo.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository repository;
	public List<User> findAll(){
		return repository.findAll();
	}
}
