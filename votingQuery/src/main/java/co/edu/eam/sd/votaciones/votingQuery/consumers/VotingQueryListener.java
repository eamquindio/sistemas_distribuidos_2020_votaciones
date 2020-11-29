package co.edu.eam.sd.votaciones.votingQuery.consumers;

import co.edu.eam.sd.votaciones.votingQuery.api.clients.CandidateClient;
import co.edu.eam.sd.votaciones.votingQuery.api.clients.PartyClient;
import co.edu.eam.sd.votaciones.votingQuery.model.entities.VoteRegistry;
import co.edu.eam.sd.votaciones.votingQuery.model.responses.Candidate;
import co.edu.eam.sd.votaciones.votingQuery.model.responses.Party;
import co.edu.eam.sd.votaciones.votingQuery.repository.VoteRegistryRepository;
import co.edu.eam.sd.votaciones.votingQuery.services.VoteRegistryService;
import co.edu.eam.sd.votaciones.votingQuery.util.Const;
import co.edu.eam.sd.votaciones.votingQuery.util.Crypt;
import org.json.JSONObject;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import java.util.Date;

@Component
public class VotingQueryListener {

    @Autowired
    private VoteRegistryRepository voteRegistryRepository;

    @Autowired
    private VoteRegistryService voteRegistryService;


    @RabbitListener(queues = "#{votingQueryQueue.name}")
    public void receiveVotingQuery(String message) throws Exception {
        JSONObject jsonObject = new JSONObject(message);

        String mensajeDesencriptado = Crypt.desencriptar(jsonObject.getString("data"), Const.SECRET_KEY);

        jsonObject = new JSONObject(mensajeDesencriptado);
        String votingLocation = jsonObject.getString("voting_location");
        String vote = jsonObject.getString("vote");

        jsonObject = new JSONObject(votingLocation);
        String cityid = jsonObject.getString("city_id");

        jsonObject = new JSONObject(vote);
        Long candidate_id = jsonObject.getLong("candidate");
        Long party_id = jsonObject.getLong("party");


        VoteRegistry voteRegistry = new VoteRegistry();
        voteRegistry.setCandidateId(candidate_id);
        voteRegistry.setPartyId(party_id);
        voteRegistry.setCity(cityid);
        voteRegistryService.create(voteRegistry);
    }
}
