package com.example.demo.controller;

import java.sql.SQLClientInfoException;
import java.sql.SQLException;
import java.util.List;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
	public List <Usuario> listarTodos() throws SQLException{
		return usuarioRepository.findAll();
	}	

	@PostMapping	
	public ResponseEntity<Usuario> cadastrarUsuario (@RequestBody @Valid Usuario usuario) throws SQLException {
    	Usuario usuarioCadastrado = usuarioRepository.save(usuario);
    	return ResponseEntity.created(null).body(usuarioCadastrado);
	}
}
