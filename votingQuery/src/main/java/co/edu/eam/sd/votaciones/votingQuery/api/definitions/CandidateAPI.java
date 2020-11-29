package co.edu.eam.sd.votaciones.votingQuery.api.definitions;

import co.edu.eam.sd.votaciones.votingQuery.model.responses.Candidate;
import co.edu.eam.sd.votaciones.votingQuery.util.Const;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface CandidateAPI {

    @GET(Const.VOTING_DATA_URL+"candidato/findByCedula/{id}")
    Call<Candidate> getCandidate(@Path("id") Long id);
}
