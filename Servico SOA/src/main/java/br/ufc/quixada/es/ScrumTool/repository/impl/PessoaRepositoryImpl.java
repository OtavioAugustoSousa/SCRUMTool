package br.ufc.quixada.es.ScrumTool.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.ufc.quixada.es.ScrumTool.entidades.Pessoa;
import br.ufc.quixada.es.ScrumTool.repository.PessoaRepository;

@Repository
public class PessoaRepositoryImpl implements PessoaRepository {

	@PersistenceContext
	private EntityManager entityManager;
	private final static String DELETE = "DELETE FROM Pessoa p Where p.id = :id";

	@Override
	@Transactional
	public Pessoa save(Pessoa pessoa) {
		entityManager.persist(pessoa);
		return pessoa;
	}

	@Override
	@Transactional
	public void remove(Long id) {
		Query q = entityManager.createQuery(DELETE).setParameter("id", id);
		q.executeUpdate();
	}

	@Override
	@Transactional
	public void update(Pessoa pessoa) {
		entityManager.merge(pessoa);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Pessoa> list() {
		return entityManager.createQuery("FROM " + Pessoa.class.getName()).getResultList();
	}

	@Override
	public Pessoa findById(Long id) {
		return entityManager.find(Pessoa.class, id);
	}

}
