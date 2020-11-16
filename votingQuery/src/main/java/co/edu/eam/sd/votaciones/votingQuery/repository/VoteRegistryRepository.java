package co.edu.eam.sd.votaciones.votingQuery.repository;

import co.edu.eam.sd.votaciones.votingQuery.model.CountResult;
import co.edu.eam.sd.votaciones.votingQuery.model.entities.VoteRegistry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VoteRegistryRepository extends JpaRepository<VoteRegistry, Long> {

    // TOTAL DE VOTOS DE TODOS LOS CANDIDATOS AGRUPADOS POR CANDIDATO
    @Query("SELECT new co.edu.eam.sd.votaciones.votingQuery.model.CountResult (v.candidateName, SUM(v.count) as count, v.candidateId) FROM VoteRegistry v GROUP BY v.candidateId, v.candidateName")
    public List<CountResult> countVoteRegistry();

}
