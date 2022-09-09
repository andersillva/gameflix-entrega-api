package br.com.andersillva.gameflixentregaapi.domain.model.domaintype;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PROTECTED)
public enum TipoProduto implements Dominio<String> {

	JOGO("JOGO"),
	ASSINATURA("ASSINATURA");

	@Getter
	private String valor;

}
