package co.edu.eam.sd.votaciones.voting.model.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="votacion")
public class Vote implements Serializable {

  @Id
  //@GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;

  @Column(name="candidateid")
  private Integer candidateId;

  @Column(name="partyid")
  private Integer partyId;

  @Column
  private String city;

  @Column
  private String location;

  //Date
  @Column(name="datetime")
  private String dateTime;

  public Vote() {
  }

  //se cambiaron los valores Long por Integer
  public Vote(Integer id, Integer candidateId, Integer partyId, String city, String location, String dateTime) {
    this.id = id;
    this.candidateId = candidateId;
    this.partyId = partyId;
    this.city = city;
    this.location = location;
    this.dateTime = dateTime;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getCandidateId() {
    return candidateId;
  }

  public void setCandidateId(Integer candidateId) {
    this.candidateId = candidateId;
  }

  public Integer getPartyId() {
    return partyId;
  }

  public void setPartyId(Integer partyId) {
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
