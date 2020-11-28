package co.edu.eam.sd.votaciones.voting.api.definitions;

import co.edu.eam.sd.votaciones.voting.config.Constants;
import co.edu.eam.sd.votaciones.voting.model.responses.RegistraduriaResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface RegistraduriaAPI {

    @GET(Constants.REGISTRADURIA_BASE_URL + "api/votantes/by-biometria?")
    Call<RegistraduriaResponse> getRegistraduria(@Query("biometria") String biometria);
}