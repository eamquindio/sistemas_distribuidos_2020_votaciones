package co.edu.eam.sd.votaciones.registraduria.consumers;

import co.edu.eam.sd.votaciones.registraduria.model.entities.CertificadoVotacion;
import co.edu.eam.sd.votaciones.registraduria.model.entities.Votante;
import co.edu.eam.sd.votaciones.registraduria.model.responses.Citizen;
import co.edu.eam.sd.votaciones.registraduria.model.responses.Mail;
import co.edu.eam.sd.votaciones.registraduria.model.responses.Notification;
import co.edu.eam.sd.votaciones.registraduria.model.responses.Sms;
import co.edu.eam.sd.votaciones.registraduria.producers.VoterNotificationsProducer;
import co.edu.eam.sd.votaciones.registraduria.services.CertificadoService;
import co.edu.eam.sd.votaciones.registraduria.services.VotanteService;
import co.edu.eam.sd.votaciones.registraduria.util.Const;
import co.edu.eam.sd.votaciones.registraduria.util.Crypt;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.checkerframework.checker.units.qual.C;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class VotingRegistraduriaQueueListener {

    @Autowired
    private VoterNotificationsProducer voterNotificationsProducer;

    @Autowired
    private VotanteService votanteService;

    @Autowired
    private CertificadoService certificadoService;

    @RabbitListener(queues = "#{votingRegistraduriaQueue.name}")
    public void receiveVotingRegistraduriaResult(String message) throws Exception{

        Date fechaActual =new Date();


        System.out.println(message);
        JSONObject jsonObject = new JSONObject(message);
        String mensajeDesencriptado = Crypt.desencriptar(jsonObject.getString("data"), Const.secretKey);
        System.out.println(mensajeDesencriptado);

        jsonObject = new JSONObject(mensajeDesencriptado);
        System.out.println(jsonObject);
        jsonObject = new JSONObject(mensajeDesencriptado);
        String voter = jsonObject.getString("voter");
        String votingLocation = jsonObject.getString("voting_location");

        jsonObject = new JSONObject(voter);
        String id = jsonObject.getString("id");
        Votante votante = votanteService.find(jsonObject.getString("id"));

        jsonObject = new JSONObject(votingLocation);
        String puestoVotacion = jsonObject.getString("Id");
        String ciudadVotacion = jsonObject.getString("city_id");
        CertificadoVotacion certificadoVotacion = new CertificadoVotacion(votante.getNombre(), votante.getCedula(), fechaActual, ciudadVotacion, puestoVotacion);


        Citizen citizen = new Citizen(votante.getCedula(), votante.getNombre());

        Mail mail = new Mail("Certificado de votacion", votante.getEmail(), "Gracias por votar "+fechaActual);
        Sms sms = new Sms(votante.getCelular(), "Gracias por votar "+fechaActual);
        Notification notification = new Notification(mail, sms);

        certificadoService.createCertificado(certificadoVotacion);
        voterNotificationsProducer.notifyVoter(citizen, notification);

    }

}
