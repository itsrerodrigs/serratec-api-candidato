package org.serratec.candidato.dto;

import java.time.LocalDate;

import org.serratec.candidato.model.Candidato;
import org.serratec.candidato.model.Escolaridade;
import org.serratec.candidato.model.StatusCurriculo;
import org.serratec.candidato.model.VagaDesejada;

public record CandidatoDto(
		Long id,
		String nomeCandidato,
		LocalDate dataNascimento,
		String cpf,
		Escolaridade escolaridade, 
		VagaDesejada vagaDesejada,
		StatusCurriculo statusCurriculo
		) {
	
	public Candidato toEntity() {
		Candidato candidato = new Candidato();
		candidato.setId(this.id);
		candidato.setNomeCandidato(this.nomeCandidato);
		candidato.setDataNascimento(this.dataNascimento);
		candidato.setCpf(this.cpf);
		candidato.setEscolaridade(this.escolaridade);
		candidato.setVagaDesejada(this.vagaDesejada);
		candidato.setStatusCurriculo(this.statusCurriculo);
		return candidato;
	}

	public static CandidatoDto toDto(Candidato candidato) {
		return new CandidatoDto(candidato.getId(), candidato.getNomeCandidato(),
				candidato.getDataNascimento(), candidato.getCpf(), candidato.getEscolaridade(),
				candidato.getVagaDesejada(), candidato.getStatusCurriculo());
	}
}
