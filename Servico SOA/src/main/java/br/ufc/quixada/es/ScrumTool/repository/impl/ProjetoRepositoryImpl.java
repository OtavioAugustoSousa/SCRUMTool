package br.ufc.quixada.es.ScrumTool.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.ufc.quixada.es.ScrumTool.entidades.Projeto;
import br.ufc.quixada.es.ScrumTool.repository.ProjetoRepository;

@Repository
public class ProjetoRepositoryImpl implements ProjetoRepository {

	@PersistenceContext
	private EntityManager entityManager;
	private final static String DELETE="DELETE FROM Projeto p Where p.id = :id";
	
	@Override
	@Transactional
	public Projeto save(Projeto projeto) {
		entityManager.persist(projeto);
		return projeto;
	}

	@Override
	@Transactional
	public void remove(Long id) {
	Query q	= entityManager.createQuery(DELETE).setParameter("id", id);
	q.executeUpdate();		
	}

	@Override
	@Transactional
	public void update(Projeto projeto) {
		entityManager.merge(projeto);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Projeto> list() {
		return entityManager.createQuery("FROM " + Projeto.class.getName())
				.getResultList();
	}

	@Override
	public Projeto findById(Long id) {
		return entityManager.find(Projeto.class, id);
		}
}
