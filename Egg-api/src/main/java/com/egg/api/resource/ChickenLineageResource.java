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
import com.egg.api.model.ChickenLineage;
import com.egg.api.repository.ChickenLineageRepository;


@RestController
@RequestMapping("/ChickenLineages")
public class ChickenLineageResource {
	
	@Autowired
	private ChickenLineageRepository chickenLineageRepository;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@GetMapping
	//@PreAuthorize("hasAuthority('ROLE_PESQUISAR_CATEGORIA') and #oauth2.hasScope('read')") TODO: Casdastrar role
	public List<ChickenLineage> findAll() {
		return chickenLineageRepository.findAll();
	}
	
	@PostMapping
	//@PreAuthorize("hasAuthority('ROLE_CADASTRAR_CATEGORIA') and #oauth2.hasScope('write')") TODO: Casdastrar role
	public ResponseEntity<ChickenLineage> create(@Valid @RequestBody ChickenLineage chickenLineage, HttpServletResponse response) {
		ChickenLineage chickenLineageSaved = chickenLineageRepository.save(chickenLineage);
		publisher.publishEvent(new ResourceCreatedEvent(this, response, chickenLineageSaved.getId()));
		return ResponseEntity.status(HttpStatus.CREATED).body(chickenLineageSaved);
	}
	
	@GetMapping("/{id}")
	//@PreAuthorize("hasAuthority('ROLE_PESQUISAR_CATEGORIA') and #oauth2.hasScope('read')") TODO: Casdastrar role
	public ResponseEntity<ChickenLineage> findById(@PathVariable Long id) {
		 ChickenLineage chickenLineage = chickenLineageRepository.findById(id).orElse(null);
		 return chickenLineage != null ? ResponseEntity.ok(chickenLineage) : ResponseEntity.notFound().build();
	}
	

}
