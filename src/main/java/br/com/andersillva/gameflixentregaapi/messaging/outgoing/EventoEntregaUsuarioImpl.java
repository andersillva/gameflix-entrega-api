package br.com.andersillva.gameflixentregaapi.messaging.outgoing;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import br.com.andersillva.gameflixentregaapi.domain.model.Entrega;
import br.com.andersillva.gameflixentregaapi.messaging.outgoing.dto.MensagemJogoLiberadoUsuarioDTO;
import br.com.andersillva.gameflixentregaapi.messaging.outgoing.exception.FalhaSerializacaoMensagemException;

@Component
public class EventoEntregaUsuarioImpl implements EventoEntregaUsuario {

	private final KafkaTemplate<String, String> kafkaTemplate;
	private final ObjectMapper objectMapper = new ObjectMapper().registerModule(new JavaTimeModule());

    @Value("${app.topic.entrega-usuario}")
    private String ENTREGA_USUARIO;

    public EventoEntregaUsuarioImpl(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

	@Override
	@Transactional(propagation=Propagation.MANDATORY)
	public void gerarMensagem(Entrega entrega) {

		var mensagemDTO = new MensagemJogoLiberadoUsuarioDTO(entrega);
		String mensagem;
		try {
			mensagem = objectMapper.writeValueAsString(mensagemDTO);
		} catch (JsonProcessingException e) {
			throw new FalhaSerializacaoMensagemException("Falha ao serializar o registro de jogo liberado para envio ao message broker.");
		}
        kafkaTemplate.send(ENTREGA_USUARIO, mensagem);

	}

}
