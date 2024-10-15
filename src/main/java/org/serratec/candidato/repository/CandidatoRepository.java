package org.serratec.candidato.repository;

import java.util.List;

import org.serratec.candidato.model.Candidato;
import org.serratec.candidato.model.VagaDesejada;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidatoRepository extends JpaRepository<Candidato, Long>{

	List<Candidato> findByVagaDesejada(VagaDesejada vagaDesejada);
}
