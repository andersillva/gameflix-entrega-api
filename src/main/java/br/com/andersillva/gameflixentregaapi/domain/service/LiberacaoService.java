package br.com.andersillva.gameflixentregaapi.domain.service;

import java.time.LocalDate;
import java.util.List;

import br.com.andersillva.gameflixentregaapi.domain.model.Liberacao;

public interface LiberacaoService {

	public List<Liberacao> obterLiberacoes();

	public List<Liberacao> obterLiberacoes(LocalDate data);

}
