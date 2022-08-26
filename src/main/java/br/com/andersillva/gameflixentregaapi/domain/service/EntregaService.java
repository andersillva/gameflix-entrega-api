package br.com.andersillva.gameflixentregaapi.domain.service;

import br.com.andersillva.gameflixentregaapi.domain.dto.PedidoDTO;

public interface EntregaService {

	public void entregar(PedidoDTO pedido);

}
