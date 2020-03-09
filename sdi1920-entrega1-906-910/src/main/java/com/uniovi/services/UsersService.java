package com.uniovi.services;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.uniovi.entities.Usuario;
import com.uniovi.repositories.UsersRepository;

@Service
public class UsersService {

	@Autowired
	private UsersRepository usersRepository;

	public List<Usuario> getUsuarios(){
		List<Usuario> usuarios = new ArrayList<Usuario>();
		usersRepository.findAll().forEach(usuarios::add);
		return usuarios;
	}

	public Usuario getUsuario(Long id){
		return usersRepository.findById(id).get();
	}

	public void addUsuario(Usuario usuario){
		usersRepository.save(usuario);
	}

	public void deleteUsuario(Long id){
		usersRepository.deleteById(id);
	}

}