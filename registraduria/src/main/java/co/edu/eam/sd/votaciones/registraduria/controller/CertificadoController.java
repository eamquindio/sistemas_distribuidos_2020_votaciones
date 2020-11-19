package co.edu.eam.sd.votaciones.registraduria.controller;

import co.edu.eam.sd.votaciones.registraduria.model.entities.CertificadoVotacion;
import co.edu.eam.sd.votaciones.registraduria.services.CertificadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/certificates")
public class CertificadoController {

    @Autowired
    private CertificadoService certificadoService;

    @GetMapping("/{id}")
    public CertificadoVotacion find(@PathVariable String id) {
        return certificadoService.find(id);
    }
}
