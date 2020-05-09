package br.com.mv.cadastroprofissional.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.mv.cadastroprofissional.model.Estabelecimento;
import br.com.mv.cadastroprofissional.service.EstabelecimentoService;

@RestController
@RequestMapping("/estabelecimentos")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class EstabelecimentoController {
	
	@Autowired
	private EstabelecimentoService estabelecimentoService;
	
	@PostMapping
	public ResponseEntity<Estabelecimento> create(@RequestBody Estabelecimento estabelecimento) {
		estabelecimento = estabelecimentoService.save(estabelecimento);
		return new ResponseEntity<Estabelecimento>(estabelecimento, HttpStatus.OK);
	}
	
	@PutMapping(value="/{id}")
	public ResponseEntity<Estabelecimento> edit(@PathVariable("id") Long id, @RequestBody Estabelecimento estabelecimento) {
		estabelecimento = estabelecimentoService.save(estabelecimento);
		return new ResponseEntity<Estabelecimento>(estabelecimento, HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<List<Estabelecimento>> getAll(@RequestParam(value = "nome", required = false) String nome){
    	List<Estabelecimento> estabelecimentos = estabelecimentoService.list(nome);
		return new ResponseEntity<List<Estabelecimento>>(estabelecimentos, HttpStatus.OK);
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<?> get(@PathVariable("id") Long id){
    	return estabelecimentoService.get(id)
    			.map(estabelecimento -> ResponseEntity.ok().body(estabelecimento))
    			.orElse(ResponseEntity.notFound().build());
	}
	
	@DeleteMapping(path ={"/{id}"})
	public ResponseEntity<?> delete(@PathVariable("id") Long id) {
		return estabelecimentoService.get(id)
				.map(estabelecimento -> {
					estabelecimentoService.delete(id);
					return ResponseEntity.ok().build();
				})
				.orElse(ResponseEntity.notFound().build());
	}


}
