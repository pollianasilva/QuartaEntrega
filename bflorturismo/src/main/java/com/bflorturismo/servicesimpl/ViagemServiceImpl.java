//package com.bflorturismo.servicesimpl;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.bflorturismo.models.Viagem;
//import com.bflorturismo.repositories.ViagemRepository;
//import com.bflorturismo.services.ViagemService;
//
//@Service
//public class ViagemServiceImpl implements ViagemService {
//
//	
//	
//	
//	@Autowired
//	private ViagemRepository cr;
//	
//	@Override
//	public List<Viagem> getAllViagens() {
//
//		return cr.findAll();
//	}
//
//	@Override
//	public Viagem getViagemByID(Long id) {
//	
//		return cr.findById(id).orElseThrow(()-> new RuntimeException("Deu ruim no getById"));
//	}
//
//	@Override
//	public Viagem saveViagem(Viagem viagem) {
//
//		return cr.save(viagem);
//	}
//
//	@Override
//	public Viagem updateViagem(Long id, Viagem viagemUpdated) {
//		Viagem viagemExists = cr.findById(id).orElseThrow(()-> new RuntimeException("Deu ruim no getById"));
//		viagemExists.setName(viagemUpdated.getName());
//		
//		
//		return cr.save(viagemExists);
//	}
//
//	@Override
//	public void deleteByID(Long id) {
//		cr.deleteById(id);
//		
//	}
//
//	
//	
//	
//	
//	
//	
//	
//	
//	
//}
