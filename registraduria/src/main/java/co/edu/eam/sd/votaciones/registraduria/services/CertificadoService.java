package co.edu.eam.sd.votaciones.registraduria.services;

import co.edu.eam.sd.votaciones.registraduria.exceptions.NotFoundException;
import co.edu.eam.sd.votaciones.registraduria.model.entities.CertificadoVotacion;
import co.edu.eam.sd.votaciones.registraduria.repository.CertificadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class CertificadoService {

    @Autowired
    private CertificadoRepository certificadoRepository;

    @Cacheable(value = "certificate", key = "#id")
    public CertificadoVotacion find(String id) {
        boolean certificado = certificadoRepository.existsById(id);
        if (!certificado)
            throw new NotFoundException("No existe un certificado con ID: " + id, "certificate_doesnt_exist");
        return certificadoRepository.findById(id).get();

    }

}
