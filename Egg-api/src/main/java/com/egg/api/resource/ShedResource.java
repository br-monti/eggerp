package com.egg.api.resource;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.egg.api.event.ResourceCreatedEvent;
import com.egg.api.model.Shed;
import com.egg.api.repository.ShedRepository;

@RestController
@RequestMapping("/Sheds")
public class ShedResource {
	
	@Autowired
	private ShedRepository shedRepository;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@GetMapping
	//@PreAuthorize("hasAuthority('ROLE_PESQUISAR_CATEGORIA') and #oauth2.hasScope('read')") TODO: Casdastrar role
	public List<Shed> findAll() {
		return shedRepository.findAll();
	}
	
	@PostMapping
	//@PreAuthorize("hasAuthority('ROLE_CADASTRAR_CATEGORIA') and #oauth2.hasScope('write')") TODO: Casdastrar role
	public ResponseEntity<Shed> create(@Valid @RequestBody Shed shed, HttpServletResponse response) {
		Shed shedSaved = shedRepository.save(shed);
		publisher.publishEvent(new ResourceCreatedEvent(this, response, shedSaved.getId()));
		return ResponseEntity.status(HttpStatus.CREATED).body(shedSaved);
	}
	
	@GetMapping("/{id}")
	//@PreAuthorize("hasAuthority('ROLE_PESQUISAR_CATEGORIA') and #oauth2.hasScope('read')") TODO: Casdastrar role
	public ResponseEntity<Shed> findById(@PathVariable Long id) {
		Shed shed = shedRepository.findById(id).orElse(null);
		 return shed != null ? ResponseEntity.ok(shed) : ResponseEntity.notFound().build();
	}
	

}
