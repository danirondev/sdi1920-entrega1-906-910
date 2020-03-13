package com.uniovi.services;

import java.util.HashSet;
import java.util.Set;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uniovi.entities.Friend;
import com.uniovi.entities.Mark;
import com.uniovi.entities.User;

@Service
public class InsertSampleDataService {

	@Autowired
	private UsersService usersService;
	
	@Autowired
	private RolesService rolesService;
	
	@PostConstruct
	public void init() {
		User user1 = new User("pedro@email.com", "Pedro", "Díaz");
		user1.setPassword("123456");
		user1.setRole(rolesService.getRoles()[0]);
		
		User user2 = new User("lucas@email.com", "Lucas", "Núñez");
		user2.setPassword("123456");
		user2.setRole(rolesService.getRoles()[0]);
		
		User user3 = new User("maria@email.com", "María", "Rodríguez");
		user3.setPassword("123456");
		user3.setRole(rolesService.getRoles()[0]);
		
		User user4 = new User("marta@email.com", "Marta", "Almonte");
		user4.setPassword("123456");
		user4.setRole(rolesService.getRoles()[0]);
		
		User user5 = new User("pelayo@email.com", "Pelayo", "Valdes");
		user5.setPassword("123456");
		user5.setRole(rolesService.getRoles()[0]);
		
		User user6 = new User("admin@email.com", "Admin", "Root");
		user6.setPassword("admin");
		user6.setRole(rolesService.getRoles()[1]);
		
		Set user1Friends = new HashSet<Friend>() {
			{
				add(new Friend(user2.getEmail(),user2.getName(),user2.getLastName(),user1));
				add(new Friend(user5.getEmail(),user5.getName(),user5.getLastName(),user1));
			}
		};
		user1.setFriends(user1Friends);
		
		Set user2Friends = new HashSet<Friend>() {
			{
				add(new Friend(user1.getEmail(),user1.getName(),user1.getLastName(),user2));
				add(new Friend(user4.getEmail(),user4.getName(),user4.getLastName(),user2));
			}
		};
		user2.setFriends(user2Friends);
		
		Set user3Friends = new HashSet<Friend>() {
			{
				add(new Friend(user2.getEmail(),user2.getName(),user2.getLastName(),user3));
				add(new Friend(user1.getEmail(),user1.getName(),user1.getLastName(),user3));

			}
		};
		user3.setFriends(user3Friends);
		
		Set user4Friends = new HashSet<Friend>() {
			{
				add(new Friend(user3.getEmail(),user3.getName(),user3.getLastName(),user4));
				add(new Friend(user2.getEmail(),user2.getName(),user2.getLastName(),user4));
			}
		};
		user4.setFriends(user4Friends);
		
		usersService.addUser(user1);
		usersService.addUser(user2);
		usersService.addUser(user3);
		usersService.addUser(user4);
		usersService.addUser(user5);
		usersService.addUser(user6);
	}
}


