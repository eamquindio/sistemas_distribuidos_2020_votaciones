package co.edu.eam.sd.votaciones.voting.model.responses;

public class VoteBiometria {


    //@GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String biometria;

    private Integer candidateId;


    private Integer partyId;


    private String city;


    private String location;

    //Date
    private String dateTime;

    public VoteBiometria() {}

    public VoteBiometria(Integer id, String biometria, Integer candidateId, Integer partyId, String city, String location, String dateTime) {
        this.id = id;
        this.biometria = biometria;
        this.candidateId = candidateId;
        this.partyId = partyId;
        this.city = city;
        this.location = location;
        this.dateTime = dateTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBiometria() {
        return biometria;
    }

    public void setBiometria(String biometria) {
        this.biometria = biometria;
    }

    public Integer getCandidateId() {
        return candidateId;
    }

    public void setCandidateId(Integer candidateId) {
        this.candidateId = candidateId;
    }

    public Integer getPartyId() {
        return partyId;
    }

    public void setPartyId(Integer partyId) {
        this.partyId = partyId;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }
}
