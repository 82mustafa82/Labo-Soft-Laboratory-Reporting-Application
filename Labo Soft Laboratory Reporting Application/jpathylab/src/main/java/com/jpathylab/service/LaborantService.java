package com.jpathylab.service;
import com.jpathylab.exception.LaborantNotFoundException;
import com.jpathylab.model.Laborant;
import com.jpathylab.repository.LaborantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class LaborantService {
    @Autowired
    private LaborantRepository repo;
    public LaborantRepository getRepo() {return repo;}
    public void setRepo(LaborantRepository repo) {this.repo = repo;}

    public List<Laborant> listAll(){
        return (List<Laborant>) repo.findAll();
    }
    public void save(Laborant laborant) {
        repo.save(laborant);
    }
    public Laborant get(Integer lid) throws LaborantNotFoundException {
        Optional<Laborant> result = repo.findById(lid);
        if(result.isPresent()){
            return result.get();
        }
        throw new LaborantNotFoundException("Could not find any laborants with ID" + lid);
    }

    public void delete(Integer lid) throws LaborantNotFoundException {
        Long count = repo.countByLid(lid);
        if(count == null || count == 0){
            throw new LaborantNotFoundException("Could not find any laborants with ID" + lid);
        }
        repo.deleteById(lid);
    }
}