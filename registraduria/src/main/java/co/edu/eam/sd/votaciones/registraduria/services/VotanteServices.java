package co.edu.eam.sd.votaciones.registraduria.services;

import co.edu.eam.sd.votaciones.registraduria.exceptions.NotFoundException;
import co.edu.eam.sd.votaciones.registraduria.model.entities.Votante;
import co.edu.eam.sd.votaciones.registraduria.repository.VotanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class VotanteServices {

    @Autowired
    private VotanteRepository votanteRepository;


    @Cacheable(value = "votantes", key="#cedula")
    public Votante find(String cedula){
        Votante votante = votanteRepository.findByCedula(cedula);
        if(votante==null)
            throw new NotFoundException("No existe un votante con cedula: "+cedula, "votante_doesnt_exist");

        return votante;
    }

}