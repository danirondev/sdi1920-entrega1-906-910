package com.uniovi.services;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uniovi.entities.Profesor;
import com.uniovi.repositories.ProfesorRepository;

@Service
public class ProfesorService {
	
	@Autowired
	private ProfesorRepository profRepository;
	
	 public List<Profesor> getProfs(){
		 List<Profesor> profs = new ArrayList<Profesor>();
		 profRepository.findAll().forEach(profs::add);
		 return profs;
	 }
	 public Profesor getProf(Long id){
		 return profRepository.findById(id).get();
	 }
	 public void addProf(Profesor prof){
		 profRepository.save(prof);
	 }
	 public void deleteProf(Long id){
		 profRepository.deleteById(id);	 }
}
