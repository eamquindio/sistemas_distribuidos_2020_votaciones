package co.edu.eam.sd.votaciones.registraduria.repository;

import co.edu.eam.sd.votaciones.registraduria.model.entities.Votante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VotanteRepository extends JpaRepository<String, Votante> {
}
