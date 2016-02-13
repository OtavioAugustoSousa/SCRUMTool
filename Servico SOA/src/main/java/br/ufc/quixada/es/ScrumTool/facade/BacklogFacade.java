package br.ufc.quixada.es.ScrumTool.facade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import br.ufc.quixada.es.ScrumTool.entidades.Backlog;
import br.ufc.quixada.es.ScrumTool.service.BacklogService;
import br.ufc.quixada.es.ScrumTool.service.NotificationService;

@Component
public class BacklogFacade {

	@Autowired
	private BacklogService backlogService;
	
	@Autowired
	private NotificationService notificationService;
	
	public Backlog save(Backlog backlog) {		
		backlog = backlogService.save(backlog);
		notificationService.notifySave(backlog);
		return backlog;
	}

	public void update(Backlog backlog) {
		backlogService.update(backlog);
		notificationService.notifyUpdate(backlog);
	}

	public void remove(Long id) {
		backlogService.remove(id);
		notificationService.notifyDelete(id);;
	}
	
	public Backlog findById(Long id){
		return backlogService.findById(id);
	}
	
	public List<Backlog> getBacklogs() {
		return backlogService.getBacklogs();
	}
	
	public SseEmitter subscribe(){
		return notificationService.subscribe();
	}
}
