package br.ufc.quixada.es.ScrumTool.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.ufc.quixada.es.ScrumTool.entidades.Projeto;
import br.ufc.quixada.es.ScrumTool.facade.ProjetoFacade;

@RestController
@RequestMapping(value="/projetos")

public class ProjetoController {
	
	@Autowired 
	ProjetoFacade projetoFacade;
		
	@RequestMapping(value="", method=RequestMethod.POST,consumes="application/json", produces="application/json")
	public Projeto adiciona(@RequestBody Projeto projeto) {
		return projetoFacade.save(projeto);
	}

	@RequestMapping(value="",method=RequestMethod.GET, produces="application/json")
	public List<Projeto> list() {	
		
		return projetoFacade.getProjetos();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public void delete(@PathVariable("id") Long id) {
		projetoFacade.remove(id);
	}
	
	@RequestMapping(value="", method=RequestMethod.PATCH)
	public void update(@RequestBody Projeto projeto) {
		projetoFacade.update(projeto);
	}
	}
