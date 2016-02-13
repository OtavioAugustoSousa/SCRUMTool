package br.ufc.quixada.es.ScrumTool.entidades;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Equipe {
	@Id
	@org.hibernate.annotations.GenericGenerator(name="hilo-strategy", strategy = "sequence")
	@GeneratedValue(generator = "hilo-strategy")
	private Long id;
	@OneToOne
	private Projeto projeto;
	@OneToOne
	private Pessoa pessoa;
	
	@Enumerated
	private Papel papel;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Projeto getProjeto() {
		return projeto;
	}

	public void setProjeto(Projeto projeto) {
		this.projeto = projeto;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
}
