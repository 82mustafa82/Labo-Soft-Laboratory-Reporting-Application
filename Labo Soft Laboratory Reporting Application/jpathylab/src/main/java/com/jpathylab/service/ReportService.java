package com.jpathylab.service;
import com.jpathylab.exception.ReportNotFoundException;
import com.jpathylab.model.Report;
import com.jpathylab.repository.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ReportService {
    @Autowired
    private ReportRepository repo;

    public List<Report> listAll(){
        return (List<Report>) repo.findAll();
    }
    public void save(Report report) {
        repo.save(report);
    }
    public Report get(Integer rid) throws ReportNotFoundException {
        Optional<Report> result = repo.findById(rid);
        if(result.isPresent()){
            return result.get();
        }
        throw new ReportNotFoundException("Could not find any reports with ID" + rid);
    }

    public void delete(Integer rid) throws ReportNotFoundException {
        Long count = repo.countByRid(rid);
        if(count == null || count == 0){
            throw new ReportNotFoundException("Could not find any reports with ID" + rid);
        }
        repo.deleteById(rid);
    }
}