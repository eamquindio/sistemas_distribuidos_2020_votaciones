package co.edu.eam.sd.votaciones.registraduria.services;

import co.edu.eam.sd.votaciones.registraduria.exceptions.NotFoundException;
import co.edu.eam.sd.votaciones.registraduria.model.entities.Votante;
import co.edu.eam.sd.votaciones.registraduria.repository.VotanteRepository;
import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class VotanteService {


   @Autowired
   private VotanteRepository votanteRepository;

    @Autowired
    private RedisTemplate<String, String> redisTemplate;


    //buscar por biometria ? preguntar y que parametros entran
    @Cacheable(value = "votante", key = "#biometria")
   public Votante buscarBybiometria(String biometria)  {
       System.out.println("entro al controllador a buscar y esta es la llave"+biometria);
        Votante votanteExist= votanteRepository.buscarBybiometria(biometria);

        boolean vota= votanteExist.getCedula().isEmpty();
        System.out.println("esta es el dato" +vota);
        if (vota){ throw new NotFoundException("no existe el votante","no_existe");}
        //hacer el si no y hacer try

        return votanteRepository.buscarBybiometria(biometria);
    }

  @Cacheable(value = "votantes", key="#cedula")
  public Votante find(String cedula){
    Votante votante = votanteRepository.findByCedula(cedula);
    if(votante==null)
      throw new NotFoundException("No existe un votante con cedula: "+cedula, "votante_doesnt_exist");

    return votante;
  }
}
