package co.edu.eam.sd.votaciones.votingQuery.model.responses;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class VoteRegistryDTO implements Serializable {

    private Long count;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String city;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String candidate;

    public VoteRegistryDTO(Long count, String city, String candidate) {
        this.count = count;
        this.city = city;
        this.candidate = candidate;
    }

    public VoteRegistryDTO(Long count) {
        this.count = count;
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
