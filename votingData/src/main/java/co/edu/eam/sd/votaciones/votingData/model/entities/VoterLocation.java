package co.edu.eam.sd.votaciones.votingData.model.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
public class VoterLocation implements Serializable {

  @Id
  private String cedula;

  @ManyToOne
  @JoinColumn(name = "location_id")
  @NotNull(message="Location is obligatory")
  private Locations location;

  public VoterLocation() {
  }

  public String getCedula() {
    return cedula;
  }

  public void setCedula(String cedula) {
    this.cedula = cedula;
  }

  public Locations getLocation() {
    return location;
  }

  public void setLocation(Locations location) {
    this.location = location;
  }
}
