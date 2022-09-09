package br.com.andersillva.gameflixentregaapi.messaging.outgoing.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import br.com.andersillva.gameflixentregaapi.domain.model.Entrega;
import lombok.Data;

@Data
public class MensagemJogoLiberadoUsuarioDTO {

	private Long idUsuario;

	private List<MensagemJogoLiberadoUsuarioItemDTO> jogos = new ArrayList<>();

	public MensagemJogoLiberadoUsuarioDTO(Entrega entrega) {
		this.idUsuario = entrega.getIdUsuario();
		this.jogos = entrega.getItens().stream().map(MensagemJogoLiberadoUsuarioItemDTO::new).collect(Collectors.toList());
	}

}
