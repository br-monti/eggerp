package com.egg.api.resource;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
import com.egg.domain.model.CreationMonitoring;
import com.egg.domain.repository.CreationMonitoringRepository;
import com.egg.domain.repository.filter.CreationMonitoringFilter;
import com.egg.domain.service.CreationMonitoringService;

@RestController
@RequestMapping("/CreationMonitorings")
public class CreationMonitoringResource {
	
	@Autowired
	private CreationMonitoringRepository creationMonitoringRepository;
	
	@Autowired
	private CreationMonitoringService creationMonitoringService;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@GetMapping
	//@PreAuthorize("hasAuthority('ROLE_PESQUISAR_CATEGORIA') and #oauth2.hasScope('read')") TODO: Casdastrar role
	public Page<CreationMonitoring> findByFilter(CreationMonitoringFilter creationMonitoringFilter, Pageable pageable) {
		return creationMonitoringRepository.findByFilter(creationMonitoringFilter, pageable);
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
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	//@PreAuthorize("hasAuthority('ROLE_REMOVER_PESSOA') and #oauth2.hasScope('write')")
	public void deleteById(@PathVariable Long id) {
		creationMonitoringRepository.deleteById(id);
	}
	
	@PutMapping("/{id}")
	//@PreAuthorize("hasAuthority('ROLE_CADASTRAR_PESSOA') and #oauth2.hasScope('write')")
	public ResponseEntity<CreationMonitoring> update(@PathVariable Long id, @Valid @RequestBody CreationMonitoring creationMonitoring) {
		CreationMonitoring creationMonitoringSaved = creationMonitoringService.update(id, creationMonitoring);
		return ResponseEntity.ok(creationMonitoringSaved);
	}

}
