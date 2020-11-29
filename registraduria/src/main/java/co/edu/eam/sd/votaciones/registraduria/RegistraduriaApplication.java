package co.edu.eam.sd.votaciones.registraduria;

import co.edu.eam.sd.votaciones.registraduria.producers.VoterNotificationsProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RegistraduriaApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(RegistraduriaApplication.class, args);
	}

}
