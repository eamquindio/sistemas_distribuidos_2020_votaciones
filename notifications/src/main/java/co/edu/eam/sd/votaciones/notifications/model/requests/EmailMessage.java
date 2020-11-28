package co.edu.eam.sd.votaciones.notifications.model.requests;

import co.edu.eam.sd.votaciones.notifications.model.responses.Content;
import co.edu.eam.sd.votaciones.notifications.model.responses.From;
import co.edu.eam.sd.votaciones.notifications.model.responses.Personalization;

public class EmailMessage {

    private Personalization[] personalizations;
    private From from;
    private String subject;
    private Content[] content;

    public EmailMessage(Personalization[] personalizations, From from, String subject, Content[] content) {
        this.personalizations = personalizations;
        this.from = from;
        this.subject = subject;
        this.content = content;
    }

    public Personalization[] getPersonalizations() {
        return personalizations;
    }

    public void setPersonalizations(Personalization[] personalizations) {
        this.personalizations = personalizations;
    }

    public From getFrom() {
        return from;
    }

    public void setFrom(From from) {
        this.from = from;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Content[] getContent() {
        return content;
    }

    public void setContent(Content[] content) {
        this.content = content;
    }
}
