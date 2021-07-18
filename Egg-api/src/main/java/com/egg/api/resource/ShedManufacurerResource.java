package com.egg.api.resource;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.egg.api.event.ResourceCreatedEvent;
import com.egg.domain.model.ShedManufacturer;
import com.egg.domain.repository.ShedManufacturerRepository;
import com.egg.domain.service.ShedManufacturerService;

@RestController
@RequestMapping("/ShedManufacturers")
public class ShedManufacurerResource {
	
	@Autowired
	private ShedManufacturerRepository shedManufacturerRepository;
	
	@Autowired
	private ShedManufacturerService shedManufacturerService;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@GetMapping
	//@PreAuthorize("hasAuthority('ROLE_PESQUISAR_CATEGORIA') and #oauth2.hasScope('read')") TODO: Casdastrar role
	public List<ShedManufacturer> findAll() {
		return shedManufacturerRepository.findAll();
	}
	
	@PostMapping
	//@PreAuthorize("hasAuthority('ROLE_CADASTRAR_CATEGORIA') and #oauth2.hasScope('write')") TODO: Casdastrar role
	public ResponseEntity<ShedManufacturer> create(@Valid @RequestBody ShedManufacturer shedManufacturer, HttpServletResponse response) {
		ShedManufacturer shedManufacturerSaved = shedManufacturerRepository.save(shedManufacturer);
		publisher.publishEvent(new ResourceCreatedEvent(this, response, shedManufacturerSaved.getId()));
		return ResponseEntity.status(HttpStatus.CREATED).body(shedManufacturerSaved);
	}
	
	@GetMapping("/{id}")
	//@PreAuthorize("hasAuthority('ROLE_PESQUISAR_CATEGORIA') and #oauth2.hasScope('read')") TODO: Casdastrar role
	public ResponseEntity<ShedManufacturer> findById(@PathVariable Long id) {
		ShedManufacturer shedManufacturer = shedManufacturerRepository.findById(id).orElse(null);
		 return shedManufacturer != null ? ResponseEntity.ok(shedManufacturer) : ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	//@PreAuthorize("hasAuthority('ROLE_REMOVER_PESSOA') and #oauth2.hasScope('write')")
	public void deleteById(@PathVariable Long id) {
		shedManufacturerRepository.deleteById(id);
	}
	
	@PutMapping("/{id}")
	//@PreAuthorize("hasAuthority('ROLE_CADASTRAR_PESSOA') and #oauth2.hasScope('write')")
	public ResponseEntity<ShedManufacturer> update(@PathVariable Long id, @Valid @RequestBody ShedManufacturer shedManufacturer) {
		ShedManufacturer shedManufacturerSaved = shedManufacturerService.update(id, shedManufacturer);
		return ResponseEntity.ok(shedManufacturerSaved);
	}
	

}
