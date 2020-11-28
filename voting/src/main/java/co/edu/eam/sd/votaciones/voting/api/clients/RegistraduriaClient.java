package co.edu.eam.sd.votaciones.voting.api.clients;


import co.edu.eam.sd.votaciones.voting.api.definitions.RegistraduriaAPI;
import co.edu.eam.sd.votaciones.voting.model.responses.RegistraduriaResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;

import java.io.IOException;

@Component
public class RegistraduriaClient {

    @Autowired
    private Retrofit registraduriaApiConfig;

    @Autowired
    private RedisTemplate<String, String> redisTemplate;


    //buscar por biometria ? preguntar y que parametros entran
    @Cacheable(value = "registraduriaResponse", key = "#id")
    public RegistraduriaResponse getRegistro(String id) throws IOException {
       RegistraduriaAPI api = registraduriaApiConfig.create(RegistraduriaAPI.class);

        Call<RegistraduriaResponse> request = api.getRegistraduria(id);
        Response<RegistraduriaResponse> response = request.execute();

        //request.execute().body();
        return response.body();
    }
}
