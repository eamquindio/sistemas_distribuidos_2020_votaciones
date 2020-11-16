package co.edu.eam.sd.votaciones.votingQuery.model.responses;

import java.io.Serializable;

public class VoteRegistryDTO implements Serializable {

    private Long count;

    private String city;

    private String candidate;

    public VoteRegistryDTO(Long count, String city, String candidate) {
        this.count = count;
        this.city = city;
        this.candidate = candidate;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCandidate() {
        return candidate;
    }

    public void setCandidate(String candidate) {
        this.candidate = candidate;
    }
}
