package br.ufc.quixada.es.ScrumTool.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.ufc.quixada.es.ScrumTool.entidades.Equipe;
import br.ufc.quixada.es.ScrumTool.facade.EquipeFacade;

@RestController
@RequestMapping(value="/equipes")
public class EquipeController {
	
	@Autowired 
	private EquipeFacade equipeFacade;

	@RequestMapping(value="", method=RequestMethod.POST,consumes="application/json", produces="application/json")
	public Equipe adiciona(@RequestBody Equipe equipe) {
		return equipeFacade.save(equipe);
	}

	@RequestMapping(value="",method=RequestMethod.GET, produces="application/json")
	public List<Equipe> list() {	
		return equipeFacade.getEquipes();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public void delete(@PathVariable("id") Long id) {
		equipeFacade.remove(id);
	}
	
	@RequestMapping(value="", method=RequestMethod.PATCH)
	public void update(@RequestBody Equipe equipe) {
		equipeFacade.update(equipe);
	}
}
