package br.ufc.quixada.es.ScrumTool.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import br.ufc.quixada.es.ScrumTool.entidades.Backlog;
import br.ufc.quixada.es.ScrumTool.entidades.Evento;

@Component
public class NotificationService {
	@Autowired
	private SseEmitter emitter;

	public void notifySave(Backlog backlog) {
		processEvento(new Evento("SAVE", "backlog", backlog));
	}

	public void notifyDelete(Long id) {
		processEvento(new Evento("DELETE", "backlog", id));
	}

	public void notifyUpdate(Backlog backlog) {
		processEvento(new Evento("UPDATE", "backlog", backlog));
	}

	public SseEmitter subscribe() {
		return emitter;
	}

	private void processEvento(final Evento evento) {

		try {
			if (evento != null) {
				emitter.send(evento, MediaType.APPLICATION_JSON);
			}
		} catch (IOException e1) {
			e1.printStackTrace();
		}catch (IllegalStateException e) {
			emitter = new SseEmitter();
		}

	}

}
