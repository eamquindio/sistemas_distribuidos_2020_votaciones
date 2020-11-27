package co.edu.eam.sd.votaciones.voting.model.responses;

public class LocationsResponse {
    //@Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    //@ManyToOne
    //@JoinColumn(name = "city")
    private CityResponse city;

    public LocationsResponse() {
    }

    public LocationsResponse(Long id, String name) {
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

    public CityResponse getCity() {
        return city;
    }

    public void setCityResponse(CityResponse city) {
        this.city = city;
    }
}

