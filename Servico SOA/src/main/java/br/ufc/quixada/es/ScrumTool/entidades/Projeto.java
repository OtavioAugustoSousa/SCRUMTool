package br.ufc.quixada.es.ScrumTool.entidades;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;

@Entity
public class Projeto {
	@Id
	@org.hibernate.annotations.GenericGenerator(name="hilo-strategy", strategy = "sequence")
	@GeneratedValue(generator = "hilo-strategy")
	private Long id;
	private String nome;
	@JsonDeserialize(using = LocalDateDeserializer.class)
	@JsonSerialize(using = LocalDateSerializer.class)
	private LocalDate datainicio;
	@JsonDeserialize(using = LocalDateDeserializer.class)
	@JsonSerialize(using = LocalDateSerializer.class)
	private LocalDate datafim;
	private Integer quantidadeHoras;
	private String cliente;
	private String responsavel;
	private Integer quantidadeSprints;
	private Integer tamanhoSprint;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDate getDatainicio() {
		return datainicio;
	}

	public void setDatainicio(LocalDate datainicio) {
		this.datainicio = datainicio;
	}

	public LocalDate getDatafim() {
		return datafim;
	}

	public void setDatafim(LocalDate datafim) {
		this.datafim = datafim;
	}

	public Integer getQuantidadeHoras() {
		return quantidadeHoras;
	}

	public void setQuantidadeHoras(Integer quantidadeHoras) {
		this.quantidadeHoras = quantidadeHoras;
	}

	public String getCliente() {
		return cliente;
	}

	public String getResponsavel() {
		return responsavel;
	}

	public Integer getQuantidadeSprints() {
		return quantidadeSprints;
	}

	public Integer getTamanhoSprint() {
		return tamanhoSprint;
	}
	
}
