package com.devguimsjesus.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import com.devguimsjesus.workshopmongo.domain.User;
import com.devguimsjesus.workshopmongo.dto.UserDto;
import com.devguimsjesus.workshopmongo.repository.UserRepository;
import com.devguimsjesus.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {
	@Autowired
	private UserRepository repository;
	public List<User> findAll(){
		return repository.findAll();
	}
	
	public User findById(String id){
		Optional<User> obj = repository.findById(id);
		return obj.orElseThrow(()-> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	public User insert(User obj) {
		return repository.insert(obj);
	}
	
	public void delete(String id) {
		findById(id);
		repository.deleteById(id);
	}
	
	public User update(User obj) {
		Optional<User> newObj = repository.findById(obj.getId());
		User user = newObj.get();
		updateData(user, obj);
		return repository.save(user);		
	}
	
	private void updateData(User newObj, User obj) {
		newObj.setName(obj.getName());
		newObj.setEmail(obj.getEmail());
	}

	public User fromDto(UserDto objDto) {
		return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
	}
}
