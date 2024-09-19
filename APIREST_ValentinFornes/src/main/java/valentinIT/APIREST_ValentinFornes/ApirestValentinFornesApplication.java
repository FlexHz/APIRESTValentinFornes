package valentinIT.APIREST_ValentinFornes;

import valentinIT.APIREST_ValentinFornes.entities.*;
import valentinIT.APIREST_ValentinFornes.repositories.*;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class ApirestValentinFornesApplication {
	private static final Logger logger = LoggerFactory.getLogger(ApirestValentinFornesApplication.class);

	@Autowired
	private PersonaRepository personaRepository;
	private DomicilioRepository domicilioRepository;
	private AutorRepository autorRepository;
	public static void main(String[] args) {
		SpringApplication.run(ApirestValentinFornesApplication.class, args);

		System.out.println("Arrancando Maquinola TUCUTUCUTUCU");
	}

	@Bean
	@Transactional
	CommandLineRunner init(PersonaRepository personaRepository, AutorRepository autorRepository) {
		return args -> {
			// Creo un objeto persona
			Persona per1 = Persona.builder().
					nombre("Alberto").apellido("Cortez").
					build();

			Domicilio dom1 = Domicilio.builder().
					calle("Suipacha").
					numero(239).build();

			per1.setDomicilio(dom1);

			personaRepository.save(per1);

// Creo otra persona
			Persona per2 = Persona.builder().
					nombre("Alicia").apellido("Calderon").
					build();

			Domicilio dom2 = Domicilio.builder().
					calle("Lulunta").
					numero(339).build();

			per2.setDomicilio(dom2);


			// Lo grabo a través del repositorio de Spring
			personaRepository.save(per2);

			List<Persona> recuperadas = personaRepository.findAll();
			System.out.println(recuperadas);

			logger.info("Detalles de la persona: {}", recuperadas);


			Optional<Persona> recuperada = personaRepository.findById(1L);
			System.out.println(recuperada);

			logger.info("Detalles de la persona: {}", recuperada);


			dom1.setCalle("Rodriguezaaaa");

			personaRepository.save(per1);


			//Creo un autor
			Autor aut1 = Autor.builder().
					nombre("Jorge Luis").
					apellido("Borges").
					build();
			aut1.setBio("fue un escritor, poeta, ensayista y traductor argentino, extensamente considerado una figura clave tanto para la literatura en español como para la literatura universal");
			autorRepository.save(aut1);


			List<Autor> recuperados = autorRepository.findAll();
			System.out.println(recuperados);

			logger.info("Detalles del autor: {}", recuperados);

			Optional<Autor> recuperado = autorRepository.findById(1L);
			System.out.println(recuperado);

			logger.info("Detalles de la persona: {}", recuperados);

		};

	};

}
