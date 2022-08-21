package com.jpathylab.repository;
import com.jpathylab.model.Laborant;
import org.springframework.data.repository.CrudRepository;

public interface LaborantRepository extends CrudRepository<Laborant, Integer> {
    public Long countByLid(Integer lid);
}