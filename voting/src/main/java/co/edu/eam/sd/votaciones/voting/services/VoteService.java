package co.edu.eam.sd.votaciones.voting.services;


import co.edu.eam.sd.votaciones.voting.model.entities.Vote;
import co.edu.eam.sd.votaciones.voting.producers.ProcessorQueueProducer;
import co.edu.eam.sd.votaciones.voting.repository.VoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VoteService {

    @Autowired
    private VoteRepository voteRepository;

    @Autowired
    private ProcessorQueueProducer processorQueueProducer;



    //aqui es donde se llaman los metodos para realizar la consulta de la otra api
    //se guarda los datos en la base de datos de voting
    //se llamam a los metodo que mandan las colas
    public void create(Vote vot){

        voteRepository.save(vot);
        try {
            processorQueueProducer.votingRegistraduriaQueue(vot);
            processorQueueProducer.votingRegistrationQueue(vot);
            processorQueueProducer.votingQueryQueue(vot);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Vote buscar(Integer id){

        return voteRepository.findById(id).get();
    }
}
