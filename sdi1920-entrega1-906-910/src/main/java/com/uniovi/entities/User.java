package com.uniovi.entities;
import javax.persistence.*;

import java.util.LinkedList;
import java.util.Set; //A collection that contains no duplicate elements

@Entity
public class User {
	
	@Id
	@GeneratedValue
	private long id;
	
	@Column(unique=true)
	private String email;
	private String name;
	private String lastName;
	private String role;
	private Boolean resend = false;

	private String password;
	@Transient //propiedad que no se almacena en la tabla.
	private String passwordConfirm;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name="friend")
	private Set<User> friends;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name="petition")
	private Set<User> petitions;
	
	public User(String email, String name, String lastName) {
		super();
		this.email = email;
		this.name = name;
		this.lastName = lastName;
	}
	
	public User() {
	}
	
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordConfirm() {
		return passwordConfirm;
	}

	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}

	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public void setFriends(Set<User> friends) {
		this.friends = friends;
	}
	
	public Set<User> getFriends() {
		return friends;
	}
	
	public String getFullName() {
		return this.name + " " + this.lastName;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	public Boolean getResend() {
		return resend;
	}

	public void setResend(Boolean resend) {
		this.resend = resend;
	}

	public Set<User> getPetitions() {
		return petitions;
	}

	public void setPetitions(Set<User> petitions) {
		this.petitions = petitions;
	}

	public Iterable<User> getUsers_system() {
		// TODO Auto-generated method stub
		return null;
	}

	public LinkedList<User> getUsers_petition() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
