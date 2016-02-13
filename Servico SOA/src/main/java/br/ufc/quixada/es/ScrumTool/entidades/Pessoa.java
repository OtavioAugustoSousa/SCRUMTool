package br.ufc.quixada.es.ScrumTool.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Pessoa {
	@Id
	@org.hibernate.annotations.GenericGenerator(name="hilo-strategy", strategy = "sequence")
	@GeneratedValue(generator = "hilo-strategy")
	private Long id;
	private String nome;
	private String email;

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
