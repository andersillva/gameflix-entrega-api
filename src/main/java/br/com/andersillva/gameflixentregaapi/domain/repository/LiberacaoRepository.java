package br.com.andersillva.gameflixentregaapi.domain.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.andersillva.gameflixentregaapi.domain.model.Liberacao;

@Repository
public interface LiberacaoRepository extends JpaRepository<Liberacao, Long> {

	@Query("select l from Liberacao l where :data between l.dataInicio and l.dataFim")
	public List<Liberacao> obterLiberacoesPorData(LocalDate data);

}
