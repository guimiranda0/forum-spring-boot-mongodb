package com.devguimsjesus.workshopmongo.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devguimsjesus.workshopmongo.domain.User;


@RestController
@RequestMapping("/users")
public class UserResources {
	@GetMapping
	public ResponseEntity<List<User>> findAll(){
		List<User> list = new ArrayList<>();
		User guilherme = new User("1", "Guilherme","guilherme@gmail.com");
		User maria = new User("2", "Maria","maria@gmail.com");
		User fernando = new User("3", "Fernando","fernando@gmail.com");
		list.addAll(Arrays.asList(guilherme, maria, fernando));
		return ResponseEntity.ok().body(list);
	}
}
