package valentinIT.APIREST_ValentinFornes.services;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import valentinIT.APIREST_ValentinFornes.entities.Libro;
import valentinIT.APIREST_ValentinFornes.repositories.LibroRepository;

import java.util.List;
import java.util.Optional;

@Service
public class LibroService implements BaseService<Libro> {

    private LibroRepository librorepository;

    public LibroService (LibroRepository librorepository) {
        this.librorepository = librorepository;
    }

    @Override
    @Transactional
    public List<Libro> findAll() throws Exception {
        try{
            List<Libro> entities = librorepository.findAll();
            return entities;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Libro findById(Long id) throws Exception {
        try{
            Optional<Libro> entityOptional = librorepository.findById(id);
            return entityOptional.get();
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Libro save(Libro entity) throws Exception {
        try{
            entity = librorepository.save(entity);
            return entity;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Libro update(Long id, Libro entity) throws Exception {
        try{
            Optional<Libro> entityOptional = librorepository.findById(id);
            Libro libro = entityOptional.get();
            libro = librorepository.save(libro);
            return libro;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public boolean delete(Long id) throws Exception {
        try{
            if (librorepository.existsById(id)){
                librorepository.deleteById(id);
                return true;
            }else{
                throw new Exception();
            }
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
