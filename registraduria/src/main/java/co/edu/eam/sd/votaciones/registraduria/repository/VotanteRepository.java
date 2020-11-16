package co.edu.eam.sd.votaciones.registraduria.repository;

import co.edu.eam.sd.votaciones.registraduria.model.entities.Votante;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface VotanteRepository extends JpaRepository<Votante, String> {


    //en vez de Page estaba el List
   @Query("SELECT p FROM Votante p WHERE p.biometria = :biometria")
    Votante buscarBybiometria(String biometria);
}
