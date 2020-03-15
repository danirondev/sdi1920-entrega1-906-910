package com.uniovi.services;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.uniovi.entities.User;
import com.uniovi.repositories.UsersRepository;


@Service
public class UsersService {

	@Autowired
	private UsersRepository usersRepository;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	
	public Page<User> getUsers(Pageable pageable) {
		Page<User> users = usersRepository.findAll(pageable);
			return users;
	}
	public Page<User> getUsersLessUser(Pageable pageable,User user) {
		Page<User> users = usersRepository.findAllLessUser(pageable, user);
			return users;
	}
	
	public User getUser(Long id) {
		return usersRepository.findById(id).get();
	}
	
	public void addUser(User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		usersRepository.save(user);
	}
	
	public User getUserByEmail(String email) {
		return usersRepository.findByEmail(email);
		}
	
	public void deleteUser(Long id) {
		usersRepository. deleteById(id);
	}
	
	public Page<User> searchByEmailNameAndLastname (Pageable pageable,String searchText){
		Page<User> users = new PageImpl<User>(new LinkedList<User>());	
		searchText = "%"+searchText+"%";
		users = usersRepository.searchByEmailNameAndLastname(pageable,searchText);
		return users;
		}
	
	public void addNewPetition(Long id, User user) {
		User toSend=usersRepository.findById(id).get();
		user.getUsers().forEach(u -> {
			if(u.getId()==id)
				u.setResend(true);
		});
		toSend.getPetitions().add(user);
		usersRepository.save(toSend);
		usersRepository.save(user);

	}
	
	public void deletePetition(Long id, User user) {
		User toSend=usersRepository.findById(id).get();
		user.getUsers().forEach(u -> {
			if(u.getId()==id)
				u.setResend(false);
		});
		toSend.getPetitions().add(user);
		usersRepository.save(toSend);
		usersRepository.save(user);

	}
	
	public void addNewFriend() {
		
		
		
	}
}
