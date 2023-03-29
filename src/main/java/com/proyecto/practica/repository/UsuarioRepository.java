package com.proyecto.practica.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyecto.practica.entity.UsuarioDTO;

public interface UsuarioRepository extends JpaRepository<UsuarioDTO, Integer>{
	
	/*Para consultar la base de datos que debe coincidir con cualquiera de las columnas, 
	 * necesitamos crear un método como este:
	 * findByNameOrLocation(String name, String location)
	 * 
	 * Para consultar la base de datos que debe coincidir con el nombre y la ubicación, 
	 * necesitamos crear un método como este:
	 * findByNameAndLocation(String name, String location)
	 * 
	 * "ContainingIgnoreCase" es una función que se utiliza para realizar búsquedas 
	 * insensibles a mayúsculas y minúsculas en Spring Data JPA
	 * */
	List<UsuarioDTO> findByNomUsuContainingIgnoreCaseAndPatUsuContainingIgnoreCase(String nomUsu, String patUsu);
}
