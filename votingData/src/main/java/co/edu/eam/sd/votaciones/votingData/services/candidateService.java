package co.edu.eam.sd.votaciones.votingData.services;

import co.edu.eam.sd.votaciones.votingData.exceptions.ExecutionResultException;
import co.edu.eam.sd.votaciones.votingData.exceptions.NotFoundException;
import co.edu.eam.sd.votaciones.votingData.model.entities.Candidate;
import co.edu.eam.sd.votaciones.votingData.model.entities.CanditoPartido;
import co.edu.eam.sd.votaciones.votingData.model.entities.Party;
import co.edu.eam.sd.votaciones.votingData.repository.CandidateRepository;
import co.edu.eam.sd.votaciones.votingData.repository.PartyRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class candidateService {

    @Autowired
    private PartyRepository partyRepository;

    @Autowired
    private CandidateRepository candidateRepository;

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Autowired
    private ObjectMapper objectMapper;


    @Cacheable(value="candidate", key = "#cedula")
    public Candidate findByCedula(Long cedula){
        Candidate candidate = candidateRepository.findById(cedula).get();
        if(candidate==null)
            throw new NotFoundException("No existe un candidato con ese id: "+cedula, "candidate_doesnt_exist");

        return candidate;
    }

    public List<CanditoPartido> buscarCandidatos(){
        CanditoPartido canditoPartido;
        List<CanditoPartido> candipartido = new ArrayList<>();
        List<String> rediscandidatos = redisTemplate.opsForList().range("liscandidatos",0,-1);
        if (rediscandidatos.size()>0){
            System.out.println("entro al if de obtener los datos de redis");
            for (int i=0;i<rediscandidatos.size();i++){

              String  datos = rediscandidatos.get(i);
                try {
                    CanditoPartido c =   objectMapper.readValue(datos, CanditoPartido.class);
                    candipartido.add(c);
                } catch (JsonProcessingException e) {
                    e.printStackTrace();
                }
            }

            return  candipartido;
        }

        List<Party> partidos = partyRepository.findAll();
        List<Candidate> candidatos = candidateRepository.findAll();

        if(partidos.isEmpty() || candidatos.isEmpty() ) throw new ExecutionResultException("se ejecuto pero no hay resultados", "ExecutionWithoutResults");
        //if (producExist.isEmpty()) throw new ExecutionResultException("se ejecuto pero no hay resultados", "ExecutionWithoutResults");

        int a = 0;
        int b = 0;
        String nombreC = "";
        String nombreP = "";
        for (int i=0; i<candidatos.size();i++){
            a = Math.toIntExact(candidatos.get(i).getParty());

            for (int j=0; j<partidos.size();j++){
                b = Math.toIntExact(partidos.get(j).getId());

                if (a==b){
                    nombreC = candidatos.get(i).getName();
                    nombreP = partidos.get(j).getName();
                }
            }
            canditoPartido = new CanditoPartido();
            canditoPartido.setNombreCandidato(nombreC);
            canditoPartido.setNombrePartido(nombreP);
            try {
                redisTemplate.opsForList().leftPush("liscandidatos", objectMapper.writeValueAsString(canditoPartido));
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
            redisTemplate.expire("liscandidatos",60, TimeUnit.SECONDS);
            candipartido.add(canditoPartido);
        }
        return candipartido;
    }
}
