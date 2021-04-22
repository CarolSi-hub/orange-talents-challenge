package com.example.demo.controller;

import java.sql.SQLClientInfoException;
import java.sql.SQLException;
import java.util.List;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.controller.advice.ResourceNotFoundException;
import com.example.demo.domain.Usuario;
import com.example.demo.repository.UsuarioRepository;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@GetMapping		
	public List <Usuario> listarTodos() {
		return usuarioRepository.findAll();
	}	

	 @PostMapping
	    @ApiOperation("Cria um novo usuario")
	    @ApiResponses(value = {@ApiResponse(code = 201, message = "Usuario criado com sucesso")})
	 public ResponseEntity<Usuario> cadastrarUsuario (@RequestBody @Valid Usuario usuario) throws SQLException {
	    	Usuario usuarioCadastrado = usuarioRepository.save(usuario);
	    	return ResponseEntity.created(null).body(usuarioCadastrado);
    }
}
