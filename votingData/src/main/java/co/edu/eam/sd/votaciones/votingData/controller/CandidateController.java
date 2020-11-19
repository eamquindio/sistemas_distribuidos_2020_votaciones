package co.edu.eam.sd.votaciones.votingData.controller;

import co.edu.eam.sd.votaciones.votingData.model.entities.Candidate;
import co.edu.eam.sd.votaciones.votingData.model.entities.CanditoPartido;
import co.edu.eam.sd.votaciones.votingData.services.candidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/candidato")
public class CandidateController {

    @Autowired
    private candidateService candidateService;

    @GetMapping
    public List<CanditoPartido> buscartodos(){


        return candidateService.buscarCandidatos();
    }
}
