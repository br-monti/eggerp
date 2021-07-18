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
import com.egg.domain.model.ChickenLot;
import com.egg.domain.repository.ChickenLotRepository;
import com.egg.domain.repository.filter.ChickenLotFilter;
import com.egg.domain.service.ChickenLotService;

@RestController
@RequestMapping("/ChickenLots")
public class ChickenLotResource {
	
	@Autowired
	private ChickenLotRepository chickenLotRepository;
	
	@Autowired
	private ChickenLotService chickenLotService;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@GetMapping
	//@PreAuthorize("hasAuthority('ROLE_PESQUISAR_CATEGORIA') and #oauth2.hasScope('read')") TODO: Casdastrar role
	public Page<ChickenLot> findByFilter(ChickenLotFilter chickenLoteFilter, Pageable pageable) {
		return chickenLotRepository.findByFilter(chickenLoteFilter, pageable);
	}
	
	@PostMapping
	//@PreAuthorize("hasAuthority('ROLE_CADASTRAR_CATEGORIA') and #oauth2.hasScope('write')") TODO: Casdastrar role
	public ResponseEntity<ChickenLot> create(@Valid @RequestBody ChickenLot chickenLot, HttpServletResponse response) {
		ChickenLot chickenLotSaved = chickenLotRepository.save(chickenLot);
		publisher.publishEvent(new ResourceCreatedEvent(this, response, chickenLotSaved.getId()));
		return ResponseEntity.status(HttpStatus.CREATED).body(chickenLotSaved);
	}
	
	@GetMapping("/{id}")
	//@PreAuthorize("hasAuthority('ROLE_PESQUISAR_CATEGORIA') and #oauth2.hasScope('read')") TODO: Casdastrar role
	public ResponseEntity<ChickenLot> findById(@PathVariable Long id) {
		ChickenLot chickenLot = chickenLotRepository.findById(id).orElse(null);
		 return chickenLot != null ? ResponseEntity.ok(chickenLot) : ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	//@PreAuthorize("hasAuthority('ROLE_REMOVER_PESSOA') and #oauth2.hasScope('write')")
	public void deleteById(@PathVariable Long id) {
		chickenLotRepository.deleteById(id);
	}
	
	@PutMapping("/{id}")
	//@PreAuthorize("hasAuthority('ROLE_CADASTRAR_PESSOA') and #oauth2.hasScope('write')")
	public ResponseEntity<ChickenLot> update(@PathVariable Long id, @Valid @RequestBody ChickenLot chickenLot) {
		ChickenLot chickenLotSaved = chickenLotService.update(id, chickenLot);
		return ResponseEntity.ok(chickenLotSaved);
	}

}
