package co.edu.eam.sd.votaciones.voting.services;


import co.edu.eam.sd.votaciones.voting.api.clients.RegistraduriaClient;
import co.edu.eam.sd.votaciones.voting.api.clients.VotingDataClient;
import co.edu.eam.sd.votaciones.voting.encrypt.Encrypt;
import co.edu.eam.sd.votaciones.voting.model.entities.Vote;
import co.edu.eam.sd.votaciones.voting.model.responses.RegistraduriaResponse;
import co.edu.eam.sd.votaciones.voting.model.responses.VoteBiometria;
import co.edu.eam.sd.votaciones.voting.model.responses.VoterLocationResponse;
import co.edu.eam.sd.votaciones.voting.producers.ProcessorQueueProducer;
import co.edu.eam.sd.votaciones.voting.repository.VoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.rmi.RemoteException;

@Service
public class VoteService {

    @Autowired
    private VoteRepository voteRepository;

    @Autowired
    private ProcessorQueueProducer processorQueueProducer;

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    private Vote vote;

    @Autowired
    private RegistraduriaClient registraduriaClient;

    @Autowired
    private VotingDataClient votingDataClient;



    //aqui es donde se llaman los metodos para realizar la consulta de la otra api
    //se guarda los datos en la base de datos de voting
    //se llamam a los metodo que mandan las colas
    public void create(VoteBiometria vot) throws IOException {
        String bio = vot.getBiometria();
        String ciudadEntrante = vot.getCity();
        String locationEntrante = vot.getLocation();
        System.out.println("esta es la bio "+bio);
        //AQUI  LLAMOS  METODO PARA COMSUMIR EL OTRO API REGISTRADURIA
        RegistraduriaResponse registraduriaResponse = registraduriaClient.getRegistro(bio);

        System.out.println("esta es el nombre : "+registraduriaResponse.getNombre());
        System.out.println("esta es la cedula : "+registraduriaResponse.getCedula());
        String cedula = registraduriaResponse.getCedula();

        //Comsumo api VotingData
        VoterLocationResponse voterLocationResponse = votingDataClient.getlocavota(cedula);
        System.out.println("aqui cosumio voting data "+voterLocationResponse.getCedula());
        System.out.println("aqui cosumio voting data lugar de voto "+voterLocationResponse.getLocation().getId());
        System.out.println("aqui cosumio voting data lugar de voto "+voterLocationResponse.getLocation().getName());
        System.out.println("aqui cosumio voting data ciudad de voto "+voterLocationResponse.getLocation().getCity().getId());
        System.out.println("aqui cosumio voting data ciudad de voto "+voterLocationResponse.getLocation().getCity().getName());
        String ciudadregistrada = voterLocationResponse.getLocation().getCity().getName();
        String locationRegistrada = voterLocationResponse.getLocation().getName();

        Integer candidateid = vot.getCandidateId();
        Integer partyid = vot.getPartyId();
        Long locationid = voterLocationResponse.getLocation().getId();
        Long cytiid = voterLocationResponse.getLocation().getCity().getId();
        //si trae algo pero como encritado traer el modelo si algo y probar
        //String addressList =  redisTemplate.opsForValue().get("votingLocation::1094942083");
        //System.out.println("estes es lo que trae el redis"+addressList);
        System.out.println("  ciudade entrante : "+ciudadEntrante +" == "+ciudadregistrada);
        System.out.println("  location entrante : "+locationEntrante +" == "+locationRegistrada);
        if (ciudadEntrante.equals(ciudadregistrada) && locationEntrante.equals(locationRegistrada)) {
            vote = new Vote();
            vote.setId(vot.getId());
            vote.setCandidateId(vot.getCandidateId());
            vote.setPartyId(vot.getPartyId());
            vote.setCity(vot.getCity());
            vote.setLocation(vot.getLocation());
            vote.setDateTime(vot.getDateTime());
            voteRepository.save(vote);
            try {
                processorQueueProducer.votingRegistraduriaQueue(cedula, candidateid, partyid, locationid, cytiid);
                processorQueueProducer.votingRegistrationQueue(cedula, candidateid, partyid, locationid, cytiid);
                processorQueueProducer.votingQueryQueue(cedula, candidateid, partyid, locationid, cytiid);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else{
            System.out.println("el lugar registrado para votar no es el correcto, no puede votar aqui");
            throw new RuntimeException("el lugar registrado para votar no es el correcto, no puede votar aqui");
        }
    }

    public Vote buscar(Integer id){

        return voteRepository.findById(id).get();
    }
}
