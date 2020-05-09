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
import org.springframework.web.bind.annotation.RestController;

import br.com.mv.cadastroprofissional.model.Profissional;
import br.com.mv.cadastroprofissional.service.ProfissionalService;

@RestController
@RequestMapping("/profissionais")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProfissionalController {
	
	@Autowired
	private ProfissionalService profissionalService;
	
	@PostMapping
	public ResponseEntity<Profissional> create(@RequestBody Profissional profissional) {
		profissional = profissionalService.save(profissional);
		return new ResponseEntity<Profissional>(profissional, HttpStatus.OK);
	}
	
	@PutMapping(value="/{id}")
	public ResponseEntity<Profissional> edit(@PathVariable("id") Long id, @RequestBody Profissional profissional) {
		profissional = profissionalService.save(profissional);
		return new ResponseEntity<Profissional>(profissional, HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<List<Profissional>> getAll(){
    	List<Profissional> profissionais = profissionalService.list();
		return new ResponseEntity<List<Profissional>>(profissionais, HttpStatus.OK);
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<?> get(@PathVariable("id") Long id){
    	return profissionalService.get(id)
    			.map(profissional -> ResponseEntity.ok().body(profissional))
    			.orElse(ResponseEntity.notFound().build());
	}
	
	@DeleteMapping(path ={"/{id}"})
	public ResponseEntity<?> delete(@PathVariable("id") Long id) {
		return profissionalService.get(id)
				.map(profissional -> {
					profissionalService.delete(id);
					return ResponseEntity.ok().build();
				})
				.orElse(ResponseEntity.notFound().build());
	}

}
