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
import com.egg.api.model.EggLot;
import com.egg.api.repository.EggLotRepository;
import com.egg.api.repository.filter.EggLotFilter;
import com.egg.api.service.EggLotService;

@RestController
@RequestMapping("/EggLots")
public class EggLotResource {
	
	@Autowired
	private EggLotRepository eggLotRepository;
	
	@Autowired
	private EggLotService eggLotService;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@GetMapping
	//@PreAuthorize("hasAuthority('ROLE_PESQUISAR_CATEGORIA') and #oauth2.hasScope('read')") TODO: Casdastrar role
	public Page<EggLot> findByFilter(EggLotFilter eggLotFilter, Pageable pageable) {
		return eggLotRepository.findByFilter(eggLotFilter, pageable);
	}
	
	@PostMapping
	//@PreAuthorize("hasAuthority('ROLE_CADASTRAR_CATEGORIA') and #oauth2.hasScope('write')") TODO: Casdastrar role
	public ResponseEntity<EggLot> create(@Valid @RequestBody EggLot eggLot, HttpServletResponse response) {
		EggLot eggLotSaved = eggLotRepository.save(eggLot);
		publisher.publishEvent(new ResourceCreatedEvent(this, response, eggLotSaved.getId()));
		return ResponseEntity.status(HttpStatus.CREATED).body(eggLotSaved);
	}
	
	@GetMapping("/{id}")
	//@PreAuthorize("hasAuthority('ROLE_PESQUISAR_CATEGORIA') and #oauth2.hasScope('read')") TODO: Casdastrar role
	public ResponseEntity<EggLot> findById(@PathVariable Long id) {
		EggLot eggLot = eggLotRepository.findById(id).orElse(null);
		 return eggLot != null ? ResponseEntity.ok(eggLot) : ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	//@PreAuthorize("hasAuthority('ROLE_REMOVER_PESSOA') and #oauth2.hasScope('write')")
	public void deleteById(@PathVariable Long id) {
		eggLotRepository.deleteById(id);
	}
	
	@PutMapping("/{id}")
	//@PreAuthorize("hasAuthority('ROLE_CADASTRAR_PESSOA') and #oauth2.hasScope('write')")
	public ResponseEntity<EggLot> update(@PathVariable Long id, @Valid @RequestBody EggLot eggLot) {
		EggLot eggLotSaved = eggLotService.update(id, eggLot);
		return ResponseEntity.ok(eggLotSaved);
	}

}
