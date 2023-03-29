package com.proyecto.practica.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.proyecto.practica.entity.UsuarioDTO;
import com.proyecto.practica.service.UsuarioService;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

	// injection
	@Autowired
	private UsuarioService serviUsuario;
	
	// list
	@RequestMapping("/lista")
	public String inicio(Model model) {

		List<UsuarioDTO> dataUsuario = serviUsuario.listarUsuarios();
		model.addAttribute("listUsuarios", dataUsuario);
		
		return "usuario";
	}
	
	@GetMapping("/buscarUsuario")
	public String searchParametersJPA(@RequestParam("nombre") String nomUsu, @RequestParam("apPaterno") String patUsu, Model model) {	
		try {
			model.addAttribute("listUsuarios", serviUsuario.buscarXParametrosJPA(nomUsu, patUsu));	
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "usuario";
	}
	
}
