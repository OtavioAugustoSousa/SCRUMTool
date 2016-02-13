package br.ufc.quixada.es.ScrumTool.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufc.quixada.es.ScrumTool.entidades.Backlog;
import br.ufc.quixada.es.ScrumTool.repository.BacklogRepository;

@Service
public class BacklogService {
	@Autowired
	private BacklogRepository backlogRepository;

	public Backlog save(Backlog backlog) {
		return backlogRepository.save(backlog);
	}

	public void update(Backlog backlog) {
		backlogRepository.save(backlog);
	}

	public void remove(Long id) {
		backlogRepository.delete(id);
	}
	
	public Backlog findById(Long id){
		return backlogRepository.findOne(id);
	}
	
	public List<Backlog> getBacklogs() {
		return backlogRepository.findAll();
	}
}
