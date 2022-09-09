package br.com.andersillva.gameflixentregaapi.messaging.outgoing;

import br.com.andersillva.gameflixentregaapi.domain.model.Entrega;

public interface EventoEntregaUsuario {

	public void gerarMensagem(Entrega entrega);

}