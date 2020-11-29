package co.edu.eam.sd.votaciones.votingRegistry.repository;

import co.edu.eam.sd.votaciones.votingRegistry.model.entities.Vote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VoteRepository extends JpaRepository<Vote, Long> {
}
