package co.edu.eam.sd.votaciones.voting.model.responses;

public class CityResponse {

    //@Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    public CityResponse() {
    }

    public CityResponse(Long id, String name) {
        this.id = id;
        this.name = name;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
