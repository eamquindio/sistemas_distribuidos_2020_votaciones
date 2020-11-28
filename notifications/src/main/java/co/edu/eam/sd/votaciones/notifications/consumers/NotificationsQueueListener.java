package co.edu.eam.sd.votaciones.notifications.consumers;

import co.edu.eam.sd.votaciones.notifications.service.SendgridService;
import co.edu.eam.sd.votaciones.notifications.service.TwilioService;
import co.edu.eam.sd.votaciones.notifications.utils.Key;
import co.edu.eam.sd.votaciones.notifications.utils.Crypt;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.json.JSONObject;

@Component
public class NotificationsQueueListener {

    @Autowired
    private TwilioService twilioService;

    @Autowired
    private SendgridService sendgridService;

    @RabbitListener(queues = "#{voterNotificationsQueue.name}")
    public void receiveVoterNotification(String message) throws Exception {
        JSONObject jsonObject = new JSONObject(message);
        String data = Crypt.desencriptar(jsonObject.getString("data"), Key.secretKey);
        JSONObject msj = new JSONObject(data);
        String id = msj.getJSONObject("citizen").getString("id");
        String name = msj.getJSONObject("citizen").getString("name");
        String number = msj.getJSONObject("notification").getJSONObject("sms").getString("number");
        String text = msj.getJSONObject("notification").getJSONObject("sms").getString("text");
        String subject = msj.getJSONObject("notification").getJSONObject("mail").getString("subject");
        String to = msj.getJSONObject("notification").getJSONObject("mail").getString("to");
        String body = msj.getJSONObject("notification").getJSONObject("mail").getString("body");
        twilioService.sendSms("+57" + number, name + ", su id para consultar el certificado es: " + id + ", " + text);
        sendgridService.sendEmail(subject, to, body, name, id);
    }
}
