package co.edu.eam.sd.votaciones.notifications.service;

import co.edu.eam.sd.votaciones.notifications.model.requests.EmailMessage;
import co.edu.eam.sd.votaciones.notifications.model.responses.Content;
import co.edu.eam.sd.votaciones.notifications.model.responses.From;
import co.edu.eam.sd.votaciones.notifications.model.responses.Personalization;
import co.edu.eam.sd.votaciones.notifications.model.responses.To;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

@Service
public class SendgridService {

    @Value("${email.from}")
    private String from;

    @Value("${email.apikey}")
    private String API_KEY;

    private NotificationService notificationService;

    public SendgridService() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.sendgrid.com/v3/")
                .addConverterFactory(JacksonConverterFactory.create())
                .build();
        notificationService = retrofit.create(NotificationService.class);
    }

    private EmailMessage createEmailBody(String subject, String to, String body, String name,
                                         String id) {
        String format_card = "<h1 style='text-align:center; font-family: courier;font-size:30px;'>" +
                "Votaciones - 2020</h1><hr><div align='center' >" +
                "<img src='https://media1.giphy.com/media/A5SpjJKf7ikw2mXweG/giphy.gif' width='200px' " +
                "heigh='150px' alt='alternatetext'></div><p style='text-align:center; " +
                "font-family: courier;font-size:25px;'><strong>" + name + ":</strong>" +
                "</p><p style='text-align:center; font-family: courier;font-size:20px'>" + body +
                "</p><p style='text-align:center; font-family: courier;font-size:10px'> " +
                "consulte su certificado con el id: " + id + "</p>";

        To[] tos = {new To(to)};
        From emailFrom = new From(from);
        Content content = new Content("text/html", format_card);
        Personalization personalization = new Personalization(tos);
        return new EmailMessage(new Personalization[]{personalization}, emailFrom, subject, new Content[]{content});
    }

    public void sendEmail(String subject, String to, String body, String name, String id) {
        try {
            EmailMessage emailMessage = createEmailBody(subject, to, body, name, id);
            Call<Void> retrofitCall = notificationService.sendEmail("Bearer " + API_KEY,
                    "application/json", emailMessage);
            Response<Void> response = retrofitCall.execute();
            if (!response.isSuccessful()) {
                throw new RuntimeException();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
