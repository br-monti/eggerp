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
import com.egg.api.model.CreationMonitoring;
import com.egg.api.repository.CreationMonitoringRepository;

@RestController
@RequestMapping("/CreationMonitorings")
public class CreationMonitoringResource {
	
	@Autowired
	private CreationMonitoringRepository creationMonitoringRepository;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@GetMapping
	//@PreAuthorize("hasAuthority('ROLE_PESQUISAR_CATEGORIA') and #oauth2.hasScope('read')") TODO: Casdastrar role
	public List<CreationMonitoring> findAll() {
		return creationMonitoringRepository.findAll();
	}
	
	@PostMapping
	//@PreAuthorize("hasAuthority('ROLE_CADASTRAR_CATEGORIA') and #oauth2.hasScope('write')") TODO: Casdastrar role
	public ResponseEntity<CreationMonitoring> create(@Valid @RequestBody CreationMonitoring creationMonitoring, HttpServletResponse response) {
		CreationMonitoring creationMonitoringSaved = creationMonitoringRepository.save(creationMonitoring);
		publisher.publishEvent(new ResourceCreatedEvent(this, response, creationMonitoringSaved.getId()));
		return ResponseEntity.status(HttpStatus.CREATED).body(creationMonitoringSaved);
	}
	
	@GetMapping("/{id}")
	//@PreAuthorize("hasAuthority('ROLE_PESQUISAR_CATEGORIA') and #oauth2.hasScope('read')") TODO: Casdastrar role
	public ResponseEntity<CreationMonitoring> findById(@PathVariable Long id) {
		CreationMonitoring creationMonitoring = creationMonitoringRepository.findById(id).orElse(null);
		 return creationMonitoring != null ? ResponseEntity.ok(creationMonitoring) : ResponseEntity.notFound().build();
	}
}
