package valentinIT.APIREST_ValentinFornes.services;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import valentinIT.APIREST_ValentinFornes.entities.Domicilio;
import valentinIT.APIREST_ValentinFornes.repositories.DomicilioRepository;

import java.util.List;
import java.util.Optional;

@Service
public class DomicilioService implements BaseService<Domicilio> {
    private DomicilioRepository domiciliorepository;

    public DomicilioService (DomicilioRepository domiciliorepository) {
        this.domiciliorepository = domiciliorepository;
    }

    @Override
    @Transactional
    public List<Domicilio> findAll() throws Exception {
        try{
            List<Domicilio> entities = domiciliorepository.findAll();
            return entities;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Domicilio findById(Long id) throws Exception {
        try{
            Optional<Domicilio> entityOptional = domiciliorepository.findById(id);
            return entityOptional.get();
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Domicilio save(Domicilio entity) throws Exception {
        try{
            entity = domiciliorepository.save(entity);
            return entity;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Domicilio update(Long id, Domicilio entity) throws Exception {
        try{
            Optional<Domicilio> entityOptional = domiciliorepository.findById(id);
            Domicilio domicilio = entityOptional.get();
            domicilio = domiciliorepository.save(domicilio);
            return domicilio;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public boolean delete(Long id) throws Exception {
        try{
            if (domiciliorepository.existsById(id)){
                domiciliorepository.deleteById(id);
                return true;
            }else{
                throw new Exception();
            }
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
