package com.bflorturismo.services;

import java.util.List;

import com.bflorturismo.models.Usuario;

public interface UsuarioService {
	
	
	

	List<Usuario> getAllUsuarios();
	
	Usuario getUsuarioById(Long id);

	Usuario saveUsuario(Usuario usuario);

	Usuario updateUsuario(Long id, Usuario usuarioUpdated);

	void  deleteById(Long id);

	
	
	
}
