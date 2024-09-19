package valentinIT.APIREST_ValentinFornes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import valentinIT.APIREST_ValentinFornes.entities.Libro;

@Repository
public interface LibroRepository extends JpaRepository<Libro, Long> {
}
