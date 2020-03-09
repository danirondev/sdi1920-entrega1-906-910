package com.uniovi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.uniovi.entities.Usuario;
import com.uniovi.services.UsersService;

@Controller
public class UserController {

	@Autowired //Inyectar el servicio
	private UsersService usersService;

	@RequestMapping("/user/list")
	public String getList(Model model){
		model.addAttribute("userList", usersService.getUsuarios() );
		return "user/list";
	}

	@RequestMapping(value="/user/add")
		public String getuser(){
		return "user/add";
	}

	@RequestMapping(value="/user/add", method=RequestMethod.POST )
	public String setuser(@ModelAttribute Usuario user){
		usersService.addUsuario(user);
		return "redirect:/user/list";
	}

	@RequestMapping("/user/details/{id}" )
	public String getDetail(Model model, @PathVariable Long id){
		model.addAttribute("user", usersService.getUsuario(id));
		return "user/details";
	}

	@RequestMapping("/user/delete/{id}" )
	public String deleteuser(@PathVariable Long id){
		usersService.deleteUsuario(id);
		return "redirect:/user/list";
	}

	@RequestMapping(value="/user/edit/{id}")
	public String getEdit(Model model, @PathVariable Long id){
		model.addAttribute("user", usersService.getUsuario(id));
		return "user/edit";
	}

	@RequestMapping(value="/user/edit/{id}", method=RequestMethod.POST)
	public String setEdit(Model model, @PathVariable Long id, @ModelAttribute Usuario user){
		user.setId(id);
		usersService.addUsuario(user);
		return "redirect:/user/details/"+id;
	}
}