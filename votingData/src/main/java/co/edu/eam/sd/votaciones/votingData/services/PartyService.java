package co.edu.eam.sd.votaciones.votingData.services;

import co.edu.eam.sd.votaciones.votingData.exceptions.NotFoundException;
import co.edu.eam.sd.votaciones.votingData.model.entities.Candidate;
import co.edu.eam.sd.votaciones.votingData.model.entities.Party;
import co.edu.eam.sd.votaciones.votingData.repository.PartyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class PartyService {

    @Autowired
    private PartyRepository partyRepository;

    @Cacheable(value="party", key = "#id")
    public Party findById(Long id){
        Party party = partyRepository.findById(id).get();
        if(party==null)
            throw new NotFoundException("No existe un partido con ese id: "+id, "party_doesnt_exist");

        return party;
    }

}
