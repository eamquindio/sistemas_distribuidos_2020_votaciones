package co.edu.eam.sd.votaciones.voting.controller;


import co.edu.eam.sd.votaciones.voting.model.entities.Vote;
import co.edu.eam.sd.votaciones.voting.model.responses.VoteBiometria;
import co.edu.eam.sd.votaciones.voting.services.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/api/votes")
public class VoteController {

    @Autowired
    private VoteService voteService;

    @PostMapping
    public void crear(@RequestBody VoteBiometria p){
        System.out.println("entro al controlador guardar");
        try {
            voteService.create(p);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @GetMapping("/{id}")
    public Vote buscar(@PathVariable Integer id){
        System.out.println("entro al controlador buscar");
        return voteService.buscar(id);
    }
}
