package valentinIT.APIREST_ValentinFornes.services;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import valentinIT.APIREST_ValentinFornes.entities.Persona;
import valentinIT.APIREST_ValentinFornes.repositories.PersonaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PersonaService implements BaseService<Persona> {

    private PersonaRepository personarepository;

    public PersonaService (PersonaRepository personarepository){
        this.personarepository = personarepository;
    }

    @Override
    @Transactional
    public List<Persona> findAll() throws Exception {
        try{
            List<Persona> entities = personarepository.findAll();
            return entities;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Persona findById(Long id) throws Exception {
        try{
            Optional<Persona> entityOptional = personarepository.findById(id);
            return entityOptional.get();
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Persona save(Persona entity) throws Exception {
        try{
            entity = personarepository.save(entity);
            return entity;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Persona update(Long id, Persona entity) throws Exception {
        try{
             Optional<Persona> entityOptional = personarepository.findById(id);
             Persona persona = entityOptional.get();
             persona = personarepository.save(persona);
             return persona;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public boolean delete(Long id) throws Exception {
        try{
            if (personarepository.existsById(id)){
                personarepository.deleteById(id);
                return true;
            }else{
                throw new Exception();
            }
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
