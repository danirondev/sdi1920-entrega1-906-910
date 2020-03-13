package com.uniovi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.uniovi.entities.Profesor;
import com.uniovi.services.ProfesorService;

@Controller
public class ProfesorController {
	
	@Autowired //Inyectar el servicio
	private ProfesorService profService;
	
	@RequestMapping("/profesor/list")
	public String getList(Model model){
		model.addAttribute("markList", profService.getProfs() );
		return "profesor/list";
	}
	@RequestMapping(value="/profesor/add", method=RequestMethod.POST)
	 public String setProf(@ModelAttribute Profesor prof){
		profService.addProf(prof);
		return "redirect:/profesor/list";
	}
	@RequestMapping("/profesor/details/{id}")
	public String getDetail(@PathVariable Long id){
		return profService.getProf(id).toString();
	}
	@RequestMapping("/profesor/delete/{id}")
	public String deleteProf(@PathVariable Long id){
		profService.deleteProf(id);
		return "redirect:/profesor/list";
	}
}
	