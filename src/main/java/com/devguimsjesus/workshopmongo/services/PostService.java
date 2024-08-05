package com.devguimsjesus.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devguimsjesus.workshopmongo.domain.Post;
import com.devguimsjesus.workshopmongo.repository.PostRepository;
import com.devguimsjesus.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {
	@Autowired
	private PostRepository repository;
	
	
	public Post findById(String id){
		Optional<Post> obj = repository.findById(id);
		return obj.orElseThrow(()-> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	public List<Post> findBytitle(String text){
		return repository.findByTitleContainingIgnoreCase(text);
	}
}
	