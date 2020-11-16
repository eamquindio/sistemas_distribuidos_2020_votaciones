package co.edu.eam.sd.votaciones.votingQuery.repository;

import co.edu.eam.sd.votaciones.votingQuery.model.responses.VoteRegistryDTO;
import co.edu.eam.sd.votaciones.votingQuery.model.entities.VoteRegistry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface VoteRegistryRepository extends JpaRepository<VoteRegistry, Long> {

    @Query("SELECT new co.edu.eam.sd.votaciones.votingQuery.model.responses.VoteRegistryDTO (sum(vr.count) as count, vr.city, vr.candidateName as candidate) from VoteRegistry vr where LOWER(vr.city) = LOWER(:city) AND vr.candidateId = :candidate group by vr.city, vr.candidateName")
    VoteRegistryDTO findVoteByCandidateANDCity(Long candidate, String city);
}
