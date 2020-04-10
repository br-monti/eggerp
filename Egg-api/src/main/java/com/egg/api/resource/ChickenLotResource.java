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
import com.egg.api.model.ChickenLot;
import com.egg.api.repository.ChickenLotRepository;

@RestController
@RequestMapping("/ChickenLots")
public class ChickenLotResource {
	
	@Autowired
	private ChickenLotRepository chickenLotRepository;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@GetMapping
	//@PreAuthorize("hasAuthority('ROLE_PESQUISAR_CATEGORIA') and #oauth2.hasScope('read')") TODO: Casdastrar role
	public List<ChickenLot> findAll() {
		return chickenLotRepository.findAll();
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

}
