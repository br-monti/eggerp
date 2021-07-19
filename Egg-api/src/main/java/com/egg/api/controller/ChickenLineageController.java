package com.egg.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.egg.api.assembler.ChickenLineageInputDisassembler;
import com.egg.api.assembler.ChickenLineageModelAssembler;
import com.egg.api.model.ChickenLineageModel;
import com.egg.api.model.input.ChickenLineageInput;
import com.egg.domain.model.ChickenLineage;
import com.egg.domain.repository.ChickenLineageRepository;
import com.egg.domain.service.ChickenLineageService;

@RestController
@RequestMapping("/ChickenLineages")
public class ChickenLineageController {
	
	
	@Autowired
	private ChickenLineageRepository chickenLineageRepository;
	
	@Autowired
	private ChickenLineageService chickenLineageService;
	
	@Autowired
	private ChickenLineageModelAssembler chickenLineageModelAssembler;
	
	@Autowired
	private ChickenLineageInputDisassembler chickenLineageInputDisassembler;
	
	@GetMapping
	public List<ChickenLineageModel> listar() {
		List<ChickenLineage> todasCidades = chickenLineageRepository.findAll();
		
		return chickenLineageModelAssembler.toCollectionModel(todasCidades);
	}
	
	@GetMapping("/{chickenLineageId}")
	public ChickenLineageModel buscar(@PathVariable Long chickenLineageId) {
		ChickenLineage chickenLineage = chickenLineageService.find(chickenLineageId);
		
		return chickenLineageModelAssembler.toModel(chickenLineage);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ChickenLineageModel adicionar(@RequestBody @Valid ChickenLineageInput chickenLineageInput) {
			ChickenLineage chickenLineage = chickenLineageInputDisassembler.toDomainObject(chickenLineageInput);			
			chickenLineage = chickenLineageService.save(chickenLineage);
			
			return chickenLineageModelAssembler.toModel(chickenLineage);
}
	
	@PutMapping("/{chickenLineageId}")
	public ChickenLineageModel atualizar(@PathVariable Long chickenLineageId,
			@RequestBody @Valid ChickenLineageInput chickenLineageInput) {
		
			ChickenLineage chickenLineageSaved = chickenLineageService.find(chickenLineageId);			
			chickenLineageInputDisassembler.copyToDomainObject(chickenLineageInput, chickenLineageSaved);			
			chickenLineageSaved = chickenLineageService.save(chickenLineageSaved);	
			
			return chickenLineageModelAssembler.toModel(chickenLineageSaved);
}
	
	@DeleteMapping("/{chickenLineageId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long chickenLineageId) {
		chickenLineageService.delete(chickenLineageId);	
	}

}
