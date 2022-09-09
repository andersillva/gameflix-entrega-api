package br.com.andersillva.gameflixentregaapi.domain.dto;

import java.time.LocalDate;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PedidoDTO {

	private Long idPedido;

	private Long idUsuario;

	private LocalDate data;

	private List<PedidoItemDTO> itens;

}
