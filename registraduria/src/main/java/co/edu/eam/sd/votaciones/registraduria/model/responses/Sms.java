package co.edu.eam.sd.votaciones.registraduria.model.responses;

public class Sms {

    private String number;
    private String text;

    public Sms(String number, String text) {
        this.number = number;
        this.text = text;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
