package co.edu.eam.sd.votaciones.votingData.model.entities;

import javax.persistence.*;

@Entity
//se realizo un cambio partido a party
@Table(name="party")
public class Party {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column(name="nombre")
  private String name;

  public Party() {
  }

  public Party(Long id, String name) {
    this.id = id;
    this.name = name;
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
