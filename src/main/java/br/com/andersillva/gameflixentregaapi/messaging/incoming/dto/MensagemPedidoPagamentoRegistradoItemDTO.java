package br.com.andersillva.gameflixentregaapi.messaging.incoming.dto;

import java.math.BigDecimal;

import br.com.andersillva.gameflixentregaapi.domain.model.domaintype.TipoProduto;
import lombok.Data;

@Data
public class MensagemPedidoPagamentoRegistradoItemDTO {

	private Long idProduto;

	private String nome;

	private BigDecimal preco;

	private TipoProduto tipo;

}
