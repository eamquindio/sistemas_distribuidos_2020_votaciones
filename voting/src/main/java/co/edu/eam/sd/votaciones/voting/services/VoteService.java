package co.edu.eam.sd.votaciones.voting.services;


import co.edu.eam.sd.votaciones.voting.encrypt.Encrypt;
import co.edu.eam.sd.votaciones.voting.model.entities.Vote;
import co.edu.eam.sd.votaciones.voting.model.responses.VoteBiometria;
import co.edu.eam.sd.votaciones.voting.producers.ProcessorQueueProducer;
import co.edu.eam.sd.votaciones.voting.repository.VoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class VoteService {

    @Autowired
    private VoteRepository voteRepository;

    @Autowired
    private ProcessorQueueProducer processorQueueProducer;

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    private Vote vote;

    //aqui es donde se llaman los metodos para realizar la consulta de la otra api
    //se guarda los datos en la base de datos de voting
    //se llamam a los metodo que mandan las colas
    public void create(VoteBiometria vot){

        //si trae algo pero como encritado traer el modelo si algo y probar
        //String addressList =  redisTemplate.opsForValue().get("votingLocation::1094942083");
        //System.out.println("estes es lo que trae el redis"+addressList);
        vote = new Vote();
        vote.setId(vot.getId());
        vote.setCandidateId(vot.getCandidateId());
        vote.setPartyId(vot.getPartyId());
        vote.setCity(vot.getCity());
        vote.setLocation(vot.getLocation());
        vote.setDateTime(vot.getDateTime());
        voteRepository.save(vote);
        try {
            processorQueueProducer.votingRegistraduriaQueue(vot.getCandidateId(),vot.getPartyId());
            processorQueueProducer.votingRegistrationQueue(vote);
            processorQueueProducer.votingQueryQueue(vote);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Vote buscar(Integer id){

        return voteRepository.findById(id).get();
    }
}
