package br.com.mv.cadastroprofissional.service;

import java.util.List;
import java.util.Optional;

import br.com.mv.cadastroprofissional.model.Estabelecimento;

public interface EstabelecimentoService {
	
	public Estabelecimento save(Estabelecimento estabelecimento);
	
	public void delete(Long id);
	
	public Optional<Estabelecimento> get(Long id);

	public List<Estabelecimento> list(String nome);

}
