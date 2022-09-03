package br.com.andersillva.gameflixentregaapi.messaging.outgoing;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import br.com.andersillva.gameflixentregaapi.messaging.outgoing.dto.MensagemJogoLiberadoUsuarioDTO;
import br.com.andersillva.gameflixentregaapi.messaging.outgoing.exception.FalhaSerializacaoMensagemException;

@Component
public class EventoJogoLiberadoUsuarioImpl implements EventoJogoLiberadoUsuario {

	private final KafkaTemplate<String, String> kafkaTemplate;
	private final ObjectMapper objectMapper = new ObjectMapper().registerModule(new JavaTimeModule());

    @Value("${app.topic.jogo-liberado-para-usuario}")
    private String JOGO_LIBERADO_USUARIO;

    public EventoJogoLiberadoUsuarioImpl(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

	@Override
	@Transactional(propagation=Propagation.MANDATORY)
	public void gerarMensagem(Long idUsuario, Long idJogo) {

		var mensagemDTO = new MensagemJogoLiberadoUsuarioDTO();
		mensagemDTO.setIdUsuario(idUsuario);
		mensagemDTO.setJogos(null);
		String mensagem;
		try {
			mensagem = objectMapper.writeValueAsString(mensagemDTO);
		} catch (JsonProcessingException e) {
			throw new FalhaSerializacaoMensagemException("Falha ao serializar o registro de jogo liberado para envio ao message broker.");
		}
        kafkaTemplate.send(JOGO_LIBERADO_USUARIO, mensagem);

	}

}
