package co.edu.eam.sd.votaciones.notifications.model.responses;

public class Personalization {

    private To[] to;

    public Personalization(To[] to) {
        this.to = to;
    }

    public To[] getTo() {
        return to;
    }

    public void setTo(To[] to) {
        this.to = to;
    }
}
