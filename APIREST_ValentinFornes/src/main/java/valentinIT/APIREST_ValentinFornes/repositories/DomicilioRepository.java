package valentinIT.APIREST_ValentinFornes.repositories;

import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import valentinIT.APIREST_ValentinFornes.entities.Domicilio;

@Repository
public interface DomicilioRepository extends JpaRepository<Domicilio, Long> {
}
