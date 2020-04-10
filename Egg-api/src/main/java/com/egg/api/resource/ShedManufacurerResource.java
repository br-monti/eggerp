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
import com.egg.api.model.ShedManufacturer;
import com.egg.api.repository.ShedManufacurerRepository;

@RestController
@RequestMapping("/ShedManufacturers")
public class ShedManufacurerResource {
	
	@Autowired
	private ShedManufacurerRepository shedManufacurerRepository;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@GetMapping
	//@PreAuthorize("hasAuthority('ROLE_PESQUISAR_CATEGORIA') and #oauth2.hasScope('read')") TODO: Casdastrar role
	public List<ShedManufacturer> findAll() {
		return shedManufacurerRepository.findAll();
	}
	
	@PostMapping
	//@PreAuthorize("hasAuthority('ROLE_CADASTRAR_CATEGORIA') and #oauth2.hasScope('write')") TODO: Casdastrar role
	public ResponseEntity<ShedManufacturer> create(@Valid @RequestBody ShedManufacturer shedManufacturer, HttpServletResponse response) {
		ShedManufacturer shedManufacturerSaved = shedManufacurerRepository.save(shedManufacturer);
		publisher.publishEvent(new ResourceCreatedEvent(this, response, shedManufacturerSaved.getId()));
		return ResponseEntity.status(HttpStatus.CREATED).body(shedManufacturerSaved);
	}
	
	@GetMapping("/{id}")
	//@PreAuthorize("hasAuthority('ROLE_PESQUISAR_CATEGORIA') and #oauth2.hasScope('read')") TODO: Casdastrar role
	public ResponseEntity<ShedManufacturer> findById(@PathVariable Long id) {
		ShedManufacturer shedManufacturer = shedManufacurerRepository.findById(id).orElse(null);
		 return shedManufacturer != null ? ResponseEntity.ok(shedManufacturer) : ResponseEntity.notFound().build();
	}
	

}
