package com.jpathylab;
import com.jpathylab.model.Laborant;
import com.jpathylab.model.Report;
import com.jpathylab.repository.LaborantRepository;
import com.jpathylab.repository.ReportRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class TestFindALL {
    @Autowired
    private LaborantRepository laborantRepo;
    @Autowired
    private ReportRepository reportRepo;

    /*@Test
    public void testFindingALL(){
        Integer lid = 15;
        Laborant laborant = laborantRepo.findById(lid).get();
        System.out.println(laborant);
        Iterable<Report> reports = reportRepo.findAll();
        for (Report r : reports) {
            if(r.findLaborant(laborant) != null){
                System.out.println(r);
            }
        }
    }*/
}