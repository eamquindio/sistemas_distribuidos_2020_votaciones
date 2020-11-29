package co.edu.eam.sd.votaciones.votingQuery.model.responses;

import javax.persistence.Column;
import java.io.Serializable;

public class Candidate implements Serializable {

    private Long id;
    private String name;
    private Long party;

    public Candidate() {
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

    public Long getParty() {
        return party;
    }

    public void setParty(Long party) {
        this.party = party;
    }
}
