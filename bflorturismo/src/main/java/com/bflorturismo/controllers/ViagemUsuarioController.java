package com.bflorturismo.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bflorturismo.dto.ViagemUsuarioDTO;
import com.bflorturismo.services.ViagemService;


 

 
@RestController
@RequestMapping("/viagemrelusuario")


public class ViagemUsuarioController {

	@Autowired
	private ViagemService vr;



	@PostMapping("/addviagemusuario")
	public ResponseEntity<String> addRelationship(@RequestBody ViagemUsuarioDTO vrDTO){
		vr.addRelationship(vrDTO.getViagemId(), vrDTO.getUsuarioId());
		
		
		return new ResponseEntity<>("Relatioship created", HttpStatus.CREATED);
		
		
	}



	@GetMapping("/findallrels")
	public List<Object> getAllRels(){
		
		
		return vr.findAllRels();
	}

}
