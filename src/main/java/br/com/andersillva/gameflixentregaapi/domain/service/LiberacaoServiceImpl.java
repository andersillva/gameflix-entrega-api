package br.com.andersillva.gameflixentregaapi.domain.service;

import java.time.Clock;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.andersillva.gameflixentregaapi.domain.model.Liberacao;
import br.com.andersillva.gameflixentregaapi.domain.repository.LiberacaoRepository;

@Service
public class LiberacaoServiceImpl implements LiberacaoService {

	@Autowired
	private LiberacaoRepository liberacaoRepository;
	
	@Autowired
	private Clock clock;

	@Override
	public List<Liberacao> obterLiberacoes() {
		var dataAtual = LocalDate.now(clock);
		return liberacaoRepository.obterLiberacoesPorData(dataAtual);
	}

	@Override
	public List<Liberacao> obterLiberacoes(LocalDate data) {
		return liberacaoRepository.obterLiberacoesPorData(data);
	}

}
