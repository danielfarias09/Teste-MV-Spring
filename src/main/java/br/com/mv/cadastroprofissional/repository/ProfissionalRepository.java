package br.com.mv.cadastroprofissional.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.mv.cadastroprofissional.model.Profissional;

@Repository
public interface ProfissionalRepository extends JpaRepository<Profissional, Long>{

}
