package com.uniovi.services;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uniovi.entities.Friend;
import com.uniovi.repositories.FriendsRepository;

@Service
public class FriendsService {
	@Autowired
	private FriendsRepository friendsRepository; 

	public List<Friend> getFriends(){
		List<Friend> friends = new ArrayList<Friend>();
		friendsRepository.findAll().forEach(friends::add);
		return friends;
	}
	public Friend getFriend(Long id){
		return friendsRepository.findById(id).get();
	}
	public void addFriend(Friend Friend){
		friendsRepository.save(Friend);
		}

	public void deleteFriend(Long id){
		friendsRepository.deleteById(id);
		}
}