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
import com.egg.api.model.ProductionMonitoring;
import com.egg.api.repository.ProductionMonitoringRepository;

@RestController
@RequestMapping("/ProductionMonitorings")
public class ProductionMonitoringResource {

	@Autowired
	private ProductionMonitoringRepository productionMonitoringRepository;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@GetMapping
	//@PreAuthorize("hasAuthority('ROLE_PESQUISAR_CATEGORIA') and #oauth2.hasScope('read')") TODO: Casdastrar role
	public List<ProductionMonitoring> findAll() {
		return productionMonitoringRepository.findAll();
	}
	
	@PostMapping
	//@PreAuthorize("hasAuthority('ROLE_CADASTRAR_CATEGORIA') and #oauth2.hasScope('write')") TODO: Casdastrar role
	public ResponseEntity<ProductionMonitoring> create(@Valid @RequestBody ProductionMonitoring productionMonitoring, HttpServletResponse response) {
		ProductionMonitoring productionMonitoringSaved = productionMonitoringRepository.save(productionMonitoring);
		publisher.publishEvent(new ResourceCreatedEvent(this, response, productionMonitoringSaved.getId()));
		return ResponseEntity.status(HttpStatus.CREATED).body(productionMonitoringSaved);
	}
	
	@GetMapping("/{id}")
	//@PreAuthorize("hasAuthority('ROLE_PESQUISAR_CATEGORIA') and #oauth2.hasScope('read')") TODO: Casdastrar role
	public ResponseEntity<ProductionMonitoring> findById(@PathVariable Long id) {
		ProductionMonitoring productionMonitoring = productionMonitoringRepository.findById(id).orElse(null);
		 return productionMonitoring != null ? ResponseEntity.ok(productionMonitoring) : ResponseEntity.notFound().build();
	}
}
