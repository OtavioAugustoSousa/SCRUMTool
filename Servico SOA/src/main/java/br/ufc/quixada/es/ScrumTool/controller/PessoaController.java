package br.ufc.quixada.es.ScrumTool.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.ufc.quixada.es.ScrumTool.entidades.Pessoa;
import br.ufc.quixada.es.ScrumTool.facade.PessoaFacade;

@RestController
@RequestMapping(value="/pessoas")
public class PessoaController {
	
	@Autowired 
	private PessoaFacade pessoaFacade;

	@RequestMapping(value="", method=RequestMethod.POST,consumes="application/json", produces="application/json")
	public Pessoa adiciona(@RequestBody Pessoa pessoa) {
		return pessoaFacade.save(pessoa);
	}

	@RequestMapping(value="",method=RequestMethod.GET, produces="application/json")
	public List<Pessoa> list() {	
		return pessoaFacade.getPessoas();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public void delete(@PathVariable("id") Long id) {
		pessoaFacade.remove(id);
	}
	
	@RequestMapping(value="", method=RequestMethod.PATCH)
	public void update(@RequestBody Pessoa pessoa) {
		pessoaFacade.update(pessoa);
	}
}
