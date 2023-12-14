package com.bflorturismo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bflorturismo.models.Usuario;

import jakarta.transaction.Transactional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	@Transactional
	@Modifying
	@Query(nativeQuery= true, value= "INSERT INTO usuario_viagem(usuario_id, viagem_id) VALUES (:usuarioId, :viagemId)")
	void addRelationship(@Param("usuarioId") Long usuarioId, @Param("viagemId") Long viagemId);

 
	
	@Query(nativeQuery= true, 
			value = "SELECT DISTINCT u.usuario_name, v.viagem_name "
			+ " FROM usuario_viagem as uv"
			+ " INNER JOIN usuario as u"
			+ " ON u.id = ur.usuario_id"
			+ " INNER JOIN viagem as v"
			+ " ON v.id = ur.viagem_id"
			)
	List<Object> findAllRels();
	
	
}
