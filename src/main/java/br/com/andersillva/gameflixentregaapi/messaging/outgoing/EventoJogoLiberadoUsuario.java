package br.com.andersillva.gameflixentregaapi.messaging.outgoing;

public interface EventoJogoLiberadoUsuario {

	public void gerarMensagem(Long idUsuario, Long idJogo);

}