package co.edu.eam.sd.votaciones.voting.repository;

import co.edu.eam.sd.votaciones.voting.model.entities.Vote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//se cambio String por Integer
@Repository
public interface VoteRepository extends JpaRepository<Vote, Integer> {
}
