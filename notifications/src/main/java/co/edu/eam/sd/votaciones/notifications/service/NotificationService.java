package co.edu.eam.sd.votaciones.notifications.service;

import co.edu.eam.sd.votaciones.notifications.model.requests.EmailMessage;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.Map;

public interface NotificationService {

    @FormUrlEncoded
    @POST("Accounts/{account}/Messages.json")
    Call<Void> sendSms(@Header("Authorization") String auth, @Header("Content-Type") String type,
                       @Path("account") String account, @FieldMap Map<String, String> fields);

    @POST("mail/send")
    Call<Void> sendEmail(@Header("Authorization") String auth, @Header("Content-Type") String type,
                         @Body EmailMessage body);

}
