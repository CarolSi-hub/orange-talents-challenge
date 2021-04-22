package com.example.demo.domain;
import java.util.Date;
import javax.persistence.*;

import org.hibernate.validator.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@EntityListeners(EntityListeners.class)
@Entity
@Table(name = "usuarios")
public class Usuario {
	
	  @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  private int id;

	  @Column
	  @NotNull
	  @NotBlank
	  private String nome;

	  @Column(unique=true)
	  @NotNull
	  @NotBlank
	  @Email
	  private String email;

	  @Column(unique=true)
	  @NotNull
	  @NotBlank
	  private String cpf;

	  @Column
	  @NotNull
	  private Date nascimento;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Date getNascimento() {
		return nascimento;
	}

	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + id;
		result = prime * result + ((nascimento == null) ? 0 : nascimento.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}
}
