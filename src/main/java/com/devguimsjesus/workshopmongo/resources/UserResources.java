package com.devguimsjesus.workshopmongo.resources;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devguimsjesus.workshopmongo.domain.User;
import com.devguimsjesus.workshopmongo.services.UserService;


@RestController
@RequestMapping("/users")
public class UserResources {
	@Autowired
	private UserService service;
	@GetMapping
	public ResponseEntity<List<User>> findAll(){
		List<User> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
}
