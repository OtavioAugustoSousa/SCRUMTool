package br.ufc.quixada.es.ScrumTool.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufc.quixada.es.ScrumTool.entidades.Pessoa;
import br.ufc.quixada.es.ScrumTool.repository.PessoaRepository;

@Service
public class PessoaService {

	@Autowired
	private PessoaRepository pessoaRepository;

	public Pessoa save(Pessoa pessoa) {
		return pessoaRepository.save(pessoa);
	}

	public void update(Pessoa pessoa) {
		pessoaRepository.update(pessoa);
	}

	public void remove(Long id) {
		pessoaRepository.remove(id);
	}
	
	public Pessoa findById(Long id){
		return pessoaRepository.findById(id);
	}
	
	public List<Pessoa> getPessoas() {
		return pessoaRepository.list();
	}
}
