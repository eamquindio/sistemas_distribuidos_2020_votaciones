package co.edu.eam.sd.votaciones.votingQuery.api.clients;

import co.edu.eam.sd.votaciones.votingQuery.api.definitions.CandidateAPI;
import co.edu.eam.sd.votaciones.votingQuery.model.responses.Candidate;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;

import java.io.IOException;

@Component
public class CandidateClient {

    @Autowired
    private Retrofit VotingDataConfig;

    @HystrixCommand(fallbackMethod = "fallBackCandidate")
    public Candidate getCandidate(Long id) throws IOException {
        CandidateAPI api = VotingDataConfig.create(CandidateAPI.class);

        Call<Candidate> request = api.getCandidate(id);

        Response<Candidate> response = request.execute();

        if(!response.isSuccessful()){
            throw new RuntimeException("api error");
        }

        return response.body();
    }

    public Candidate fallBackCandidate(Long id){
        Candidate candidate = new Candidate();
        candidate.setId(id);
        candidate.setName("");
        return candidate;
    }
}
