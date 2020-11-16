package co.edu.eam.sd.votaciones.votingQuery.model.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "vote_registry")
public class VoteRegistry implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "candidate_id")
    private Long candidateId;
    @Column(name = "candidate_name")
    private String candidateName;
    @Column(name = "party_id")
    private Long partyId;
    @Column(name = "party_name")
    private String partyName;
    private String city;
    @Column(name = "date_time")
    private Date dateTime;
    private int count;


    public VoteRegistry() {
    }

    public VoteRegistry(int count) {
        this.count = count;
    }

    public VoteRegistry(Long id, Long candidateId, String candidateName, Long partyId, String partyName, String city, int count, Date dateTime) {
        this.id = id;
        this.candidateId = candidateId;
        this.candidateName = candidateName;
        this.partyId = partyId;
        this.partyName = partyName;
        this.city = city;
        this.dateTime = dateTime;
        this.count = count;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCandidateId() {
        return candidateId;
    }

    public void setCandidateId(Long candidateId) {
        this.candidateId = candidateId;
    }

    public String getCandidateName() {
        return candidateName;
    }

    public void setCandidateName(String candidateName) {
        this.candidateName = candidateName;
    }

    public Long getPartyId() {
        return partyId;
    }

    public void setPartyId(Long partyId) {
        this.partyId = partyId;
    }

    public String getPartyName() {
        return partyName;
    }

    public void setPartyName(String partyName) {
        this.partyName = partyName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
