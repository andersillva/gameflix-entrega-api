package br.com.andersillva.gameflixentregaapi.messaging.outgoing.dto;

import br.com.andersillva.gameflixentregaapi.domain.model.EntregaItem;
import br.com.andersillva.gameflixentregaapi.domain.model.domaintype.FormaInclusao;
import lombok.Data;

@Data
public class MensagemJogoLiberadoUsuarioItemDTO {

	private Long idJogo;

	private String nome;

	private FormaInclusao formaInclusao;

	public MensagemJogoLiberadoUsuarioItemDTO(EntregaItem entregaItem) {
		this.idJogo = entregaItem.getIdJogo();
		this.nome = entregaItem.getNome();
		this.formaInclusao = entregaItem.getFormaInclusao();
	}

}
