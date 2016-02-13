package br.ufc.quixada.es.ScrumTool.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.ufc.quixada.es.ScrumTool.entidades.Backlog;

@Repository
public interface BacklogRepository extends JpaRepository<Backlog, Long> {

}
