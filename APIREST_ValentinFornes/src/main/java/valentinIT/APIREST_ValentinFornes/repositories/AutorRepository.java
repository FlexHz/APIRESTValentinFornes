package valentinIT.APIREST_ValentinFornes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import valentinIT.APIREST_ValentinFornes.entities.Autor;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Long> {
}
