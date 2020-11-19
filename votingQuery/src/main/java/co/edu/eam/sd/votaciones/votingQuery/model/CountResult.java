package co.edu.eam.sd.votaciones.votingQuery.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;


public class CountResult implements Serializable {

    private String candidateName;
    private Long count;
    private Long candidateId;

    public CountResult(String candidateName, Long count, Long candidateId) {
        this.candidateName = candidateName;
        this.count = count;
        this.candidateId = candidateId;
    }

    public String getCandidateName() {
        return candidateName;
    }

    public void setCandidateName(String candidateName) {
        this.candidateName = candidateName;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public Long getCandidateId() {
        return candidateId;
    }

    public void setCandidateId(Long candidateId) {
        this.candidateId = candidateId;
    }
}
