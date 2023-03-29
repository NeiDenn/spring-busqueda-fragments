package com.proyecto.practica.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.practica.entity.UsuarioDTO;
import com.proyecto.practica.repository.UsuarioRepository;

@Service
public class UsuarioService {

	// injection
	@Autowired
	private UsuarioRepository repoUsuario;

	public List<UsuarioDTO> listarUsuarios() {
		return repoUsuario.findAll();
	}
	
	public List<UsuarioDTO> buscarXParametrosJPA(String nomUsu, String patUsu){
		return repoUsuario.findByNomUsuContainingIgnoreCaseAndPatUsuContainingIgnoreCase(nomUsu, patUsu);
	}

}
