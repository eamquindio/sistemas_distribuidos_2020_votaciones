package co.edu.eam.sd.votaciones.votingQuery.controller;

import co.edu.eam.sd.votaciones.votingQuery.model.responses.VoteRegistryDTO;
import co.edu.eam.sd.votaciones.votingQuery.services.VoteRegistryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import co.edu.eam.sd.votaciones.votingQuery.model.CountResult;
import co.edu.eam.sd.votaciones.votingQuery.model.entities.VoteRegistry;
import co.edu.eam.sd.votaciones.votingQuery.services.VoteRegistryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/vote_registry")
public class VoteRegistryController {

    @Autowired
    private VoteRegistryService voteRegistryService;

    @GetMapping("/byCandidateAndCity")
    public VoteRegistryDTO findByCandidateANDCity(@RequestParam Long candidate, @RequestParam String city) {
        return voteRegistryService.findByCandidateANDCity(candidate, city);
    }

    @GetMapping("/byCity/{city}")
    public VoteRegistryDTO findByCity(@PathVariable String city) {
        return voteRegistryService.findByCity(city);
    }

    @GetMapping("/count")
    private List<CountResult> getCountVotes() {
        return voteRegistryService.countVoteRegistry();
    }
}
