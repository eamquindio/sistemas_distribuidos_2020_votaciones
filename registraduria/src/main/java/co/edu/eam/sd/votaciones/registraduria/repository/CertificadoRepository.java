package co.edu.eam.sd.votaciones.registraduria.repository;

import co.edu.eam.sd.votaciones.registraduria.model.entities.CertificadoVotacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CertificadoRepository extends JpaRepository<String, CertificadoVotacion> {
}
