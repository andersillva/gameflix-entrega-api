package br.com.andersillva.gameflixentregaapi.messagebroker.outgoing.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class MensagemJogoLiberadoUsuarioDTO {

	private Long idUsuario;

	private List<JogoDTO> jogos = new ArrayList<>();

}
