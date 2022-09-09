package br.com.andersillva.gameflixentregaapi.domain.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Table(name="liberacao")
@Data
public class Liberacao {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_liberacao", nullable=false)
	private Long id;

	@Column(name="dt_inicio", nullable=false)
	@NotNull
	private LocalDate dataInicio;

	@Column(name="dt_fim", nullable=false)
	@NotNull
	private LocalDate dataFim;

	@Column(name="id_jogo", nullable=false)
	@NotNull
	private Long idJogo;

	@Column(name="nm_jogo", nullable=false)
	@NotEmpty
	private String nome;

}
