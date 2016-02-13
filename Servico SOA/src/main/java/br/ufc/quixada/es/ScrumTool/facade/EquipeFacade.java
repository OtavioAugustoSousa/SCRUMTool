package br.ufc.quixada.es.ScrumTool.facade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.ufc.quixada.es.ScrumTool.entidades.Equipe;
import br.ufc.quixada.es.ScrumTool.service.EquipeService;

@Component
public class EquipeFacade {

	@Autowired
	private EquipeService equipeService;

	public Equipe save(Equipe equipe) {
		return equipeService.save(equipe);
	}

	public void update(Equipe equipe) {
		equipeService.update(equipe);
	}

	public void remove(Long id) {
		equipeService.remove(id);
	}
	
	public Equipe findById(Long id){
		return equipeService.findById(id);
	}
	
	public List<Equipe> getEquipes() {
		return equipeService.getEquipes();
		}	
}
