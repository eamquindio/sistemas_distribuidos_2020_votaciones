package co.edu.eam.sd.votaciones.votingRegistry.services;

import co.edu.eam.sd.votaciones.votingRegistry.exceptions.BusinessException;
import co.edu.eam.sd.votaciones.votingRegistry.model.entities.Vote;
import co.edu.eam.sd.votaciones.votingRegistry.repository.VoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Service;

@Service
public class VoteRegistryService {

    @Autowired
    private VoteRepository voteRepository;


    public Vote createVoteRegistry(Vote v){
        voteRepository.save(v);
        return v;
    }

}
