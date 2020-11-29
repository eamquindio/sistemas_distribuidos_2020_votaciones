package co.edu.eam.sd.votaciones.registraduria.model.responses;

public class Notification {

    private Mail mail;
    private Sms sms;

    public Notification(Mail mail, Sms sms) {
        this.mail = mail;
        this.sms = sms;
    }

    public Mail getMail() {
        return mail;
    }

    public void setMail(Mail mail) {
        this.mail = mail;
    }

    public Sms getSms() {
        return sms;
    }

    public void setSms(Sms sms) {
        this.sms = sms;
    }
}
