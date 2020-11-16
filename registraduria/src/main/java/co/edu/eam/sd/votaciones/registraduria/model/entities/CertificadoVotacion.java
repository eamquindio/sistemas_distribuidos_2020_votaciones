package co.edu.eam.sd.votaciones.registraduria.model.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "certificado_votacion")
public class CertificadoVotacion implements Serializable {
    private String nombre;
    @Id
    private String cedula;
    private Date fechaVotacion;
    private String ciudadVotacion;
    private String puestoVotacion;

    public CertificadoVotacion() {
    }

    public CertificadoVotacion(String nombre, String cedula, Date fechaVotacion, String ciudadVotacion, String puestoVotacion) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.fechaVotacion = fechaVotacion;
        this.ciudadVotacion = ciudadVotacion;
        this.puestoVotacion = puestoVotacion;
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

    public Date getFechaVotacion() {
        return fechaVotacion;
    }

    public void setFechaVotacion(Date fechaVotacion) {
        this.fechaVotacion = fechaVotacion;
    }

    public String getCiudadVotacion() {
        return ciudadVotacion;
    }

    public void setCiudadVotacion(String ciudadVotacion) {
        this.ciudadVotacion = ciudadVotacion;
    }

    public String getPuestoVotacion() {
        return puestoVotacion;
    }

    public void setPuestoVotacion(String puestoVotacion) {
        this.puestoVotacion = puestoVotacion;
    }
}

