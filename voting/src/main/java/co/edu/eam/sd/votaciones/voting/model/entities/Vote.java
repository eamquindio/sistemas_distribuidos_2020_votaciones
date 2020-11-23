package co.edu.eam.sd.votaciones.voting.model.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="votacion")
public class Vote implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column(name="candidateid")
  private Long candidateId;

  @Column(name="partyid")
  private Long partyId;

  @Column
  private String city;

  @Column
  private String location;

  //Date
  @Column(name="datetime")
  private String dateTime;

  public Vote() {
  }

  public Vote(Long id, Long candidateId, Long partyId, String city, String location, String dateTime) {
    this.id = id;
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

  public String getDateTime() {
    return dateTime;
  }

  public void setDateTime(String dateTime) {
    this.dateTime = dateTime;
  }
}
