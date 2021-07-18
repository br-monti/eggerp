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
import com.egg.domain.model.Packing;
import com.egg.domain.repository.PackingRepository;
import com.egg.domain.repository.filter.PackingFilter;
import com.egg.domain.service.PackingService;

@RestController
@RequestMapping("/Packings")
public class PackingResource {
	
	@Autowired
	private PackingRepository packingRepository;
	
	@Autowired
	private PackingService packingService;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@GetMapping
	//@PreAuthorize("hasAuthority('ROLE_PESQUISAR_CATEGORIA') and #oauth2.hasScope('read')") TODO: Casdastrar role
	public Page<Packing> findByFilter(PackingFilter packingFilter, Pageable pageable) {
		return packingRepository.findByFilter(packingFilter, pageable);
	}
	
	@PostMapping
	//@PreAuthorize("hasAuthority('ROLE_CADASTRAR_CATEGORIA') and #oauth2.hasScope('write')") TODO: Casdastrar role
	public ResponseEntity<Packing> create(@Valid @RequestBody Packing packing, HttpServletResponse response) {
		Packing packingSaved = packingService.save(packing);
		publisher.publishEvent(new ResourceCreatedEvent(this, response, packingSaved.getId()));
		return ResponseEntity.status(HttpStatus.CREATED).body(packingSaved);
	}
	
	@GetMapping("/{id}")
	//@PreAuthorize("hasAuthority('ROLE_PESQUISAR_CATEGORIA') and #oauth2.hasScope('read')") TODO: Casdastrar role
	public ResponseEntity<Packing> findById(@PathVariable Long id) {
		Packing packing = packingRepository.findById(id).orElse(null);
		 return packing != null ? ResponseEntity.ok(packing) : ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	//@PreAuthorize("hasAuthority('ROLE_REMOVER_PESSOA') and #oauth2.hasScope('write')")
	public void deleteById(@PathVariable Long id) {
		packingRepository.deleteById(id);
	}
	
	@PutMapping("/{id}")
	//@PreAuthorize("hasAuthority('ROLE_CADASTRAR_PESSOA') and #oauth2.hasScope('write')")
	public ResponseEntity<Packing> update(@PathVariable Long id, @Valid @RequestBody Packing packing) {
		Packing packingSaved = packingService.update(id, packing);
		return ResponseEntity.ok(packingSaved);
	}

}
