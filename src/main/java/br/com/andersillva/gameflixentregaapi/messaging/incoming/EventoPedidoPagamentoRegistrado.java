package br.com.andersillva.gameflixentregaapi.messaging.incoming;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.andersillva.gameflixentregaapi.domain.service.EntregaService;
import br.com.andersillva.gameflixentregaapi.messaging.incoming.dto.MensagemPedidoPagamentoRegistradoDTO;

@Component
public class EventoPedidoPagamentoRegistrado {

    private final ObjectMapper mapper = new ObjectMapper();

    @Autowired
    private final EntregaService entregaService;

    public EventoPedidoPagamentoRegistrado(EntregaService entregaService) {
        this.entregaService = entregaService;
    }

    @KafkaListener(topics = "${app.topic.pedido-pagamento-registrado}")
    public void consume(@Payload String message, Acknowledgment ack) throws JsonProcessingException {

        var mensagemPedidoPagamentoRegistradoDTO = mapper.readValue(message, MensagemPedidoPagamentoRegistradoDTO.class);
        entregaService.entregar(mensagemPedidoPagamentoRegistradoDTO.converter());
        ack.acknowledge();

    }

}
