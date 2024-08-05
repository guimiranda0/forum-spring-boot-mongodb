package com.devguimsjesus.workshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.devguimsjesus.workshopmongo.domain.Post;
import com.devguimsjesus.workshopmongo.domain.User;
import com.devguimsjesus.workshopmongo.dto.AuthorDto;
import com.devguimsjesus.workshopmongo.repository.PostRepository;
import com.devguimsjesus.workshopmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		User guilherme = new User(null, "Guilherme Miranda", "guilherme@gmail.com");
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		
		userRepository.saveAll(Arrays.asList(maria, alex, bob, guilherme));
		
		Post post1 = new Post(null, sdf.parse("21/07/2024"), "Partiu estrada", "Vou viajar para o Rio de Janeiro. Abraços!", new AuthorDto(maria));
		Post post2 = new Post(null, sdf.parse("23/07/2024"), "Hoje o dia está lindo", "Vou sair para correr um pouco", new AuthorDto(maria));
		
		postRepository.saveAll(Arrays.asList(post1, post2));
		
		maria.getPosts().addAll(Arrays.asList(post1, post2));
		userRepository.save(maria);
	}
}
