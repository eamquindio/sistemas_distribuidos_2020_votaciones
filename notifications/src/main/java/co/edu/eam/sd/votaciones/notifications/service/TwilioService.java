package co.edu.eam.sd.votaciones.notifications.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.io.IOException;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

@Service
public class TwilioService {

    @Value("${sms.from}")
    private String from;

    @Value("${sms.account}")
    private String accountSID;

    @Value("${sms.token}")
    private String authToken;

    private NotificationService notificationService;

    public TwilioService() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.twilio.com/2010-04-01/")
                .addConverterFactory(JacksonConverterFactory.create())
                .build();
        notificationService = retrofit.create(NotificationService.class);
    }

    private Map<String, String> createSmsBody(String body, String from, String to) {
        Map<String, String> fields = new HashMap<>();
        fields.put("Body", body);
        fields.put("From", from);
        fields.put(("To"), to);
        return fields;
    }

    public void sendSms(String to, String body) {
        try {
            String auth = accountSID + ":" + authToken;
            String authEncoded = Base64.getEncoder().encodeToString(auth.getBytes());
            Map<String, String> fields = createSmsBody(body, from, to);
            Call<Void> retrofitCall = notificationService.sendSms("Basic " + authEncoded,
                    "application/x-www-form-urlencoded", accountSID, fields);
            Response<Void> response = retrofitCall.execute();
            if (!response.isSuccessful()) {
                throw new RuntimeException(response.code() + "");
            }
        } catch (IOException io) {
            io.printStackTrace();
        }
    }
}
