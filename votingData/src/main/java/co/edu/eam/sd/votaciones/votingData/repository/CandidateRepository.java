package co.edu.eam.sd.votaciones.votingData.repository;

import co.edu.eam.sd.votaciones.votingData.model.entities.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CandidateRepository extends JpaRepository<Candidate, Long> {
}
