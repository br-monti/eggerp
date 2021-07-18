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
import com.egg.domain.model.EggType;
import com.egg.domain.repository.EggTypeRepository;
import com.egg.domain.repository.filter.EggTypeFilter;
import com.egg.domain.service.EggTypeService;

@RestController
@RequestMapping("/EggTypes")
public class EggTypeResource {
	
	@Autowired
	private EggTypeRepository eggTypeRepository;
	
	@Autowired
	private EggTypeService eggTypeService;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@GetMapping
	//@PreAuthorize("hasAuthority('ROLE_PESQUISAR_CATEGORIA') and #oauth2.hasScope('read')") TODO: Casdastrar role
	public Page<EggType> findByFilter(EggTypeFilter eggTypeFilter, Pageable pageable) {
		return eggTypeRepository.findByFilter(eggTypeFilter, pageable);
	}
	
	@PostMapping
	//@PreAuthorize("hasAuthority('ROLE_CADASTRAR_CATEGORIA') and #oauth2.hasScope('write')") TODO: Casdastrar role
	public ResponseEntity<EggType> create(@Valid @RequestBody EggType eggType, HttpServletResponse response) {
		EggType eggTypeSaved = eggTypeService.save(eggType);
		publisher.publishEvent(new ResourceCreatedEvent(this, response, eggTypeSaved.getId()));
		return ResponseEntity.status(HttpStatus.CREATED).body(eggTypeSaved);
	}
	
	@GetMapping("/{id}")
	//@PreAuthorize("hasAuthority('ROLE_PESQUISAR_CATEGORIA') and #oauth2.hasScope('read')") TODO: Casdastrar role
	public ResponseEntity<EggType> findById(@PathVariable Long id) {
		EggType eggType = eggTypeRepository.findById(id).orElse(null);
		 return eggType != null ? ResponseEntity.ok(eggType) : ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	//@PreAuthorize("hasAuthority('ROLE_REMOVER_PESSOA') and #oauth2.hasScope('write')")
	public void deleteById(@PathVariable Long id) {
		eggTypeRepository.deleteById(id);
	}
	
	@PutMapping("/{id}")
	//@PreAuthorize("hasAuthority('ROLE_CADASTRAR_PESSOA') and #oauth2.hasScope('write')")
	public ResponseEntity<EggType> update(@PathVariable Long id, @Valid @RequestBody EggType eggType) {
		EggType eggTypeSaved = eggTypeService.update(id, eggType);
		return ResponseEntity.ok(eggTypeSaved);
	}

}
