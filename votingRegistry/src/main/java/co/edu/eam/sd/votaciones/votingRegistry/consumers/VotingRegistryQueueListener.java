package co.edu.eam.sd.votaciones.votingRegistry.consumers;

import co.edu.eam.sd.votaciones.votingRegistry.model.entities.Vote;
import co.edu.eam.sd.votaciones.votingRegistry.repository.VoteRepository;
import co.edu.eam.sd.votaciones.votingRegistry.services.VoteRegistryService;
import org.json.JSONObject;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import co.edu.eam.sd.votaciones.votingRegistry.util.*;

import java.util.Date;

@Component
public class VotingRegistryQueueListener {

    @Autowired
    private VoteRepository voteRepository;

    @Autowired
    private VoteRegistryService voteRegistryService;

    @RabbitListener(queues = "#{votingRegistrationQueue.name}")
    public void receiveVotingRegistry(String message) throws Exception {
        JSONObject jsonObject = new JSONObject(message);
        String mensajeEncriptado = Crypt.desencriptar(jsonObject.getString("data"), Const.SECRETKEY);

        jsonObject = new JSONObject(mensajeEncriptado);
        String voting_location = jsonObject.getString("voting_location");
        String vote = jsonObject.getString("vote");

        Vote v = new Vote();

        jsonObject = new JSONObject(voting_location);
        v.setCity(jsonObject.getString("city_id"));
        v.setLocation(jsonObject.getString("Id"));

        jsonObject = new JSONObject(vote);
        v.setCandidateId(jsonObject.getLong("candidate"));
        v.setPartyId(jsonObject.getLong("party"));
        v.setDateTime(new Date());

        voteRegistryService.createVoteRegistry(v);
    }


    /*
    private Long candidateId;
  private Long partyId;
  private String city;
  private String location;
  private Date dateTime;
    {
        "voter":{
        "id":""
    },
        "voting_location":{
        "Id":123,
                "city_id":8980
    },
        "vote":{
        "candidate":"1",
                "party":1
    }
    }*/
}
