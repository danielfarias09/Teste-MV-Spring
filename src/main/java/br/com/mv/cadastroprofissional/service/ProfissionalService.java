package br.com.mv.cadastroprofissional.service;

import java.util.List;
import java.util.Optional;

import br.com.mv.cadastroprofissional.model.Profissional;

public interface ProfissionalService {
	
	public Profissional save(Profissional profissional);
	
	public void delete(Long id);
	
	public List<Profissional> list();
	
	public Optional<Profissional> get(Long id);

}
