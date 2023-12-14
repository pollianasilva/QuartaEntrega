package com.bflorturismo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bflorturismo.models.Viagem;

import jakarta.transaction.Transactional;

@Repository
public interface ViagemRepository extends JpaRepository<Viagem, Long> {

	
	@Transactional
	@Modifying
	@Query(nativeQuery= true, value= "INSERT INTO viagem_usuario (viagem_id, usuario_id) VALUES (:viagemId, :usuarioId)")
	void addRelationship(@Param("viagemId") Long viagemId, @Param("usuarioId") Long usuarioId);
	
	
	
	@Query(nativeQuery = true,
	        value = "SELECT DISTINCT v.viagem_name, u.usuario_name "
	                + " FROM viagem_usuario as vu"
	                + " INNER JOIN viagem as v"
	                + " ON v.id = vu.viagem_id"
	                + " INNER JOIN usuario as u"
	                + " ON u.id = vu.usuario_id"
	)
	List<Object> findAllRels();

}
