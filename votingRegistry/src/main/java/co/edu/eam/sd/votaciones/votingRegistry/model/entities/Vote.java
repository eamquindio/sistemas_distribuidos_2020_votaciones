package co.edu.eam.sd.votaciones.votingRegistry.model.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "vote")
public class Vote implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false, unique = true)
  private Long id;

  @Column(name = "candidate_id")
  private Long candidateId;

  @Column(name = "party_id")
  private Long partyId;

  private String city;

  private String location;

  @Column(name = "date_time")
  private Date dateTime;


  public Vote() {
  }

  public Vote(Long candidateId, Long partyId, String city, String location, Date dateTime) {
    this.candidateId = candidateId;
    this.partyId = partyId;
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
