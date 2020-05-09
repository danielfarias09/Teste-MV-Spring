package br.com.mv.cadastroprofissional.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.mv.cadastroprofissional.model.Estabelecimento;

@Repository
public interface EstabelecimentoRepository extends JpaRepository<Estabelecimento, Long>{
	
	public List<Estabelecimento> findByNomeContainingIgnoreCase(String nome);

}
