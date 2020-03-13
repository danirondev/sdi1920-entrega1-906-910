package com.uniovi.entities;

import javax.persistence.*;

@Entity
public class Friend {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String email;
	private String name;
	private String lastname;
	
	@ManyToOne
	@JoinColumn(name="user.id")
	private User user;
	
	public Friend(Long id, String email, String name,String lastname) {
		super();
		this.id = id;
		this.email=email;
		this.name=name;
		this.lastname=lastname;
	}
	
	public Friend(String email, String name,String lastname,User user) {
		super();
		this.email=email;
		this.name=name;
		this.lastname=lastname;
		this.user=user;
	}
	
	public Friend(){
	
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
}
