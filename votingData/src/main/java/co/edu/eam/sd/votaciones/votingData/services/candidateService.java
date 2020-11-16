package co.edu.eam.sd.votaciones.votingData.services;

import co.edu.eam.sd.votaciones.votingData.model.entities.Candidate;
import co.edu.eam.sd.votaciones.votingData.model.entities.CanditoPartido;
import co.edu.eam.sd.votaciones.votingData.model.entities.Party;
import co.edu.eam.sd.votaciones.votingData.repository.CandidateRepository;
import co.edu.eam.sd.votaciones.votingData.repository.PartyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class candidateService {

    @Autowired
    private PartyRepository partyRepository;

    @Autowired
    private CandidateRepository candidateRepository;

    public List<CanditoPartido> buscarCandidatos(){
        CanditoPartido canditoPartido;
        List<CanditoPartido> candipartido = new ArrayList<>();
        List<Party> partidos = partyRepository.findAll();
        List<Candidate> candidatos = candidateRepository.findAll();

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
            candipartido.add(canditoPartido);
        }
        return candipartido;
    }
}
