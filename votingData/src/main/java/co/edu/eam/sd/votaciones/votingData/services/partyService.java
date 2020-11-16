package co.edu.eam.sd.votaciones.votingData.services;

import co.edu.eam.sd.votaciones.votingData.model.entities.Candidate;
import co.edu.eam.sd.votaciones.votingData.model.entities.Party;
import co.edu.eam.sd.votaciones.votingData.repository.PartyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class partyService {

    @Autowired
    private PartyRepository partyRepository;


    public List<Party> buscarpartidos(){

        System.out.println("se ejecuto el repositorio de partidos");
        return partyRepository.findAll();
    }

}
