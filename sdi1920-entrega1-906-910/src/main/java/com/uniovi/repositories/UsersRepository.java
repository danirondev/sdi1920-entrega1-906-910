package com.uniovi.repositories;

import com.uniovi.entities.*;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface UsersRepository extends CrudRepository<User, Long>{
	
	@Query("SELECT r FROM User r WHERE (LOWER(r.name) LIKE LOWER(?1) OR LOWER(r.lastName) LIKE LOWER(?1) OR LOWER(r.email) LIKE LOWER(?1))")
	Page<User> searchByEmailNameAndLastname(Pageable pageable, String searchText);
	
	Page<User> findAll(Pageable pageable);
	
	User findByEmail(String email);

}
