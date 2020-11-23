package co.edu.eam.sd.votaciones.voting.producers;



import co.edu.eam.sd.votaciones.voting.model.entities.Vote;
import org.json.JSONObject;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProcessorQueueProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private DirectExchange directExchange;


    //produsco el mesnsaje a la primera cola
    public void votingRegistraduriaQueue( Vote dato ) throws Exception {

       // JSONObject jsonMessage = new JSONObject();
        //jsonMessage.put("id_solicitud",dato);
        String json= "{"+"voter"+":{ "+"id"+":"+'"'+ '"'+
           "},"+
           "voting_location"+":{"+
               "Id"+":123,"+
               "city_id"+":8980"+
           "},"+
           "vote"+":{"+
               "candidate"+":"+'"'+1+'"'+","+
               "party"+":1"+
           "}"+
        "}";
        //notifications_result_queue
        rabbitTemplate.convertAndSend(directExchange.getName(),"voting_registraduria",json);
    }

    //produsco el mesnsaje a la segunda cola
    public void votingRegistrationQueue( Vote dato ) throws Exception {

        // JSONObject jsonMessage = new JSONObject();
        //jsonMessage.put("id_solicitud",dato);
        String json= "{"+"voter"+":{ "+"id"+":"+'"'+ '"'+
                "},"+
                "voting_location"+":{"+
                "Id"+":123,"+
                "city_id"+":8980"+
                "},"+
                "vote"+":{"+
                "candidate"+":"+'"'+1+'"'+","+
                "party"+":1"+
                "}"+
                "}";
        //notifications_result_queue
        rabbitTemplate.convertAndSend(directExchange.getName(),"voting_registration_queue",json);
    }


    //produsco el mesnsaje a la tercera cola
    public void votingQueryQueue( Vote dato ) throws Exception {

        // JSONObject jsonMessage = new JSONObject();
        //jsonMessage.put("id_solicitud",dato);
        String json= "{"+"voter"+":{ "+"id"+":"+'"'+ '"'+
                "},"+
                "voting_location"+":{"+
                "Id"+":123,"+
                "city_id"+":8980"+
                "},"+
                "vote"+":{"+
                "candidate"+":"+'"'+1+'"'+","+
                "party"+":1"+
                "}"+
                "}";
        //notifications_result_queue
        rabbitTemplate.convertAndSend(directExchange.getName(),"voting_query_queue",json);
    }

}
