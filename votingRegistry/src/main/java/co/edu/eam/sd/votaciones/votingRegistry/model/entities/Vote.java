package co.edu.eam.sd.votaciones.votingRegistry.model.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Vote implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  private Long candidateId;
  private String candidateName;
  private Long partyId;
  private String partyName;
  private String city;
  private String location;
  private Date dateTime;


  public Vote() {
  }

  public Vote(Long id, Long candidateId, String candidateName, Long partyId, String partyName, String city, String location, Date dateTime) {
    this.id = id;
    this.candidateId = candidateId;
    this.candidateName = candidateName;
    this.partyId = partyId;
    this.partyName = partyName;
    this.city = city;
    this.location = location;
    this.dateTime = dateTime;
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

  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }

  public Date getDateTime() {
    return dateTime;
  }

  public void setDateTime(Date dateTime) {
    this.dateTime = dateTime;
  }
}
