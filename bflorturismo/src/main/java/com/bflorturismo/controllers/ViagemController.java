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

import com.bflorturismo.dto.ViagemDTO;
import com.bflorturismo.models.Viagem;
import com.bflorturismo.services.ViagemService;


//import io.swagger.v3.oas.annotations.parameters.RequestBody;



	@RestController
	@RequestMapping("/viagens")
	public class ViagemController {

		@Autowired
		private ViagemService vr;

		@PostMapping("/saveviagem")
		public Viagem createViagem(@RequestBody ViagemDTO viagemDto) {

			return vr.saveViagem(viagemDto);
		}

		@GetMapping("/allviagens")
		public List<Viagem> getAllViagens() {

			return vr.getAllViagens();
		}


		@GetMapping("/{id}")
		public ResponseEntity<Viagem> getViagemById(@PathVariable Long id){
			Viagem viagem = vr.getViagemById(id);
			
			return ResponseEntity.ok(viagem);
		}


		@PutMapping("/{id}")
		public ResponseEntity<Viagem> updateViagem(@PathVariable Long id, @RequestBody ViagemDTO viagemDTOUpdated){
			Viagem viagem = vr.getViagemById(id);
			

			
			vr.updateViagem(id, viagemDTOUpdated);
			
			return ResponseEntity.ok(viagem);
		}


		@DeleteMapping("/{id}")
		public void deleteViagem(@PathVariable Long id) {
			vr.deleteById(id);
}
}