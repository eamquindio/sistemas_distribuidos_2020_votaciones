package co.edu.eam.sd.votaciones.votingQuery.model.responses;

import javax.persistence.Column;
import java.io.Serializable;

public class Party implements Serializable {

    private Long id;
    private String name;

    public Party() {
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
