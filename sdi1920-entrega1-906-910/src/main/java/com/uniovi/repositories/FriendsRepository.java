package com.uniovi.repositories;

import org.springframework.data.repository.CrudRepository;

import com.uniovi.entities.Friend;

public interface FriendsRepository extends CrudRepository<Friend, Long>{
	
	
}