package com.bflorturismo.servicesimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.bflorturismo.models.Usuario;

import com.bflorturismo.repositories.UsuarioRepository;
import com.bflorturismo.services.UsuarioService; 

 
@Service
public class UsuarioServiceImpl implements UsuarioService{
	
	@Autowired
	private UsuarioRepository ur;

	@Override
	public List<Usuario> getAllUsuarios() {

		return ur.findAll();
	}

	@Override
	public Usuario getUsuarioById(Long id) {

		return ur.findById(id).orElseThrow(() -> new RuntimeException("ID: " + id + "Not Found"));
	}

	@Override
	public Usuario saveUsuario(Usuario usuario) {

		return ur.save(usuario);
	}

	@Override
	public Usuario updateUsuario(Long id, Usuario usuarioUpdated) {
		Usuario usuarioExists = ur.findById(id).orElseThrow(() -> new RuntimeException("ID: " + id + "Not Found"));
		usuarioExists.setNomeCompleto(usuarioUpdated.getNomeCompleto());
		usuarioExists.setCpf(usuarioUpdated.getCpf());
		usuarioExists.setEndereco(usuarioUpdated.getEndereco());
		usuarioExists.setEmail(usuarioUpdated.getEmail());
		usuarioExists.setSenha(usuarioUpdated.getSenha());

		return ur.save(usuarioExists);
	}

	@Override
	public void deleteById(Long id) {
		ur.deleteById(id);

	}

}
