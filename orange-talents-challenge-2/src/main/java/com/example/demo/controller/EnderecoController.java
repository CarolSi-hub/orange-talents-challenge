package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Endereco;
import com.example.demo.repository.EnderecoRepository;

@RestController
@RequestMapping("/enderecos")
public class EnderecoController {

	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@GetMapping
	public List <Endereco> listarTodos(){
		return enderecoRepository.findAll();
	}
	
	@GetMapping("/{usuarioId}")
	public List <Endereco> listarPorUsuarioId(@PathVariable("usuarioId") int usuarioId){
		return enderecoRepository.findByUsuarioId(usuarioId);
	}
	
	@PostMapping
	public Endereco cadastrarEndereco (@RequestBody Endereco endereco) {
		Endereco enderecoCadastrado = enderecoRepository.save(endereco);
		return enderecoRepository.save(enderecoCadastrado);	
	}
}
