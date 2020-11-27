package co.edu.eam.sd.votaciones.voting.api.definitions;

import co.edu.eam.sd.votaciones.voting.config.Constants;
import co.edu.eam.sd.votaciones.voting.model.responses.RegistraduriaResponse;
import co.edu.eam.sd.votaciones.voting.model.responses.VoterLocationResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface VotingDataAPI {

    @GET(Constants.VOTINGDATA_BASE_URL + "api/voter_locations/{id}")
    Call<VoterLocationResponse> getLocationdata(@Path("id") String id);
}
