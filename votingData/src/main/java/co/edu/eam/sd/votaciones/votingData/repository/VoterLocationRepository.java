package co.edu.eam.sd.votaciones.votingData.repository;

import co.edu.eam.sd.votaciones.votingData.model.entities.VoterLocation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface VoterLocationRepository extends JpaRepository<VoterLocation, String> {
}

