package co.edu.eam.sd.votaciones.registraduria.controller;

import co.edu.eam.sd.votaciones.registraduria.exceptions.NotFoundException;
import co.edu.eam.sd.votaciones.registraduria.model.entities.Votante;
import co.edu.eam.sd.votaciones.registraduria.services.VotanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/votantes")
public class VotanteController {

  @Autowired
  private VotanteService votanteServices;

  @GetMapping("/findByCedula/{cedula}")
  public Votante find(@PathVariable("cedula") String cedula) {
    return votanteServices.find(cedula);
  }

  @GetMapping("/by-biometria")
  public Votante buscarBybiometria(@RequestParam String biometria) {
    System.out.println("entro al controllador a buscar y esta es la llave" + biometria);
    Votante result = null;
    try {
      result = votanteServices.buscarBybiometria(biometria);
    } catch (Exception e) {
      throw new NotFoundException("no existe el votante");
    }

    return result;
  }
}
