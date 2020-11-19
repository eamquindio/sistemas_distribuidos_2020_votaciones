package co.edu.eam.sd.votaciones.voting.model.entities;

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
  private Long partyId;
  private String city;
  private String location;
  private Date dateTime;

  public Vote() {
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

  public Long getPartyId() {
    return partyId;
  }

  public void setPartyId(Long partyId) {
    this.partyId = partyId;
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
