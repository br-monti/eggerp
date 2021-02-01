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
import com.egg.api.model.EggBase;
import com.egg.api.repository.EggBaseRepository;
import com.egg.api.repository.filter.EggBaseFilter;
import com.egg.api.repository.projection.EggBaseResume;
import com.egg.api.service.EggBaseService;

@RestController
@RequestMapping("/EggBases")
public class EggBaseResource {
	
	@Autowired
	private EggBaseRepository eggBaseRepository;
	
	@Autowired
	private EggBaseService eggBaseService;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@GetMapping
	//@PreAuthorize("hasAuthority('ROLE_PESQUISAR_CATEGORIA') and #oauth2.hasScope('read')") TODO: Casdastrar role
	public Page<EggBaseResume> findByFilter(EggBaseFilter eggBaseFilter, Pageable pageable) {
		return eggBaseRepository.resume(eggBaseFilter, pageable);
	}
	
	@PostMapping
	//@PreAuthorize("hasAuthority('ROLE_CADASTRAR_CATEGORIA') and #oauth2.hasScope('write')") TODO: Casdastrar role
	public ResponseEntity<EggBase> create(@Valid @RequestBody EggBase eggBase, HttpServletResponse response) {
		EggBase eggBaseSaved = eggBaseService.save(eggBase);
		publisher.publishEvent(new ResourceCreatedEvent(this, response, eggBaseSaved.getId()));
		return ResponseEntity.status(HttpStatus.CREATED).body(eggBaseSaved);
	}
	
	@GetMapping("/{id}")
	//@PreAuthorize("hasAuthority('ROLE_PESQUISAR_CATEGORIA') and #oauth2.hasScope('read')") TODO: Casdastrar role
	public ResponseEntity<EggBase> findById(@PathVariable Long id) {
		EggBase eggBase = eggBaseRepository.findById(id).orElse(null);
		 return eggBase != null ? ResponseEntity.ok(eggBase) : ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	//@PreAuthorize("hasAuthority('ROLE_REMOVER_PESSOA') and #oauth2.hasScope('write')")
	public void deleteById(@PathVariable Long id) {
		eggBaseRepository.deleteById(id);
	}
	
	@PutMapping("/{id}")
	//@PreAuthorize("hasAuthority('ROLE_CADASTRAR_PESSOA') and #oauth2.hasScope('write')")
	public ResponseEntity<EggBase> update(@PathVariable Long id, @Valid @RequestBody EggBase eggBase) {
		EggBase eggBaseSaved = eggBaseService.update(id, eggBase);
		return ResponseEntity.ok(eggBaseSaved);
	}

}
