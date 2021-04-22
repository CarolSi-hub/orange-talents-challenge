package com.example.demo.domain;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@EntityListeners(EntityListeners.class)
@Entity
@Table(name = "enderecos")
public class Endereco {

	@Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  private int id;
	
	 @Column
	 @NotNull
	 @NotBlank
	  private String logradouro;

	  @Column	
	  @NotNull
		@NotBlank
	  private int numero;

	  @Column
	  @NotNull
		@NotBlank
	  private String complemento;

	  @Column
	  @NotNull
		@NotBlank
	  private String bairro;

	  @Column	 
	  @NotNull
		@NotBlank
	  private String cidade;

	  @Column
	  @NotNull
		@NotBlank
	  private String estado;
	  
	  @ManyToOne
		@NotNull
		@NotBlank
	  @JoinColumn(name="id_usuarios")
		private Usuario usuario;
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public int getUsuario() {
		return usuario.getId();
     }

     public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bairro == null) ? 0 : bairro.hashCode());
		result = prime * result + ((cidade == null) ? 0 : cidade.hashCode());
		result = prime * result + ((complemento == null) ? 0 : complemento.hashCode());
		result = prime * result + ((estado == null) ? 0 : estado.hashCode());
		result = prime * result + id;
		result = prime * result + ((logradouro == null) ? 0 : logradouro.hashCode());
		result = prime * result + numero;
		result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
		return result;
	}
	
	  
}