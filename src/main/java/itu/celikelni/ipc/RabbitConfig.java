package itu.celikelni.ipc;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {
    @Value("${smoc.rabbitmq.queue}")
    private String IPC_QUEUE;

    @Value("${smoc.rabbitmq.exchange}")
    private String IPC_EXCHANGE ;

    /*
    @Value("${smoc.rabbitmq.routingkey}")
    private String IPC_ROUTING_KEY ;
     */

    @Bean
    Queue ipcQueue() {
        return new Queue(IPC_QUEUE, false);
    }

    @Bean
    DirectExchange ipcExchange() {
        return new DirectExchange(IPC_EXCHANGE);
    }

    @Bean
    Binding binding(Queue ipcQueue, DirectExchange ipcExchange) {
        //return BindingBuilder.bind(ipcQueue).to(ipcExchange).with(IPC_ROUTING_KEY);
        return BindingBuilder.bind(ipcQueue).to(ipcExchange).with("rpc");
    }


}

