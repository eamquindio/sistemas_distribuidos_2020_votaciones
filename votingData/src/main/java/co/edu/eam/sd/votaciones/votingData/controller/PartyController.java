package co.edu.eam.sd.votaciones.votingData.controller;

import co.edu.eam.sd.votaciones.votingData.model.entities.Party;
import co.edu.eam.sd.votaciones.votingData.services.partyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/partido")
public class PartyController {

    @Autowired
    private partyService partyService;

    @GetMapping
    public List<Party> buscartodos(){

        return partyService.buscarpartidos();
    }
}
