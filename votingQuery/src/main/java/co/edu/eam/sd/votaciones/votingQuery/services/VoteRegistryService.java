package co.edu.eam.sd.votaciones.votingQuery.services;

import co.edu.eam.sd.votaciones.votingQuery.exceptions.NotFoundException;
import co.edu.eam.sd.votaciones.votingQuery.model.responses.VoteRegistryDTO;
import co.edu.eam.sd.votaciones.votingQuery.repository.VoteRegistryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class VoteRegistryService {

    @Autowired
    private VoteRegistryRepository voteRegistryRepository;

    @Cacheable(value = "vote_registry_candidate_city", key = "{ #candidate, #city }")
    public VoteRegistryDTO findByCandidateANDCity(Long candidate, String city) {
        VoteRegistryDTO cityCount = voteRegistryRepository.findVoteByCandidateANDCity(candidate, city);
        if (cityCount == null)
            throw new NotFoundException("No existen registros de votos para el candidato: " + candidate + " en : " + city);
        return cityCount;
    }

    @Cacheable(value = "vote_registry_city", key = "#city")
    public VoteRegistryDTO findByCity(String city) {
        VoteRegistryDTO cityCount = voteRegistryRepository.findVoteByCity(city);
        if (cityCount==null)
            throw new NotFoundException("No existen registros de votos");
        return cityCount;
    }
}
