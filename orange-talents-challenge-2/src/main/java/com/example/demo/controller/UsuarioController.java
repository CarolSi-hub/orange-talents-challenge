package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.domain.Usuario;
import com.example.demo.repository.UsuarioRepository;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@GetMapping
	public List <Usuario> listarTodos(){
		return usuarioRepository.findAll();
	}
	

	@PostMapping
	public Usuario cadastrarUsuario (@RequestBody Usuario usuario) {
		Usuario usuarioCadastrado = usuarioRepository.save(usuario);
		return usuarioRepository.save(usuarioCadastrado);	
	}
	

}
