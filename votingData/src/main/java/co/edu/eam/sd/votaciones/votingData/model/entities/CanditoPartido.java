package co.edu.eam.sd.votaciones.votingData.model.entities;

import javax.persistence.Entity;
import java.io.Serializable;


public class CanditoPartido  {

    private String nombreCandidato;

    private String nombrePartido;

    public CanditoPartido() {
    }

    public CanditoPartido(String nombreCandidato, String nombrePartido) {
        this.nombreCandidato = nombreCandidato;
        this.nombrePartido = nombrePartido;
    }

    public String getNombreCandidato() {
        return nombreCandidato;
    }

    public void setNombreCandidato(String nombreCandidato) {
        this.nombreCandidato = nombreCandidato;
    }

    public String getNombrePartido() {
        return nombrePartido;
    }

    public void setNombrePartido(String nombrePartido) {
        this.nombrePartido = nombrePartido;
    }
}
