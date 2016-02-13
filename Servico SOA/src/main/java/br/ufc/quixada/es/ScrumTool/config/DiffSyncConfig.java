package br.ufc.quixada.es.ScrumTool.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.sync.diffsync.PersistenceCallbackRegistry;
import org.springframework.sync.diffsync.config.DiffSyncConfigurerAdapter;
import org.springframework.sync.diffsync.config.EnableDifferentialSynchronization;

import br.ufc.quixada.es.ScrumTool.entidades.Backlog;

@Configuration
@EnableDifferentialSynchronization
public class DiffSyncConfig extends DiffSyncConfigurerAdapter {

	@Autowired
	private JpaRepository<Backlog, Long> repo;

	@Override
	public void addPersistenceCallbacks(PersistenceCallbackRegistry registry) {
		registry.addPersistenceCallback(new JpaPersistenceCallback<Backlog>(repo, Backlog.class));
	}

}