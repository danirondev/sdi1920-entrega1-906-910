package com.uniovi.repositories;

import com.uniovi.entities.*;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface UsersRepository extends CrudRepository<User, Long>{
	
	@Query("SELECT r FROM User r WHERE (LOWER(r.name) LIKE LOWER(?1) OR LOWER(r.lastName) LIKE LOWER(?1) OR LOWER(r.email) LIKE LOWER(?1))")
	Page<User> searchByEmailNameAndLastname(Pageable pageable, String searchText);
	
	Page<User> findAll(Pageable pageable);
	
	User findByEmail(String email);

	@Query("SELECT r FROM User r WHERE r!=?1")
	Page<User> findAllLessUser(Pageable pageable,User user);
	
	//@Modifying
	//@Transactional
	//@Query("UPDATE User SET resend = ?1 WHERE id = ?2")
	//void updateResend(Boolean resend, Long id);

}
