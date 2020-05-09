package br.com.mv.cadastroprofissional.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mv.cadastroprofissional.model.Estabelecimento;
import br.com.mv.cadastroprofissional.repository.EstabelecimentoRepository;
import br.com.mv.cadastroprofissional.service.EstabelecimentoService;

@Service
public class EstabelecimentoServiceImpl implements EstabelecimentoService{
	
	@Autowired
	private EstabelecimentoRepository estabelecimentoRepository;

	@Override
	public Estabelecimento save(Estabelecimento estabelecimento) {
		return estabelecimentoRepository.save(estabelecimento);
	}

	@Override
	public void delete(Long id) {
		estabelecimentoRepository.deleteById(id);	
	}

	@Override
	public List<Estabelecimento> list(String nome) {	
		if(nome.isEmpty()) {
			return estabelecimentoRepository.findAll();
		}else {
			return estabelecimentoRepository.findByNomeContainingIgnoreCase(nome);
		}
		
	}

	@Override
	public Optional<Estabelecimento> get(Long id) {
		return estabelecimentoRepository.findById(id);
	}

}
