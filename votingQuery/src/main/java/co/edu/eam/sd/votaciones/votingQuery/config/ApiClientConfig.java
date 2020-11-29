package co.edu.eam.sd.votaciones.votingQuery.config;

import co.edu.eam.sd.votaciones.votingQuery.util.Const;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

@Configuration
public class ApiClientConfig {

    @Bean
    public Retrofit VotingDataConfig(){
        return new Retrofit.Builder()
                .baseUrl(Const.VOTING_DATA_URL)
                .addConverterFactory(JacksonConverterFactory.create())
                .build();
    }
}
