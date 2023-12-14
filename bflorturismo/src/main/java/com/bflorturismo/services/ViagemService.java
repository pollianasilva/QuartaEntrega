package com.bflorturismo.services;

import java.util.List;

import com.bflorturismo.dto.ViagemDTO;
import com.bflorturismo.models.Viagem;

public interface ViagemService {

	List<Viagem> getAllViagens();
	
	Viagem getViagemById(Long id);
	
	Viagem saveViagem(ViagemDTO viagemDTO);
	
	Viagem updateViagem(Long id, ViagemDTO viagemDTOUpdated);
	
	void deleteById(Long id);
	
void addRelationship(Long viagemId, Long usuarioId);
	
	List<Object> findAllRels();
	
		
	
}
