package com.devguimsjesus.workshopmongo.resources;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.devguimsjesus.workshopmongo.domain.Post;
import com.devguimsjesus.workshopmongo.resources.util.URL;
import com.devguimsjesus.workshopmongo.services.PostService;


@RestController
@RequestMapping("/posts")
public class PostResources {
	@Autowired
	private PostService service;
	
	@GetMapping("/{id}")
	public ResponseEntity<Post> findById(@PathVariable String id){
		Post obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@GetMapping("/titlesearch")
	public ResponseEntity<List<Post>> findByTitle(@RequestParam(value= "text", defaultValue="") String text){
		text = URL.decodeParam(text);
		List<Post> list = service.findBytitle(text);
		return ResponseEntity.ok().body(list);
	}
}
