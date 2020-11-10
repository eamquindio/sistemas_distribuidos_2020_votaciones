package co.edu.eam.sd.votaciones.votingQuery.repository;

import co.edu.eam.sd.votaciones.votingQuery.model.entities.VoteRegistry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VoteRegistryRepository extends JpaRepository<VoteRegistry, Long> {
}
