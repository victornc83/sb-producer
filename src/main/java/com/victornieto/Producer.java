package com.victornieto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Random;

/**
 * Created by victor.nieto.castan on 08/06/2017.
 */
@Service
public class Producer {

    private static final Logger log = LoggerFactory.getLogger(Producer.class) ;

    @Autowired
    private RabbitTemplate rabbitTemplate ;

    @Scheduled(fixedDelay = 1000, initialDelay = 500)
    public void enviaMensaje() {
        final Mensaje mensaje = new Mensaje("Hola Mundo!", new Random().nextInt(50), false) ;
        log.info("Enviando mensaje...") ;
        this.rabbitTemplate.convertAndSend(QueueConfig.exchangeName, QueueConfig.routingKey, mensaje);
    }

}
