package co.edu.eam.sd.votaciones.voting.model.responses;

public class VoterLocationResponse {
    //@Id
    private String cedula;

    //@ManyToOne
    //@JoinColumn(name = "location_id")
    //@NotNull(message="Location is obligatory")
    private LocationsResponse location;

    public VoterLocationResponse() {
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public LocationsResponse getLocation() {
        return location;
    }

    public void setLocation(LocationsResponse location) {
        this.location = location;
    }
}

