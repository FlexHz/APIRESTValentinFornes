package valentinIT.APIREST_ValentinFornes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import valentinIT.APIREST_ValentinFornes.entities.Persona;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Long> {
}
