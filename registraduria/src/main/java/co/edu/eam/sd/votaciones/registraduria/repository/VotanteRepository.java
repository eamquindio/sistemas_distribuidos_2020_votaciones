package co.edu.eam.sd.votaciones.registraduria.repository;

import co.edu.eam.sd.votaciones.registraduria.model.entities.Votante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface VotanteRepository extends JpaRepository<Votante, String> {

    @Query("SELECT v FROM Votante v where v.cedula = ?1")
    Votante findByCedula(String cedula);
}
