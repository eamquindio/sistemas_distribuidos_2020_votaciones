package co.edu.eam.sd.votaciones.votingQuery.controller;

import co.edu.eam.sd.votaciones.votingQuery.model.responses.VoteRegistryDTO;
import co.edu.eam.sd.votaciones.votingQuery.services.VoteRegistryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/votes_registry")
public class VoteRegistryController {

    @Autowired
    private VoteRegistryService voteRegistryService;

    @GetMapping("/byCandidateAndCity")
    public VoteRegistryDTO findByCandidateANDCity(@RequestParam Long candidate, @RequestParam String city) {
        return voteRegistryService.findByCandidateANDCity(candidate, city);
    }
}
