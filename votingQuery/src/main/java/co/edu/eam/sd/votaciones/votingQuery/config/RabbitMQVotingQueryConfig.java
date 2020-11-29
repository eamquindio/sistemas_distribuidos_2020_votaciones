package co.edu.eam.sd.votaciones.votingQuery.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQVotingQueryConfig {
    @Bean
    public Queue votingQueryQueue(){
        return new Queue("voting_query_queue", true);
    }

    @Bean
    public DirectExchange directExchange(){
        return new DirectExchange("direct_exchange");
    }

    @Bean
    public Binding bindDirectExchangeVotingQueryQueue(Queue votingQueryQueue, DirectExchange directExchange){
        return BindingBuilder.bind(votingQueryQueue).to(directExchange).with("voting_query");
    }
}
