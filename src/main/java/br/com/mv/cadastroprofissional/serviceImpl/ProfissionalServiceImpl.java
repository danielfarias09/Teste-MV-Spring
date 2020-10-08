package br.com.mv.cadastroprofissional.serviceImpl;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mv.cadastroprofissional.model.Profissional;
import br.com.mv.cadastroprofissional.repository.ProfissionalRepository;
import br.com.mv.cadastroprofissional.service.ProfissionalService;

@Service
public class ProfissionalServiceImpl implements ProfissionalService{
	
	@Autowired
	private ProfissionalRepository profissionalRepository;

	@Override
	public Profissional save(Profissional profissional) {
		return profissionalRepository.save(profissional);
	}

	@Override
	public void delete(Long id) {
		profissionalRepository.deleteById(id);
		
	}

	@Override
	public List<Profissional> list() { 
		if(profissionalRepository.findAll().isEmpty()) {
			return Arrays.asList(new Profissional(1L, "Daniel Farias"), new Profissional(2L, "Izabel Farias"));
		}
		return profissionalRepository.findAll();
	}

	@Override
	public Optional<Profissional> get(Long id) {
		return profissionalRepository.findById(id);
	}

}
