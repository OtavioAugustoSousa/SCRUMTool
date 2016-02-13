package br.ufc.quixada.es.ScrumTool.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.ufc.quixada.es.ScrumTool.entidades.Equipe;
import br.ufc.quixada.es.ScrumTool.repository.EquipeRepository;

@Repository
public class EquipeRepositoryImpl implements EquipeRepository {

	@PersistenceContext
	private EntityManager entityManager;
	private final static String DELETE = "DELETE FROM Equipe p Where p.id = :id";

	@Override
	@Transactional
	public Equipe save(Equipe equipe) {
		entityManager.persist(equipe);
		return equipe;
	}

	@Override
	@Transactional
	public void remove(Long id) {
		Query q = entityManager.createQuery(DELETE).setParameter("id", id);
		q.executeUpdate();
	}

	@Override
	@Transactional
	public void update(Equipe equipe) {
		entityManager.merge(equipe);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Equipe> list() {
		return entityManager.createQuery("FROM " + Equipe.class.getName()).getResultList();
	}

	@Override
	public Equipe findById(Long id) {
		return entityManager.find(Equipe.class, id);
	}

}
