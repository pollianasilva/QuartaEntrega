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

import com.bflorturismo.models.Viagem;
import com.bflorturismo.repositories.ViagemRepository;


//import io.swagger.v3.oas.annotations.parameters.RequestBody;



	@RestController
	@RequestMapping("/viagens")
	public class ViagemController {

		@Autowired
		private ViagemRepository viagemRepo;

		@PostMapping("/saveviagem")
		public Viagem createViagem(@RequestBody Viagem viagem) {

			return viagemRepo.save(viagem);
		}

		@GetMapping("/allviagens")
		public List<Viagem> getAllViagens() {

			return viagemRepo.findAll();
		}
		
		
		@GetMapping("/{id}")
		public ResponseEntity<Viagem> getViagemById(@PathVariable Long id){
			Viagem viagem = viagemRepo.findById(id).get();
			
			return ResponseEntity.ok(viagem);
		}
		
		
		@PutMapping("/{id}")
		public ResponseEntity<Viagem> updateViagem(@PathVariable Long id, @RequestBody Viagem viagemUpdated){
			Viagem viagem = viagemRepo.findById(id).get();
			
			viagemUpdated.setId(id);
			
			viagemRepo.save(viagemUpdated);
			
			return ResponseEntity.ok(viagem);
		}
		
		
		@DeleteMapping("/{id}")
		public void deleteViagem(@PathVariable Long id) {
			viagemRepo.deleteById(id);
		}
		
	
}
