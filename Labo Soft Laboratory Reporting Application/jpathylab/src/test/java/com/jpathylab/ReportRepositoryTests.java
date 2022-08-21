package com.jpathylab;
import com.jpathylab.model.Laborant;
import com.jpathylab.model.Report;
import com.jpathylab.repository.ReportRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class ReportRepositoryTests {
    @Autowired
    private ReportRepository repo;
    @Autowired
    private TestEntityManager entityManager;

    /*@Test
    public void testCreateLaborants(){
        Laborant laborant1 = new Laborant("Furkan", "Erçelebi", "3333333");
        Laborant laborant2 = new Laborant("Ömer", "Demir", "4444444");
        Laborant laborant3 = new Laborant("Efe", "Tezcan", "5555555");
        entityManager.persist(laborant1);
        entityManager.persist(laborant2);
        entityManager.persist(laborant3);
    }*/

    /*@Test
    public void testCreateReportWithOneLaborant(){
        Laborant laborant = entityManager.find(Laborant.class, 9);
        Report report = new Report("3333", "Yusuf", "Baskoy",
                "33333333333", "Human Brucellosis", "2020-01-01", "asd");
        report.addLaborant(laborant);
        repo.save(report);
    }*/

    /*@Test
    public void testCreateReportWithTwoLaborants(){
        Laborant laborant1 = entityManager.find(Laborant.class, 10);
        Laborant laborant2 = entityManager.find(Laborant.class, 11);
        Report report = new Report("4444", "Enes", "Tezcan",
                "44444444444", "Primary Ciliary Dyskinesia", "2020-02-02", "asd");
        report.addLaborant(laborant1);
        report.addLaborant(laborant2);
        repo.save(report);
    }*/

    /*@Test
    public void testAssignLaborantToExistingReport(){
        Report report = repo.findById(4).get();
        Laborant laborant = entityManager.find(Laborant.class, 10);
        report.addLaborant(laborant);
    }*/

    /*@Test
    public void testRemoveLaborantFromExistingReport(){
        Report report = repo.findById(4).get();
        Laborant laborant = new Laborant(10);
        report.removeLaborant(laborant);
    }*/

    /*@Test
    public void testCreateNewReportWithNewLaborant(){
        Laborant laborant = new Laborant("Ozgur", "Kan", "6666667");
        Report report = new Report("5555", "Irem", "Ay",
                "55555555555", "Cancer", "2020-03-03", "asd");
        report.addLaborant(laborant);
        repo.save(report);
    }*/

    /*@Test
    public void getReport(){
        Report report = repo.findById(4).get();
        entityManager.detach(report);
        System.out.println(report.getDiagnosis());
        System.out.println(report.getLaborants());
    }*/

    /*@Test
    public void removeReport(){
        repo.deleteById(9);
    }*/
}
