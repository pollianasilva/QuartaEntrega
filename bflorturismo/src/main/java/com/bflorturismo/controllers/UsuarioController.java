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
import org.springframework.web.bind.annotation.RestController;

import com.bflorturismo.models.Usuario;
import com.bflorturismo.repositories.UsuarioRepository;
//import io.swagger.v3.oas.annotations.parameters.RequestBody;
@RestController
public class UsuarioController {
	

	@Autowired
	private UsuarioRepository usuarioRepo;

	@PostMapping("/saveusuario")
	public Usuario createUsuario(@RequestBody Usuario usuario) {

		return usuarioRepo.save(usuario);

	}

	@GetMapping("/allusuarios")
	public List<Usuario> getAllUsuarios() {

		return usuarioRepo.findAll();
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<Usuario> getUsuarioById(@PathVariable Long id){
		Usuario usuario = usuarioRepo.findById(id).get();
		
		return ResponseEntity.ok(usuario);
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<Usuario> updateUsuario(@PathVariable Long id, @RequestBody Usuario usuarioUpdated){
		Usuario usuario = usuarioRepo.findById(id).get();
		
		usuarioUpdated.setId(id);
		
		usuarioRepo.save(usuarioUpdated);
		
		return ResponseEntity.ok(usuario);
	}
	
	
	@DeleteMapping("/{id}")
	public void deleteUsuario(@PathVariable Long id) {
		usuarioRepo.deleteById(id);
	}
	

}
