package br.com.andersillva.gameflixentregaapi.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.andersillva.gameflixentregaapi.domain.dto.PedidoDTO;
import br.com.andersillva.gameflixentregaapi.messaging.outgoing.EventoJogoLiberadoUsuario;

@Service
public class EntregaServiceImpl implements EntregaService {

	@Autowired
	private EventoJogoLiberadoUsuario eventoJogoLiberado;

	@Override
	public void entregar(PedidoDTO pedido) {
		eventoJogoLiberado.gerarMensagem(null, null);
	}

}
