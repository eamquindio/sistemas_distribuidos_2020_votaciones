package co.edu.eam.sd.votaciones.registraduria.controller;


import co.edu.eam.sd.votaciones.registraduria.model.entities.Votante;
import co.edu.eam.sd.votaciones.registraduria.services.votanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/votante")
public class VotanteController {

    @Autowired
    private votanteService votanteService;


    @GetMapping("/by-biometria")
    public Votante buscarBybiometria(@RequestParam String biometria){
        System.out.println("entro al controllador a buscar y esta es la llave"+biometria);
         Votante result = votanteService.buscarBybiometria(biometria);

        return result;
    }
}
