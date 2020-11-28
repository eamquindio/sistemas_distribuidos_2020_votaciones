package co.edu.eam.sd.votaciones.notifications.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQNotificationsConfig {

    @Bean
    public Queue voterNotificationsQueue() {
        return new Queue("voter_notifications_queue");
    }

    @Bean
    public DirectExchange directExchange() {
        return new DirectExchange("direct_exchange");
    }

    @Bean
    public Binding bindDirectExchangeVoterNotificationsQueue(Queue voterNotificationsQueue, DirectExchange directExchange) {
        return BindingBuilder.bind(voterNotificationsQueue).to(directExchange).with("voter_notifications");
    }

}
