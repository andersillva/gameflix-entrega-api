package br.com.andersillva.gameflixentregaapi.domain.model;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Entrega {

	private Long idEntrega;

	private Long idPedido;

	private Long idUsuario;

	private List<EntregaItem> jogos;

}
