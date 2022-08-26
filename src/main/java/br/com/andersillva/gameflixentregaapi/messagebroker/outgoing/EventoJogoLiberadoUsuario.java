package br.com.andersillva.gameflixentregaapi.messagebroker.outgoing;

public interface EventoJogoLiberadoUsuario {

	public void gerarMensagem(Long idUsuario, Long idJogo);

}