package co.edu.eam.sd.votaciones.registraduria.services;

import co.edu.eam.sd.votaciones.registraduria.model.entities.Votante;
import co.edu.eam.sd.votaciones.registraduria.repository.VotanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class votanteService {


   @Autowired
   private VotanteRepository votanteRepository;

    @Autowired
    private RedisTemplate<String, String> redisTemplate;


    //buscar por biometria ? preguntar y que parametros entran
    @Cacheable(value = "votante", key = "#biometria")
   public Votante buscarBybiometria(String biometria){
       System.out.println("entro al controllador a buscar y esta es la llave"+biometria);
        Votante votanteExist= votanteRepository.buscarBybiometria(biometria);
        //hacer el si no y hacer try

        return votanteExist;
    }
}
