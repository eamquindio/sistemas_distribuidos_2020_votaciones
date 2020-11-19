package co.edu.eam.sd.votaciones.votingQuery.services;

import co.edu.eam.sd.votaciones.votingQuery.model.CountResult;
import co.edu.eam.sd.votaciones.votingQuery.model.entities.VoteRegistry;
import co.edu.eam.sd.votaciones.votingQuery.repository.VoteRegistryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.List;

@Service
public class VoteRegistryService {

    @Autowired
    private VoteRegistryRepository voteRegistryRepository;

    @Cacheable(value = "conteo", key = "'candidatos'")
    public List<CountResult> countVoteRegistry(){
        return voteRegistryRepository.countVoteRegistry();
    }

}
