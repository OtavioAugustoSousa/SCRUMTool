package br.ufc.quixada.es.ScrumTool.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufc.quixada.es.ScrumTool.entidades.Projeto;
import br.ufc.quixada.es.ScrumTool.repository.ProjetoRepository;

@Service
public class ProjetoService {

	@Autowired
	private ProjetoRepository projetoRepository;

	public Projeto save(Projeto projeto) {
		return projetoRepository.save(projeto);
	}

	public void update(Projeto projeto) {
		projetoRepository.update(projeto);
	}

	public void remove(Long id) {
		projetoRepository.remove(id);
	}
	
	public Projeto findById(Long id){
		return projetoRepository.findById(id);
	}
	
	public List<Projeto> getProjetos() {
		return projetoRepository.list();
	}
}
