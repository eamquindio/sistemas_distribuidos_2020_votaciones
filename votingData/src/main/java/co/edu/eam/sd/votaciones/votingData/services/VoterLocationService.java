package co.edu.eam.sd.votaciones.votingData.services;

import co.edu.eam.sd.votaciones.votingData.exceptions.BusinessException;
import co.edu.eam.sd.votaciones.votingData.model.entities.VoterLocation;
import co.edu.eam.sd.votaciones.votingData.repository.VoterLocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Service;

@Service
public class VoterLocationService {

    @Autowired
    private VoterLocationRepository voterLocationRepository;

    @CachePut(value="voterLocation", key = "#vl.cedula")
    public VoterLocation create(VoterLocation vl){
        boolean voterLocation = voterLocationRepository.existsById(vl.getCedula());
        if(voterLocation)
            throw new BusinessException("Ya existe un lugar de votación para el usuario con cédula: "+vl.getCedula(), "voterLocation_exist");

        voterLocationRepository.save(vl);
        return vl;
    }
}
