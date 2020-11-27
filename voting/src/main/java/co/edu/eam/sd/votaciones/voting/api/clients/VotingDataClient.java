package co.edu.eam.sd.votaciones.voting.api.clients;

import co.edu.eam.sd.votaciones.voting.api.definitions.RegistraduriaAPI;
import co.edu.eam.sd.votaciones.voting.api.definitions.VotingDataAPI;
import co.edu.eam.sd.votaciones.voting.model.responses.RegistraduriaResponse;
import co.edu.eam.sd.votaciones.voting.model.responses.VoterLocationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;

import java.io.IOException;

@Component
public class VotingDataClient {

    @Autowired
    private Retrofit votingdataApiConfig;

    public VoterLocationResponse getlocavota(String id) throws IOException {
        VotingDataAPI api = votingdataApiConfig.create(VotingDataAPI.class);

        Call<VoterLocationResponse> request = api.getLocationdata(id);
        Response<VoterLocationResponse> response = request.execute();

        //request.execute().body();
        return response.body();
    }
}
