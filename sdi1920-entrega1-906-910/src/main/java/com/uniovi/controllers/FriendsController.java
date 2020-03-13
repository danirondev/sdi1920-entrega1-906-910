package com.uniovi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.uniovi.entities.Friend;
import com.uniovi.services.FriendsService;
import com.uniovi.services.UsersService;

@Controller
public class FriendsController {
	
	@Autowired //Inyectar el servicio
	private FriendsService friendsService;
	
	@Autowired
	private UsersService usersService;
	
	@RequestMapping("/friend/list")
	public String getList(Model model){
		model.addAttribute("friendList", friendsService.getFriends() );
		return "friend/list";
	}
	
	@RequestMapping(value="/friend/add", method=RequestMethod.POST )
	 public String setFriend(@ModelAttribute Friend friend){
		
		friendsService.addFriend(friend);
		return "redirect:/friend/list";
	}
	@RequestMapping(value="/friend/add")
	public String getFriend(Model model){
		model.addAttribute("usersList", usersService.getUsers());
		return "friend/add";
	}
	
	@RequestMapping("/friend/details/{id}" )
	public String getDetail(Model model, @PathVariable Long id){
		model.addAttribute("friend", friendsService.getFriend(id));
		return "friend/details";
	}
	@RequestMapping("/friend/delete/{id}" )
	public String deleteFriend(@PathVariable Long id) {
		friendsService.deleteFriend(id);
		return "redirect:/friend/list";
	}
	
	@RequestMapping(value="/friend/edit/{id}")
	public String getEdit(Model model, @PathVariable Long id){
		model.addAttribute("friend", friendsService.getFriend(id));
		model.addAttribute("usersList", usersService.getUsers());
		return "friend/edit";
	}
	@RequestMapping(value="/friend/edit/{id}", method=RequestMethod.POST)
	public String setEdit(Model model, @PathVariable Long id, @ModelAttribute Friend friend){
		Friend original = friendsService.getFriend(id);

		original.setEmail(friend.getEmail());
		original.setName(friend.getName());
		original.setLastname(friend.getLastname());
		
		friendsService.addFriend(original);
		return "redirect:/friend/details/"+id;
	}

	@RequestMapping("/friend/list/update")
	public String updateList(Model model){
		model.addAttribute("friendList", friendsService.getFriends());
		return "friend/list :: tableFriends";
	}


}
