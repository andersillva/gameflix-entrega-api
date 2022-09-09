package br.com.andersillva.gameflixentregaapi.domain.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.andersillva.gameflixentregaapi.domain.dto.PedidoDTO;
import br.com.andersillva.gameflixentregaapi.domain.model.Entrega;
import br.com.andersillva.gameflixentregaapi.domain.model.EntregaItem;
import br.com.andersillva.gameflixentregaapi.domain.model.domaintype.TipoProduto;
import br.com.andersillva.gameflixentregaapi.messaging.outgoing.EventoEntregaUsuario;

@Service
public class EntregaServiceImpl implements EntregaService {

	@Autowired
	private EventoEntregaUsuario eventoEntregaUsuario;

	@Autowired
	private LiberacaoService liberacaoService;

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void entregar(PedidoDTO pedido) {
		Entrega entrega = new Entrega();
		entrega.setIdUsuario(pedido.getIdUsuario());
		entrega.setData(pedido.getData());
		entrega.setItens(obterJogos(pedido));
		eventoEntregaUsuario.gerarMensagem(entrega);
	}

	private List<EntregaItem> obterJogos(PedidoDTO pedido) {

		List<EntregaItem> entregaItens = new ArrayList<>();

		pedido.getItens().forEach(item -> {
			if (item.getTipo().equals(TipoProduto.JOGO)) {
				entregaItens.add(new EntregaItem(item));
			} else {
				liberacaoService.obterLiberacoes(pedido.getData()).forEach(liberacao -> entregaItens.add(new EntregaItem(liberacao)));
			}
		});

		return entregaItens;
	}

}
