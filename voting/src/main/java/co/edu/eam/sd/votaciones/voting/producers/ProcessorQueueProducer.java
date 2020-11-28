package co.edu.eam.sd.votaciones.voting.producers;



import co.edu.eam.sd.votaciones.voting.encrypt.Encrypt;
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

    @Autowired
    private Encrypt encrypt;


    //produsco el mesnsaje a la primera cola
    public void votingRegistraduriaQueue(String cedula,Integer candidatoid,Integer partyid,Long locationid,Long cytiid ) throws Exception {

       // JSONObject jsonMessage = new JSONObject();
        //jsonMessage.put("id_solicitud",dato);
        String json= "{"+"voter"+":{ "+"id"+":"+'"'+cedula+'"'+
           "},"+
           "voting_location"+":{"+
               "Id"+":"+locationid+","+
               "city_id"+":"+cytiid+
           "},"+
           "vote"+":{"+
               "candidate"+":"+'"'+candidatoid+'"'+","+
               "party"+":"+partyid+
           "}"+
        "}";
        String key= "msgencriptadoeam";
        String encriptado = encrypt.encritar(json,key);

        System.out.println("este es el msg encriptado"+encriptado);

        JSONObject jsonMessage = new JSONObject();
        jsonMessage.put("data",encriptado);
        //notifications_result_queue
        rabbitTemplate.convertAndSend(directExchange.getName(),"voting_registraduria",jsonMessage.toString());
    }

    //produsco el mesnsaje a la segunda cola
    public void votingRegistrationQueue(String cedula,Integer candidatoid,Integer partyid,Long locationid,Long cytiid) throws Exception {

        // JSONObject jsonMessage = new JSONObject();
        //jsonMessage.put("id_solicitud",dato);
        String json= "{"+"voter"+":{ "+"id"+":"+'"'+cedula+'"'+
                "},"+
                "voting_location"+":{"+
                "Id"+":"+locationid+","+
                "city_id"+":"+cytiid+
                "},"+
                "vote"+":{"+
                "candidate"+":"+'"'+candidatoid+'"'+","+
                "party"+":"+partyid+
                "}"+
                "}";

        String key= "msgencriptadoeam";
        String encriptado = encrypt.encritar(json,key);

        System.out.println("este es el msg encriptado"+encriptado);

        JSONObject jsonMessage = new JSONObject();
        jsonMessage.put("data",encriptado);
        //notifications_result_queue
        rabbitTemplate.convertAndSend(directExchange.getName(),"voting_registration",jsonMessage.toString());
    }


    //produsco el mesnsaje a la tercera cola
    public void votingQueryQueue( String cedula,Integer candidatoid,Integer partyid,Long locationid,Long cytiid ) throws Exception {

        // JSONObject jsonMessage = new JSONObject();
        //jsonMessage.put("id_solicitud",dato);
        String json= "{"+"voter"+":{ "+"id"+":"+'"'+cedula+'"'+
                "},"+
                "voting_location"+":{"+
                "Id"+":"+locationid+","+
                "city_id"+":"+cytiid+
                "},"+
                "vote"+":{"+
                "candidate"+":"+'"'+candidatoid+'"'+","+
                "party"+":"+partyid+
                "}"+
                "}";

        String key= "msgencriptadoeam";
        String encriptado = encrypt.encritar(json,key);

        System.out.println("este es el msg encriptado"+encriptado);

        JSONObject jsonMessage = new JSONObject();
        jsonMessage.put("data",encriptado);

        //notifications_result_queue
        rabbitTemplate.convertAndSend(directExchange.getName(),"voting_query",jsonMessage.toString());
    }

}
