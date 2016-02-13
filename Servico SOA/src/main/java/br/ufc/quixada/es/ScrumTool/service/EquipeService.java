package br.ufc.quixada.es.ScrumTool.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufc.quixada.es.ScrumTool.entidades.Equipe;
import br.ufc.quixada.es.ScrumTool.repository.EquipeRepository;

@Service
public class EquipeService {

	@Autowired
	private EquipeRepository equipeRepository;

	public Equipe save(Equipe equipe) {
		return equipeRepository.save(equipe);
	}

	public void update(Equipe equipe) {
		equipeRepository.update(equipe);
	}

	public void remove(Long id) {
		equipeRepository.remove(id);
	}
	
	public Equipe findById(Long id){
		return equipeRepository.findById(id);
	}
	
	public List<Equipe> getEquipes() {
		return equipeRepository.list();
	}
}
