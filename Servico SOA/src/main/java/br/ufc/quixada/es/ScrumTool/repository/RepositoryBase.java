package br.ufc.quixada.es.ScrumTool.repository;

import java.util.List;

public interface RepositoryBase<T> {
	public T save(T t);

	public void remove(Long id);

	public void update(T t);

	public List<T> list();

	public T findById(Long id);

}
