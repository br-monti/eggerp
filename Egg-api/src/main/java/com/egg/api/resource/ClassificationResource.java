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
import com.egg.api.model.Classification;
import com.egg.api.repository.ClassificationRepository;
import com.egg.api.repository.filter.ClassificationFilter;
import com.egg.api.repository.projection.ClassificationResume;
import com.egg.api.service.ClassificationService;

@RestController
@RequestMapping("/Classifications")
public class ClassificationResource {
	
	@Autowired
	private ClassificationRepository classificationRepository;
	
	@Autowired
	private ClassificationService classificationService;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@GetMapping
	//@PreAuthorize("hasAuthority('ROLE_PESQUISAR_CATEGORIA') and #oauth2.hasScope('read')") TODO: Casdastrar role
	public Page<Classification> findByFilter(ClassificationFilter classificationFilter, Pageable pageable) {
		return classificationRepository.findByFilter(classificationFilter, pageable);
	}
	
	@GetMapping(params = "resume")
	public Page<ClassificationResume> resume(ClassificationFilter classificationFilter, Pageable pageable) {
		return classificationRepository.resume(classificationFilter, pageable);
	}
	
	@PostMapping
	//@PreAuthorize("hasAuthority('ROLE_CADASTRAR_CATEGORIA') and #oauth2.hasScope('write')") TODO: Casdastrar role
	public ResponseEntity<Classification> create(@Valid @RequestBody Classification classification, HttpServletResponse response) {
		Classification classificationSaved = classificationService.save(classification);
		publisher.publishEvent(new ResourceCreatedEvent(this, response, classificationSaved.getId()));
		return ResponseEntity.status(HttpStatus.CREATED).body(classificationSaved);
	}
	
	@GetMapping("/{id}")
	//@PreAuthorize("hasAuthority('ROLE_PESQUISAR_CATEGORIA') and #oauth2.hasScope('read')") TODO: Casdastrar role
	public ResponseEntity<Classification> findById(@PathVariable Long id) {
		Classification classification = classificationRepository.findById(id).orElse(null);
		 return classification != null ? ResponseEntity.ok(classification) : ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	//@PreAuthorize("hasAuthority('ROLE_REMOVER_PESSOA') and #oauth2.hasScope('write')")
	public void deleteById(@PathVariable Long id) {
		classificationRepository.deleteById(id);
	}
	
	@PutMapping("/{id}")
	//@PreAuthorize("hasAuthority('ROLE_CADASTRAR_PESSOA') and #oauth2.hasScope('write')")
	public ResponseEntity<Classification> update(@PathVariable Long id, @Valid @RequestBody Classification classification) {
		Classification classificationSaved = classificationService.update(id, classification);
		return ResponseEntity.ok(classificationSaved);
	}

}
