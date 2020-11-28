package co.edu.eam.sd.votaciones.voting.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqConfigColas {


    //primera cola registraduria
    @Bean
    public Queue votingRegistraduriaQueue(){

        return new Queue("voting_registraduria_queue");
    }

    //segunda cola
    @Bean
    public Queue votingRegistrationQueue(){

        return new Queue("voting_registration_queue");
    }

    //tercera cola
    @Bean
    public Queue votingQueryQueue(){

        return new Queue("voting_query_queue");
    }



    @Bean
    public DirectExchange directExchange(){

        return new DirectExchange("direct_exchange");
    }

    //binding primera cola
    @Bean
    public Binding bindDirectExchangeVotingRegistraduriaQueue(Queue votingRegistraduriaQueue, DirectExchange directExchange){

        return BindingBuilder.bind(votingRegistraduriaQueue).to(directExchange).with("voting_registraduria") ;
    }

    //binding segunda cola
    @Bean
    public Binding bindDirectExchangeVotingRegistrationQueue(Queue votingRegistrationQueue, DirectExchange directExchange){

        return BindingBuilder.bind(votingRegistrationQueue).to(directExchange).with("voting_registration") ;
    }

    //binding tercera cola
    @Bean
    public Binding bindDirectExchangeVotingQueryQueue(Queue votingQueryQueue, DirectExchange directExchange){

        return BindingBuilder.bind(votingQueryQueue).to(directExchange).with("voting_query") ;
    }

}
