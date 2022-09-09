package br.com.andersillva.gameflixentregaapi.domain.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Entrega {

	private Long idUsuario;
	
	private LocalDate data;

	private List<EntregaItem> itens = new ArrayList<>();

}
