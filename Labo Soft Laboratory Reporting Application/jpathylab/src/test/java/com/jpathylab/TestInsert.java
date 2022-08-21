package com.jpathylab;
import com.jpathylab.enums.UserType;
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
public class TestInsert {
    @Autowired
    private LaborantRepository laborantRepo;
    @Autowired
    private ReportRepository reportRepo;
    @Autowired
    private UserRepository userRepo;

    /*@Test
    public void insertData(){
        Laborant laborant = new Laborant("Mustafa", "Aydin", "1601170");
        laborantRepo.save(laborant);
        User user = new User("mustafa", "fatma", UserType.admin.toString());
        user.setLaborant(laborant);
        userRepo.save(user);
        Laborant laborant2 = new Laborant("Fatma", "Tanrikulu", "1601108");
        laborantRepo.save(laborant2);
        User user2 = new User("fatma", "mustafa", UserType.laborant.toString());
        user2.setLaborant(laborant2);
        userRepo.save(user2);
        Report report = new Report("1234", "Zeynep", "Danis",
                "12345678901", "Prostate Cancer", "2020-04-04", "asd");
        report.addLaborant(laborant);
        reportRepo.save(report);
        Report report2 = new Report("5678", "Semih", "Durmaz",
                "23456789012", "Lymphoma", "2020-05-05", "asd");
        report2.addLaborant(laborant);
        reportRepo.save(report2);
        Laborant laborant3 = new Laborant("Busra", "Kuden", "1234567");
        laborantRepo.save(laborant3);
        Laborant laborant4 = new Laborant("Yunus", "Demir", "8901234");
        laborantRepo.save(laborant4);
        Report report3 = new Report("3456", "Furkan", "Kocyigit",
                "45678901234", "Rapid Cancer", "2020-06-06", "asd");
        Report report4 = new Report("7890", "Betul", "Sinar",
                "56789012345", "Skin Cancer", "2020-07-07", "asd");
        Report report5 = new Report("0987", "Halid", "Sipahioglu",
                "67890123456", "Infectious Disease", "2020-08-08", "asd");
        Laborant laborant5 = new Laborant("Betul", "Ozmaral", "5678901");
        laborantRepo.save(laborant5);
        report3.addLaborant(laborant5);
        report4.addLaborant(laborant5);
        Laborant laborant6 = new Laborant("Betul", "On", "2345678");
        laborantRepo.save(laborant6);
        report4.addLaborant(laborant6);
        report5.addLaborant(laborant6);
        reportRepo.save(report3);
        reportRepo.save(report4);
        reportRepo.save(report5);
    }*/
}