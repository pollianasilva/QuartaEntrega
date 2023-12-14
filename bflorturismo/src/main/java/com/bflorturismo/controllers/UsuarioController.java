package com.bflorturismo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.bflorturismo.models.Usuario;

import com.bflorturismo.services.UsuarioService;
//import io.swagger.v3.oas.annotations.parameters.RequestBody;


@RestController
@RequestMapping("/usuario")
public class UsuarioController {	

	@Autowired
	private UsuarioService ur;
	@PostMapping("/saveusuario")
	public Usuario createUsuario(@RequestBody Usuario usuario) {

		return ur.saveUsuario(usuario);

	}

	@GetMapping("/allusuarios")
	public List<Usuario> getAllUsuarios() {
		return ur.getAllUsuarios();
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<Usuario> getUsuario(@PathVariable Long id){
		Usuario usuario = ur.getUsuarioById(id);
		return ResponseEntity.ok(usuario);
	}	
	
	@PutMapping("/{id}")
	public ResponseEntity<Usuario> updateUsuario(@PathVariable Long id,@RequestBody Usuario usuarioUpdated){
		Usuario usuario = ur.getUsuarioById(id);
		usuario.setNomeCompleto(usuarioUpdated.getNomeCompleto());
		usuario.setCpf(usuarioUpdated.getCpf());
		usuario.setEndereco(usuarioUpdated.getEndereco());
		usuario.setEmail(usuarioUpdated.getEmail());
		usuario.setSenha(usuarioUpdated.getSenha());
		
		ur.saveUsuario(usuario);
		
		return  ResponseEntity.ok(usuario);
	}
 
	@DeleteMapping("/{id}")
	public void deleteUsuario(@PathVariable Long id) {
		ur.deleteById(id);
	}

}
