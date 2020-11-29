package co.edu.eam.sd.votaciones.registraduria.model.entities;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.Column;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="votante")
public class Votante implements Serializable {
  private String nombre;

  @Id
  private String cedula;

  @Column(name="fechanacimiento")
  @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
  private String fechaNacimiento;

  @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
  private String biometria;

  private String email;
  private String celular;

  public Votante() {
  }

  public Votante(String nombre, String cedula, String fechaNacimiento, String biometria, String email, String celular) {
    this.nombre = nombre;
    this.cedula = cedula;
    this.fechaNacimiento = fechaNacimiento;
    this.biometria = biometria;
    this.email = email;
    this.celular = celular;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getCedula() {
    return cedula;
  }

  public void setCedula(String cedula) {
    this.cedula = cedula;
  }

  public String getFechaNacimiento() {
    return fechaNacimiento;
  }

  public void setFechaNacimiento(String fechaNacimiento) {
    this.fechaNacimiento = fechaNacimiento;
  }

  public String getBiometria() {
    return biometria;
  }

  public void setBiometria(String biometria) {
    this.biometria = biometria;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getCelular() {
    return celular;
  }

  public void setCelular(String celular) {
    this.celular = celular;
  }
}
