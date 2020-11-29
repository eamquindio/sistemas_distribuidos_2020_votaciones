package co.edu.eam.sd.votaciones.registraduria.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabitMQRegistraduriaConfig {

    @Bean
    public Queue voterNotificationsQueue(){ return new Queue("voter_notifications_queue", true); }

    @Bean
    public Queue votingRegistraduriaQueue(){
        return new Queue("voting_registraduria_queue", true);
    }

    @Bean
    public DirectExchange directExchange(){
        return new DirectExchange("direct_exchange");
    }

    @Bean
    public Binding bindDirectExchangeVoterNotificationQueue(Queue voterNotificationsQueue, DirectExchange directExchange){
        return BindingBuilder.bind(voterNotificationsQueue).to(directExchange).with("voter_notifications");
    }

    @Bean
    public Binding bindDirectExchangeVotingRegistraduriaQueue(Queue votingRegistraduriaQueue, DirectExchange directExchange){
        return BindingBuilder.bind(votingRegistraduriaQueue).to(directExchange).with("voting_registraduria");
    }

}
