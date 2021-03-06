package co.edu.eam.sd.votaciones.votingData.controller;

import co.edu.eam.sd.votaciones.votingData.model.entities.VoterLocation;
import co.edu.eam.sd.votaciones.votingData.services.VoterLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;

@RestController
@RequestMapping("/api/voter_locations")
public class VoterLocationController {

    @Autowired
    private VoterLocationService voterLocationService;

    @GetMapping("/{cedula}")
    private VoterLocation findLocation(@PathVariable("cedula") String cedula){
        return voterLocationService.getVotingLocation(cedula);
    }

    @PostMapping
    public void create(@RequestBody @Valid VoterLocation voterLocation){
        voterLocationService.create(voterLocation);
    }
}
