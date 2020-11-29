package co.edu.eam.sd.votaciones.registraduria.producers;

import co.edu.eam.sd.votaciones.registraduria.model.entities.Votante;
import co.edu.eam.sd.votaciones.registraduria.model.responses.Citizen;
import co.edu.eam.sd.votaciones.registraduria.model.responses.Mail;
import co.edu.eam.sd.votaciones.registraduria.model.responses.Notification;
import co.edu.eam.sd.votaciones.registraduria.model.responses.Sms;
import co.edu.eam.sd.votaciones.registraduria.util.Const;
import co.edu.eam.sd.votaciones.registraduria.util.Crypt;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;

import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class VoterNotificationsProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private DirectExchange directExchange;

    public void notifyVoter(Citizen citizen, Notification notification) throws Exception {

        JSONObject jsonObject = new JSONObject();
        ObjectMapper objectMapper = new ObjectMapper();

        System.out.println(objectMapper.writeValueAsString(citizen));
        System.out.println(objectMapper.writeValueAsString(notification));

        String json = "{\n" +
                "   \"citizen\": \n" +
                      objectMapper.writeValueAsString(citizen)+
                "  ,\n" +
                "   \"notification\": \n" +

                    objectMapper.writeValueAsString(notification)+
                "   }\n" +
                "\n";

        System.out.println(json);

        String cadena = Crypt.encriptar(json, Const.secretKey);

        JSONObject jsonMessage = new JSONObject();
        jsonMessage.put("data", cadena);

        rabbitTemplate.convertAndSend(directExchange.getName(),"voter_notifications",jsonMessage.toString());

    }

}
