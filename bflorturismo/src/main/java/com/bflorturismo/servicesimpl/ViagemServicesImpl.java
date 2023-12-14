package com.bflorturismo.servicesimpl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bflorturismo.dto.ViagemDTO;
import com.bflorturismo.models.Viagem;
import com.bflorturismo.models.Usuario;
import com.bflorturismo.repositories.UsuarioRepository;
import com.bflorturismo.repositories.ViagemRepository;
import com.bflorturismo.services.ViagemService;
 
@Service
public class ViagemServicesImpl implements ViagemService {
 
	@Autowired
	private ModelMapper mp;

	@Autowired
	private ViagemRepository vr;

	@Autowired
	private UsuarioRepository ur;

	@Override
	public List<Viagem> getAllViagens() {

		return vr.findAll();
	}

	@Override
	public Viagem getViagemById(Long id) {

		return vr.findById(id).orElseThrow(() -> new RuntimeException("ID: " + id + "Not Found"));
	}

	@Override
	public Viagem saveViagem(ViagemDTO viagemDTO) {
		Viagem viagem = mp.map(viagemDTO, Viagem.class);
		
		
		return vr.save(viagem);
	}

	@Override
	public Viagem updateViagem(Long id, ViagemDTO viagemDTOUpdated) {
		Viagem viagemExists = vr.findById(id).orElseThrow(() -> new RuntimeException("ID: " + id + "Not Found"));
		viagemExists.setDestinoViagem(viagemDTOUpdated.getDestinoViagem());
		viagemExists.setValorPassagem(viagemDTOUpdated.getValorPassagem());
		viagemExists.setValorPromocional(viagemDTOUpdated.getValorPromocional());
		 viagemExists.setPromocao(viagemDTOUpdated.isPromocao());
		viagemExists.setIda(viagemDTOUpdated.getIda());
		viagemExists.setVolta(viagemDTOUpdated.getVolta());
		viagemExists.setValorTotal(viagemDTOUpdated.getValorTotal());
		
		
		
		return vr.save(viagemExists);
	}

	@Override
	public void deleteById(Long id) {
		vr.deleteById(id);

	}

	@Override
	public void addRelationship(Long viagemId, Long usuarioId) {
		Viagem viagem = vr.findById(viagemId).orElseThrow(() -> new RuntimeException("ID: " + viagemId + "Not Found"));
		Usuario usuario = ur.findById(usuarioId).orElseThrow(() -> new RuntimeException("ID: " + usuarioId + "Not Found"));
		
		if(viagem != null && usuario != null) {
			viagem.getUsuarios().add(usuario);
			usuario.getViagens().add(viagem);
			
			vr.save(viagem);
			ur.save(usuario);
		}
		
		
		
	}

	@Override
	public List<Object> findAllRels() {
		
		return vr.findAllRels();
	}
	
 
}
