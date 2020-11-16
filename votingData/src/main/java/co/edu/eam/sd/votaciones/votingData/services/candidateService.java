package co.edu.eam.sd.votaciones.votingData.services;

import co.edu.eam.sd.votaciones.votingData.model.entities.Candidate;
import co.edu.eam.sd.votaciones.votingData.model.entities.CanditoPartido;
import co.edu.eam.sd.votaciones.votingData.model.entities.Party;
import co.edu.eam.sd.votaciones.votingData.repository.CandidateRepository;
import co.edu.eam.sd.votaciones.votingData.repository.PartyRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.TimeUnit;

@Service
public class candidateService {

    @Autowired
    private CandidateRepository candidateRepository;

    @Autowired
    private PartyRepository partyRepository;

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Autowired
    private ObjectMapper objectMapper;


  // private CanditoPartido canditoPartido;

    public List<CanditoPartido> buscarCandidatos(){
        CanditoPartido canditoPartido ;
        List<CanditoPartido> candipartido = new ArrayList<>();
        List<String> allcandidatos = redisTemplate.opsForList().range("liscandidatos",0,-1);
        String datos = "";
        if (allcandidatos.size()>0) {
            for (int k = 0; k < allcandidatos.size(); k++) {
                datos = allcandidatos.get(k);

                CanditoPartido c = null;
                try {
                    c = objectMapper.readValue(datos, CanditoPartido.class);
                } catch (JsonProcessingException e) {
                    e.printStackTrace();
                }
                candipartido.add(c);

            }

            return  candipartido;
            }



        List<Party> partidos = partyRepository.findAll();
        List<Candidate> candidatos = candidateRepository.findAll();
        int a =0;
        int b = 0;
        String nombreC = " ";
        String nombreP = " ";
        for (int i=0; i<candidatos.size();i++) {
             a = Math.toIntExact(candidatos.get(i).getParty());

            for (int j=0; j<partidos.size();j++) {
                b = Math.toIntExact(partidos.get(j).getId());
            System.out.println("este es el valor a:"+a);
            System.out.println("este es el valor b:"+b);
            if (a==b){
                System.out.println("este es el nombre de candidato:"+candidatos.get(i).getName());
                System.out.println("este es el nombre de partido:"+partidos.get(j).getName());
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
            candipartido.add(canditoPartido);
        }
        redisTemplate.expire("liscandidatos",60, TimeUnit.SECONDS);
        return candipartido;
    }
}
