package co.edu.eam.sd.votaciones.registraduria.controller;

import co.edu.eam.sd.votaciones.registraduria.model.entities.Votante;
import co.edu.eam.sd.votaciones.registraduria.services.VotanteServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/votantes")
public class VotanteController {

    @Autowired
    private VotanteServices votanteServices;

    @GetMapping("/findByCedula/{cedula}")
    public Votante find(@PathVariable("cedula") String cedula){
        return votanteServices.find(cedula);
    }
}