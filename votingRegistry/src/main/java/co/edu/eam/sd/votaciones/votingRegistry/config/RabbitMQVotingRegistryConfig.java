package co.edu.eam.sd.votaciones.votingRegistry.config;

import org.springframework.context.annotation.Bean;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQVotingRegistryConfig {

    @Bean
    public Queue votingRegistrationQueue(){
        return new Queue("voting_registration_queue", true);
    }

    @Bean
    public DirectExchange directExchange(){
        return new DirectExchange("direct_exchange");
    }

    @Bean
    public Binding bindDirectExchangeVotingRegistrationQueue(Queue votingRegistrationQueue, DirectExchange directExchange){
        return BindingBuilder.bind(votingRegistrationQueue).to(directExchange).with("voting_registration");
    }

}
