package valentinIT.APIREST_ValentinFornes.services;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import valentinIT.APIREST_ValentinFornes.entities.Localidad;
import valentinIT.APIREST_ValentinFornes.repositories.LocalidadRepository;

import java.util.List;
import java.util.Optional;

@Service
public class LocalidadService implements BaseService<Localidad> {

    private LocalidadRepository localidadrepository;

    public LocalidadService (LocalidadRepository localidadrepository) {
        this.localidadrepository = localidadrepository;
    }

    @Override
    @Transactional
    public List<Localidad> findAll() throws Exception {
        try{
            List<Localidad> entities = localidadrepository.findAll();
            return entities;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Localidad findById(Long id) throws Exception {
        try{
            Optional<Localidad> entityOptional = localidadrepository.findById(id);
            return entityOptional.get();
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Localidad save(Localidad entity) throws Exception {
        try{
            entity = localidadrepository.save(entity);
            return entity;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Localidad update(Long id, Localidad entity) throws Exception {
        try{
            Optional<Localidad> entityOptional = localidadrepository.findById(id);
            Localidad localidad = entityOptional.get();
            localidad = localidadrepository.save(localidad);
            return localidad;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public boolean delete(Long id) throws Exception {
        try{
            if (localidadrepository.existsById(id)){
                localidadrepository.deleteById(id);
                return true;
            }else{
                throw new Exception();
            }
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
