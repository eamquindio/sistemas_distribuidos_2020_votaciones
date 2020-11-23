package co.edu.eam.sd.votaciones.voting.controller;


import co.edu.eam.sd.votaciones.voting.model.entities.Vote;
import co.edu.eam.sd.votaciones.voting.services.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/votes")
public class VoteController {

    @Autowired
    private VoteService voteService;

    @PostMapping
    public void crear(@RequestBody Vote p){
        System.out.println("entro al controlador guardar");
        voteService.create(p);
    }

    @GetMapping("/{id}")
    public Vote buscar(@PathVariable Integer id){
        System.out.println("entro al controlador buscar");
        return voteService.buscar(id);
    }
}
