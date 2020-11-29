package co.edu.eam.sd.votaciones.votingQuery.repository;

import co.edu.eam.sd.votaciones.votingQuery.model.responses.VoteRegistryDTO;
import co.edu.eam.sd.votaciones.votingQuery.model.CountResult;
import co.edu.eam.sd.votaciones.votingQuery.model.entities.VoteRegistry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VoteRegistryRepository extends JpaRepository<VoteRegistry, Long> {

    @Query("SELECT new co.edu.eam.sd.votaciones.votingQuery.model.responses.VoteRegistryDTO (sum(vr.count) as voteCount) from VoteRegistry vr where LOWER(vr.city) = LOWER(:city) AND vr.candidateId = :candidate group by vr.city, vr.candidateName")
    VoteRegistryDTO findVoteByCandidateANDCity(Long candidate, String city);

    @Query("SELECT new co.edu.eam.sd.votaciones.votingQuery.model.responses.VoteRegistryDTO (sum(vr.count) as voteCount) from VoteRegistry vr where LOWER(vr.city)= LOWER(:city) group by vr.city")
    VoteRegistryDTO findVoteByCity(String city);
    
    // TOTAL DE VOTOS DE TODOS LOS CANDIDATOS AGRUPADOS POR CANDIDATO
    @Query("SELECT new co.edu.eam.sd.votaciones.votingQuery.model.CountResult (v.candidateName, SUM(v.count) as count, v.candidateId) FROM VoteRegistry v GROUP BY v.candidateId, v.candidateName")
    public List<CountResult> countVoteRegistry();

    @Query("SELECT vr FROM VoteRegistry vr where vr.candidateId = :candidateId")
    public VoteRegistry findBycandidateId(Long candidateId);
}
