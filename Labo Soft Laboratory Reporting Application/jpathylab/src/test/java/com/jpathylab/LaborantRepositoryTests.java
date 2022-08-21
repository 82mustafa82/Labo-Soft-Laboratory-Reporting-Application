package com.jpathylab;
import com.jpathylab.model.Laborant;
import com.jpathylab.repository.LaborantRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class LaborantRepositoryTests {
    @Autowired
    private LaborantRepository repo;

    /*@Test
    public void testAddNew(){
        Laborant laborant = new Laborant();
        laborant.setLaborantFirstName("Dilara");
        laborant.setLaborantLastName("Suveren");
        laborant.setHospitalNo("2222222");
        Laborant savedLaborant = repo.save(laborant);
        Assertions.assertThat(savedLaborant).isNotNull();
        Assertions.assertThat(savedLaborant.getLid()).isGreaterThan(0);
    }*/

    /*@Test
    public void testListAll(){
        Iterable<Laborant> laborants = repo.findAll();
        Assertions.assertThat(laborants).hasSizeGreaterThan(0);
        for (Laborant laborant : laborants){
            System.out.println(laborant);
        }
    }*/

    /*@Test
    public void testUpdate(){
        Integer lid = 2;
        Optional<Laborant> optionalLaborant = repo.findById(lid);
        Laborant laborant = optionalLaborant.get();
        laborant.setLaborantLastName("Tanrikulu");
        repo.save(laborant);
        Laborant updatedLaborant = repo.findById(lid).get();
        Assertions.assertThat(updatedLaborant.getLaborantLastName()).isEqualTo("Tanrikulu");
    }*/

    /*@Test
    public void testGet(){
        Integer lid = 2;
        Optional<Laborant> optionalLaborant = repo.findById(lid);
        Assertions.assertThat(optionalLaborant).isPresent();
        System.out.println(optionalLaborant.get());
    }*/

    /*@Test
    public void testDelete(){
        Integer lid = 2;
        repo.deleteById(lid);
        Optional<Laborant> optionalLaborant = repo.findById(lid);
        Assertions.assertThat(optionalLaborant).isNotPresent();
    }*/
}
