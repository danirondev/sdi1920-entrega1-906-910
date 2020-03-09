package com.uniovi.entities;

@Entity
public class User {
		
		private String dni;
		private String name;
		private String lastName;
		private String role;
		
		private String password;
		
		public User(String dni, String name, String lastName) {
			super();
			this.dni = dni;
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
		
		public String getDni() {
			return dni;
		}
		
		public void setDni(String dni) {
			this.dni = dni;
		}
		
		public String getRole() {
			return role;
		}

		public void setRole(String role) {
			this.role = role;
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

}
