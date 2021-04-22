package com.example.demo.controller;

import java.util.List;
import javax.validation.Valid;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.controller.advice.*;
import com.example.demo.domain.Endereco;
import com.example.demo.repository.EnderecoRepository;



@RestController
@RequestMapping("/enderecos")
public class EnderecoController {

	@Autowired
	private EnderecoRepository enderecoRepository;

	@PostMapping
	@ApiOperation("Cria um novo endereco")
	@ApiResponses(value = {@ApiResponse(code = 201, message = "Endereco criado com sucesso")})
	public ResponseEntity<Endereco> create(@RequestBody @Valid  Endereco endereco) {
		return new ResponseEntity<>(this.enderecoRepository.save(endereco), HttpStatus.CREATED);
	}

	@GetMapping
	public List <Endereco> listarTodos(){
		return enderecoRepository.findAll();
	}


	@GetMapping("/usuario/{usuarioId}")
	@ApiResponses(value = {@ApiResponse(code = 404, message = "Nao encontrado"), @ApiResponse(code = 200, message = "Enderecos localizados")})
	public List<Endereco> listarPorUsuarioId(@PathVariable("usuarioId") int usuarioId){
		try {
			return this.enderecoRepository.findByUsuarioId(usuarioId);
		} catch(Exception e) {
			throw new ResourceNotFoundException("Endereco");
		}
	}


}
