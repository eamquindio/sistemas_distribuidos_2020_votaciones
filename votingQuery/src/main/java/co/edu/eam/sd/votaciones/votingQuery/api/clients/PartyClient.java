package co.edu.eam.sd.votaciones.votingQuery.api.clients;

import co.edu.eam.sd.votaciones.votingQuery.api.definitions.CandidateAPI;
import co.edu.eam.sd.votaciones.votingQuery.api.definitions.PartyAPI;
import co.edu.eam.sd.votaciones.votingQuery.model.responses.Candidate;
import co.edu.eam.sd.votaciones.votingQuery.model.responses.Party;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import io.lettuce.core.dynamic.annotation.CommandNaming;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;

import java.io.IOException;

@Component
public class PartyClient {

    @Autowired
    private Retrofit VotingDataConfig;

    @HystrixCommand(fallbackMethod = "fallBackParty")
    public Party getParty(Long id) throws IOException {
        System.out.println("ORIGINAL");
        PartyAPI api = VotingDataConfig.create(PartyAPI.class);

        Call<Party> request = api.getParty(id);

        Response<Party> response = request.execute();

        if(!response.isSuccessful()){
            throw new RuntimeException("api error");
        }

        return response.body();
    }

    public Party fallBackParty(Long id){
        System.out.println("fallBackParty");
        Party party = new Party();
        party.setId(id);
        party.setName("");
        return party;
    }
}
