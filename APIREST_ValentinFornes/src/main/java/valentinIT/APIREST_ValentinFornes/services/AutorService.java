package valentinIT.APIREST_ValentinFornes.services;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import valentinIT.APIREST_ValentinFornes.entities.Autor;
import valentinIT.APIREST_ValentinFornes.repositories.AutorRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AutorService implements BaseService<Autor> {

    private AutorRepository autorrepository;

    public AutorService (AutorRepository autorrepository){
        this.autorrepository = autorrepository;
    }

    @Override
    @Transactional
    public List<Autor> findAll() throws Exception {
        try{
            List<Autor> entities = autorrepository.findAll();
            return  entities;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Autor findById(Long id) throws Exception {
        try{
            Optional<Autor> entityOptional = autorrepository.findById(id);
            return entityOptional.get();
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Autor save(Autor entity) throws Exception {
        try{
            entity = autorrepository.save(entity);
            return entity;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Autor update(Long id, Autor entity) throws Exception {
        try{
            Optional<Autor> entityOptional = autorrepository.findById(id);
            Autor autor = entityOptional.get();
            autor = autorrepository.save(autor);
            return autor;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public boolean delete(Long id) throws Exception {
        try{
            if (autorrepository.existsById(id)){
                autorrepository.deleteById(id);
                return true;
            }else {
                throw new Exception();
            }
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
