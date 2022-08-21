package com.jpathylab;
import com.jpathylab.model.Laborant;
import com.jpathylab.model.Report;
import com.jpathylab.model.User;
import com.jpathylab.repository.LaborantRepository;
import com.jpathylab.repository.ReportRepository;
import com.jpathylab.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class TestFind {
    @Autowired
    private LaborantRepository laborantRepo;
    @Autowired
    private ReportRepository reportRepo;
    @Autowired
    private UserRepository userRepo;

    /*@Test
    public void testFinding(){
        //--FIND--
        User user2 = userRepo.findById(6).get();
        Laborant laborant = laborantRepo.findById(15).get();
        System.out.println(user2);
        System.out.println(user2.getLaborant());
        System.out.println(laborant);

        Report report = new Report("9012", "Sena", "Ocakci",
                "34567890123", "Cancer", "2020-09-09", "asd");
        Laborant laborant2 = laborantRepo.findById(16).get();
        report.addLaborant(laborant2);
        reportRepo.save(report);
    }*/
}