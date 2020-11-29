package co.edu.eam.sd.votaciones.votingData.controller;


import co.edu.eam.sd.votaciones.votingData.model.entities.Party;
import co.edu.eam.sd.votaciones.votingData.services.PartyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/party")
public class PartyController {

    @Autowired
    private PartyService partyService;

    @GetMapping("/findById/{id}")
    public Party find(@PathVariable Long id){
        return partyService.findById(id);
    }
}
