package com.uniovi.services;

import java.util.HashSet;
import java.util.Set;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
		
		User user2 = new User("laura@email.com", "Laura", "Alvarez");
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
		
		User user7 = new User("ramon@email.com", "Ramon", "Feijo");
		user7.setPassword("123456");
		user7.setRole(rolesService.getRoles()[0]);
		
		User user8 = new User("adrimart@email.com", "Adrian", "Martinez");
		user8.setPassword("123456");
		user8.setRole(rolesService.getRoles()[0]);
		
		User user9 = new User("dario@email.com", "Dario", "Rodríguez");
		user9.setPassword("123456");
		user9.setRole(rolesService.getRoles()[0]);
		
		User user10 = new User("pedro12Bel@email.com", "Pedro", "Belmonte");
		user10.setPassword("123456");
		user10.setRole(rolesService.getRoles()[0]);
		
		
		/*Set user1Friends = new HashSet<User>() {
			{
				add(new User(user2.getEmail(),user2.getName(),user2.getLastName()));
				add(new User(user5.getEmail(),user5.getName(),user5.getLastName()));
			}
		};
		user1.setFriends(user1Friends);
		
		Set user2Friends = new HashSet<User>() {
			{
				add(new User(user1.getEmail(),user1.getName(),user1.getLastName()));
				add(new User(user4.getEmail(),user4.getName(),user4.getLastName()));
			}
		};
		user2.setFriends(user2Friends);
		
		Set user3Friends = new HashSet<User>() {
			{
				add(new User(user2.getEmail(),user2.getName(),user2.getLastName()));
				add(new User(user1.getEmail(),user1.getName(),user1.getLastName()));

			}
		};
		user3.setFriends(user3Friends);
		
		Set user4Friends = new HashSet<User>() {
			{
				add(new User(user3.getEmail(),user3.getName(),user3.getLastName()));
				add(new User(user2.getEmail(),user2.getName(),user2.getLastName()));
			}
		};
		user4.setFriends(user4Friends);
		*/
		usersService.addUser(user1);
		usersService.addUser(user2);
		usersService.addUser(user3);
		usersService.addUser(user4);
		usersService.addUser(user5);
		usersService.addUser(user6);
		usersService.addUser(user7);
		usersService.addUser(user8);
		usersService.addUser(user9);
		usersService.addUser(user10);
	}
}


