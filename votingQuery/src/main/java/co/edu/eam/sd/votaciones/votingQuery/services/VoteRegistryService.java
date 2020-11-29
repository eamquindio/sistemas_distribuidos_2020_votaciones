package co.edu.eam.sd.votaciones.votingQuery.services;

import co.edu.eam.sd.votaciones.votingQuery.api.clients.CandidateClient;
import co.edu.eam.sd.votaciones.votingQuery.api.clients.PartyClient;
import co.edu.eam.sd.votaciones.votingQuery.exceptions.NotFoundException;
import co.edu.eam.sd.votaciones.votingQuery.model.responses.Candidate;
import co.edu.eam.sd.votaciones.votingQuery.model.responses.Party;
import co.edu.eam.sd.votaciones.votingQuery.model.responses.VoteRegistryDTO;
import co.edu.eam.sd.votaciones.votingQuery.model.CountResult;
import co.edu.eam.sd.votaciones.votingQuery.model.entities.VoteRegistry;
import co.edu.eam.sd.votaciones.votingQuery.repository.VoteRegistryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import java.awt.print.Pageable;
import java.util.List;

@Service
public class VoteRegistryService {

    @Autowired
    private VoteRegistryRepository voteRegistryRepository;

    @Autowired
    private CandidateClient candidateClient;

    @Autowired
    private PartyClient partyClient;

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

    @Cacheable(value = "conteo", key = "'candidatos'")
    public List<CountResult> countVoteRegistry(){
        return voteRegistryRepository.countVoteRegistry();
    }

    @CachePut(value = "vote_registry", key="#vr.candidateId")
    public VoteRegistry create(VoteRegistry vr) throws IOException {
        VoteRegistry voteRegistry = voteRegistryRepository.findBycandidateId(vr.getCandidateId());
        if(voteRegistry == null){

            Candidate candidate = candidateClient.getCandidate(vr.getCandidateId());
            Party party = partyClient.getParty(vr.getPartyId());

            vr.setCandidateName(candidate.getName());
            vr.setPartyName(party.getName());
            vr.setDateTime(new Date());
            vr.setCount(1);
            voteRegistryRepository.save(vr);
            return vr;
        }else{

            if(voteRegistry.getCandidateName().equals("")){
                Candidate candidate = candidateClient.getCandidate(voteRegistry.getCandidateId());
                voteRegistry.setCandidateName(candidate.getName());
            }

            if (voteRegistry.getPartyName().equals("")) {
                Party party = partyClient.getParty(voteRegistry.getPartyId());
                voteRegistry.setPartyName(party.getName());
            }
            
            voteRegistry.setDateTime(new Date());
            voteRegistry.setCount(voteRegistry.getCount()+1);
            voteRegistryRepository.save(voteRegistry);
            return voteRegistry;
        }
    }


}
