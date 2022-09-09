package br.com.andersillva.gameflixentregaapi.domain.model;

import br.com.andersillva.gameflixentregaapi.domain.dto.PedidoItemDTO;
import br.com.andersillva.gameflixentregaapi.domain.model.domaintype.FormaInclusao;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EntregaItem {

	private Long idJogo;
	
	private String nome;
	
	private FormaInclusao formaInclusao;

	public EntregaItem(PedidoItemDTO pedidoItemDTO) {
		this.idJogo = pedidoItemDTO.getIdProduto();
		this.nome = pedidoItemDTO.getNome();
		this.formaInclusao = FormaInclusao.COMPRA_AVULSA;
	}

	public EntregaItem(Liberacao liberacao) {
		this.idJogo = liberacao.getIdJogo();
		this.nome = liberacao.getNome();
		this.formaInclusao = FormaInclusao.ASSINATURA;
	}

}
