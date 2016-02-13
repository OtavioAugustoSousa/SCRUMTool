package br.ufc.quixada.es.ScrumTool.entidades;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Backlog {
	@Id
	@org.hibernate.annotations.GenericGenerator(name = "hilo-strategy", strategy = "sequence")
	@GeneratedValue(generator = "hilo-strategy")
	private Long id;
	private String como;
	private String quero;
	private String para;
	private String titulo;
	@ManyToOne
	private Pessoa pessoa;
	private Integer esforco;
	@Enumerated
	private Estado status;

	@ManyToOne
	private Projeto projeto;

	public Projeto getProjeto() {
		return projeto;
	}

	public void setProjeto(Projeto projeto) {
		this.projeto = projeto;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getComo() {
		return como;
	}

	public void setComo(String como) {
		this.como = como;
	}

	public String getQuero() {
		return quero;
	}

	public void setQuero(String quero) {
		this.quero = quero;
	}

	public String getPara() {
		return para;
	}

	public void setPara(String para) {
		this.para = para;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Integer getEsforco() {
		return esforco;
	}

	public void setEsforco(Integer esforco) {
		this.esforco = esforco;
	}

	public Estado getStatus() {
		return status;
	}

	public void setStatus(Estado status) {
		this.status = status;
	}
}
