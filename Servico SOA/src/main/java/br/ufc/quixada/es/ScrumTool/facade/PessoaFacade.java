package br.ufc.quixada.es.ScrumTool.facade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.ufc.quixada.es.ScrumTool.entidades.Pessoa;
import br.ufc.quixada.es.ScrumTool.service.PessoaService;

@Component
public class PessoaFacade {

	@Autowired
	private PessoaService pessoaService;

	public Pessoa save(Pessoa pessoa) {
		return pessoaService.save(pessoa);
	}

	public void update(Pessoa pessoa) {
		pessoaService.update(pessoa);
	}

	public void remove(Long id) {
		pessoaService.remove(id);
	}
	
	public Pessoa findById(Long id){
		return pessoaService.findById(id);
	}
	
	public List<Pessoa> getPessoas() {
		return pessoaService.getPessoas();
		}	
}
