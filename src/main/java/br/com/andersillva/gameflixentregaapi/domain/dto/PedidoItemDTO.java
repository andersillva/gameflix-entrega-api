package br.com.andersillva.gameflixentregaapi.domain.dto;

import br.com.andersillva.gameflixentregaapi.domain.model.domaintype.TipoProduto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PedidoItemDTO {

	private Long idProduto;

	private String nome;
	
	private TipoProduto tipo;

}
