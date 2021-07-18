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
import com.egg.domain.model.ProductionMonitoring;
import com.egg.domain.repository.ProductionMonitoringRepository;
import com.egg.domain.repository.filter.ProductionMonitoringFilter;
import com.egg.domain.service.ProductionMonitoringService;

@RestController
@RequestMapping("/ProductionMonitorings")
public class ProductionMonitoringResource {

	@Autowired
	private ProductionMonitoringRepository productionMonitoringRepository;
	
	@Autowired
	private ProductionMonitoringService productionMonitoringService;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@GetMapping
	//@PreAuthorize("hasAuthority('ROLE_PESQUISAR_CATEGORIA') and #oauth2.hasScope('read')") TODO: Casdastrar role
	public Page<ProductionMonitoring> findByFilter(ProductionMonitoringFilter productionMonitoringFilter, Pageable pageable) {
		return productionMonitoringRepository.findByFilter(productionMonitoringFilter, pageable);
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
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	//@PreAuthorize("hasAuthority('ROLE_REMOVER_PESSOA') and #oauth2.hasScope('write')")
	public void deleteById(@PathVariable Long id) {
		productionMonitoringRepository.deleteById(id);
	}
	
	@PutMapping("/{id}")
	//@PreAuthorize("hasAuthority('ROLE_CADASTRAR_PESSOA') and #oauth2.hasScope('write')")
	public ResponseEntity<ProductionMonitoring> update(@PathVariable Long id, @Valid @RequestBody ProductionMonitoring producutionMonitoring) {
		ProductionMonitoring producutionMonitoringSaved = productionMonitoringService.update(id, producutionMonitoring);
		return ResponseEntity.ok(producutionMonitoringSaved);
	}

}
