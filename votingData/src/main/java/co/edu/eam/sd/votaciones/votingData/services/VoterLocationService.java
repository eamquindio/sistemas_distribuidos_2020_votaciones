package co.edu.eam.sd.votaciones.votingData.services;

import co.edu.eam.sd.votaciones.votingData.exceptions.NotFoundException;
import co.edu.eam.sd.votaciones.votingData.model.entities.VoterLocation;
import co.edu.eam.sd.votaciones.votingData.repository.VoterLocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class VoterLocationService {

    @Autowired
    private VoterLocationRepository voterLocationRepository;

    @Cacheable(value="votingLocation", key = "#cedula")
    public VoterLocation getVotingLocation(String cedula){
        boolean location = voterLocationRepository.existsById(cedula);
        if(!location) throw new NotFoundException("No existe ningún ubicación con ese ID: "+cedula, "voting_location_doesnt_exist");
        return voterLocationRepository.findById(cedula).get();
    }

}
