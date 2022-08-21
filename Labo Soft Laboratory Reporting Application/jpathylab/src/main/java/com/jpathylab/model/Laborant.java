package com.jpathylab.model;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "laborant")
public class Laborant implements Serializable{
    private static final long serialVersionUID = -3699818237742791477L;

    //--PROPERTIES--
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "lid", unique = true, length = 10, nullable = false, updatable = false)
    private Integer lid;
    @Column(name = "laborantFirstName", length = 20, nullable = false, updatable = true)
    private String laborantFirstName;
    @Column(name = "laborantLastName", length = 20, nullable = false, updatable = true)
    private String laborantLastName;
    @Column(name = "hospitalNo", unique = true, length = 7, nullable = false, updatable = true)
    private String hospitalNo;

    //--CONSTRUCTORS--
    public Laborant() {

    }
    public Laborant(Integer lid) {
        this.lid = lid;
    }
    public Laborant(String laborantFirstName, String laborantLastName, String hospitalNo) {
        this.laborantFirstName = laborantFirstName;
        this.laborantLastName = laborantLastName;
        this.hospitalNo = hospitalNo;
    }

    //--GETTERS AND SETTERS--
    public Integer getLid() {
        return lid;
    }
    public void setLid(Integer lid) {
        this.lid = lid;
    }
    public String getLaborantFirstName() {
        return laborantFirstName;
    }
    public void setLaborantFirstName(String laborantFirstName) {
        this.laborantFirstName = laborantFirstName;
    }
    public String getLaborantLastName() {
        return laborantLastName;
    }
    public void setLaborantLastName(String laborantLastName) {
        this.laborantLastName = laborantLastName;
    }
    public String getHospitalNo() {
        return hospitalNo;
    }
    public void setHospitalNo(String hospitalNo) {
        this.hospitalNo = hospitalNo;
    }

    //--EQUALS AND HASHCODE--
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Laborant)) return false;
        Laborant laborant = (Laborant) o;
        return getLid().equals(laborant.getLid());
    }
    @Override
    public int hashCode() {
        return Objects.hash(getLid());
    }

    //--TOSTRING--
    @Override
    public String toString() {
        return laborantFirstName + ' ' + laborantLastName;
    }
}