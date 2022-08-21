package com.jpathylab.repository;
import com.jpathylab.model.Report;
import org.springframework.data.repository.CrudRepository;

public interface ReportRepository extends CrudRepository<Report, Integer> {
    public Long countByRid(Integer rid);
}