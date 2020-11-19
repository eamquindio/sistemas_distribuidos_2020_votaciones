package co.edu.eam.sd.votaciones.voting.repository;

import co.edu.eam.sd.votaciones.votingData.model.entities.Vote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VoteRepository extends JpaRepository<String, Vote> {
}
