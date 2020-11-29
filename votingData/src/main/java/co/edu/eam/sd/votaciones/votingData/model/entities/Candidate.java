package co.edu.eam.sd.votaciones.votingData.model.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Candidate implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  private String name;

  //@ManyToOne
  //@JoinColumn(name = "party_id")
  @Column(name="party_id")
  private Long party;

  public Candidate() {
  }

  public Candidate(Long id, String name,Long party) {
    this.id = id;
    this.name = name;
    this.party = party;
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
