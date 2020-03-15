package com.uniovi.controllers;

import java.awt.List;
import java.security.Principal;
import java.util.LinkedList;

import org.springframework.beans.factory.annotation.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.uniovi.entities.*;
import com.uniovi.services.RolesService;
import com.uniovi.services.SecurityService;
import com.uniovi.services.UsersService;
import com.uniovi.validators.SignUpFormValidator;

@Controller
public class UserController {

	@Autowired
	private UsersService usersService;
	
	@Autowired
	private SecurityService securityService;
	
	@Autowired
	private SignUpFormValidator signUpFormValidator;
	
	@Autowired
	private RolesService rolesService;
	
	@RequestMapping("/user/list")
	public String getListado(Model model, Pageable pageable, 
			@RequestParam(value="",required=false) String searchText)
	{
		Page<User> users=new PageImpl<User>(new LinkedList<User>());
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		 String email = auth.getName();
		 User activeUser = usersService.getUserByEmail(email);
		 
		if(searchText!=null && !searchText.isEmpty()) 
			users=usersService.searchByEmailNameAndLastname(pageable,searchText);
		else
			users=usersService.getUsersLessUser(pageable, activeUser);
		
		model.addAttribute("usersList",users.getContent());
		model.addAttribute("page", users);
		return "user/list";
	}
	
	@RequestMapping(value="/user/add")
	public String getUser(Model model){
		model.addAttribute("rolesList", rolesService.getRoles());
		return "user/add";
	}
	
	@RequestMapping(value="/user/add", method=RequestMethod.POST )
	public String setUser(@ModelAttribute User user){
		usersService.addUser(user);
		return "redirect:/user/list";
	}
	
	@RequestMapping("/user/details/{id}" )
	public String getDetail(Model model, @PathVariable Long id){
		model.addAttribute("user", usersService.getUser(id));
		return "user/details";
	}
	
	@RequestMapping("/user/delete/{id}" )
	public String delete(@PathVariable Long id){
		usersService.deleteUser(id);
		return "redirect:/user/list";
	}

	
	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public String signup(Model model) {
		model.addAttribute("user", new User());
		return "signup";
	}
	
	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public String signup(@Validated User user, BindingResult result) {
		this.signUpFormValidator.validate(user, result);
		if(result.hasErrors())
			return "signup";
		
		user.setRole(rolesService.getRoles()[0]);
		usersService.addUser(user);
		securityService.autoLogin(user.getEmail(), user.getPasswordConfirm());
		return "redirect:home";
	}
	

	
	@RequestMapping(value = { "/home" }, method = RequestMethod.GET)
	public String home(Pageable pageable,Model model) {
		 Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		 String email = auth.getName();
		 User activeUser = usersService.getUserByEmail(email);
		 model.addAttribute("userList", activeUser);

		 return "home";
	}
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model, String error, String logout) {
		if (error != null)
			model.addAttribute("error", "Your username and password is invalid.");
		if (logout != null)
			model.addAttribute("message", "You have been logged out successfully.");

		return "login";
	}

	@RequestMapping("/user/list/update")
	public String updateList(Model model, Pageable pageable){
		Page<User> users=new PageImpl<User>(new LinkedList<User>());
		users= usersService.getUsers(pageable);
		model.addAttribute("userList",users.getContent());	
		return "user/list :: tableUsers";
	}
	
	@RequestMapping(value="/user/{id}/resend", method=RequestMethod.GET)
	public String setResendTrue(Model model, @PathVariable Long id,Principal principal){
		
		 String email = principal.getName();
		 User activeUser = usersService.getUserByEmail(email);
		usersService.addNewPetition(id, activeUser);
		
		return "redirect:/user/list";
	}
	
	@RequestMapping(value="/user/{id}/acepto", method=RequestMethod.GET)
	public String setAcepto(Model model, @PathVariable Long id){
		
		 Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		 String email = auth.getName();
		 User activeUser = usersService.getUserByEmail(email);
		 
		activeUser.getPetitions().remove(usersService.getUser(id));
		//usersService.deletePetition(id, activeUser);
		//usersService.addNewPetition(id, activeUser);
		
		return "redirect:/user/petitions";
	}
	
	
	@RequestMapping("/user/petitions")
	public String getPetitions(Model model)
	{	
		 Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		 String email = auth.getName();
		 User activeUser = usersService.getUserByEmail(email);		 
		model.addAttribute("petitionsList",activeUser.getPetitions());
		
		return "user/petitions";
		
	}
}
