package br.ufc.quixada.es.ScrumTool.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import br.ufc.quixada.es.ScrumTool.entidades.Backlog;
import br.ufc.quixada.es.ScrumTool.facade.BacklogFacade;
import br.ufc.quixada.es.ScrumTool.repository.BacklogRepository;

@RestController
@RequestMapping(value = "/backlogs")
public class BacklogController {

	@Autowired
	private BacklogFacade backlogFacade;

	@RequestMapping(value = "", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public Backlog adiciona(@RequestBody Backlog backlog) {
		return backlogFacade.save(backlog);
	}

	/*
	 * @RequestMapping(value="",method=RequestMethod.GET,
	 * produces="application/json") public List<Backlog> list() { return
	 * backlogFacade.getBacklogs(); }
	 */

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable("id") Long id) throws IOException {
		backlogFacade.remove(id);

	}

	@RequestMapping(value = "", method = RequestMethod.PUT)
	public void update(@RequestBody Backlog backlog) {
		backlogFacade.update(backlog);
	}

	private BacklogRepository repository;

	@Autowired
	public BacklogController(BacklogRepository repository) {
		this.repository = repository;
	}

	@RequestMapping(method = RequestMethod.GET, value = "", produces = "application/json")
	public ResponseEntity<Iterable<Backlog>> list() {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Accept-Patch", "application/json-patch+json");
		return new ResponseEntity<Iterable<Backlog>>(repository.findAll(), headers, HttpStatus.OK);
	}

	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
	public Backlog getById(@PathVariable("id") Long id)	 {
		return backlogFacade.findById(id);

	}
	@RequestMapping(value = "/stream", method = RequestMethod.GET)
	public SseEmitter handle() {
		return backlogFacade.subscribe();
	}

}
