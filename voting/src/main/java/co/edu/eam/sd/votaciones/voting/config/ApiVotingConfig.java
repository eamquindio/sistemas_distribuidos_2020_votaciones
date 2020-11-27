package co.edu.eam.sd.votaciones.voting.config;


import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;


@Configuration
public class ApiVotingConfig {

    @Bean
    public Retrofit registraduriaApiConfig(){
        return new Retrofit.Builder()
                .baseUrl(Constants.REGISTRADURIA_BASE_URL)
                .addConverterFactory(JacksonConverterFactory.create())
                .build();
    }

    @Bean
    public Retrofit votingdataApiConfig(){
        return new Retrofit.Builder()
                .baseUrl(Constants.VOTINGDATA_BASE_URL)
                .addConverterFactory(JacksonConverterFactory.create())
                .build();
    }
}
