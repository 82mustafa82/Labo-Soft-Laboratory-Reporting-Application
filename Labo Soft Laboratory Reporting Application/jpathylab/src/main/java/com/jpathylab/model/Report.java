package com.jpathylab.model;
import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
public class Report implements Serializable{
    private static final long serialVersionUID = -232703025788110670L;

    //--PROPERTIES--
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, length = 10, nullable = false, updatable = false)
    private Integer rid;
    @Column(unique = true, length = 7, nullable = false, updatable = false)
    private String number;
    @Column(length = 20, nullable = false, updatable = true)
    private String patientFirstName;
    @Column(length = 20, nullable = false, updatable = true)
    private String patientLastName;
    @Column(length = 11, nullable = false, updatable = true)
    private String identity;
    @Column(length = 50, nullable = false, updatable = true)
    private String diagnosis;
    @DateTimeFormat(pattern = "mm/dd/yyyy")
    private String addDate;
    @Column(length = 500, nullable = false, updatable = true)
    @Lob
    private String reportDefinition;
    @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinTable(
            name = "report_laborant",
            joinColumns = @JoinColumn(name = "rid"),
            inverseJoinColumns = @JoinColumn(name = "lid")
            )
    private Set<Laborant> laborants = new HashSet<>();

    //--CONSTRUCTORS--
    public Report() {

    }
    public Report(String number, String patientFirstName, String patientLastName, String identity, String diagnosis, String addDate, String report) {
        this.number = number;
        this.patientFirstName = patientFirstName;
        this.patientLastName = patientLastName;
        this.identity = identity;
        this.diagnosis = diagnosis;
        this.addDate = addDate;
        this.reportDefinition = report;
    }

    //--GETTERS AND SETTERS--
    public Integer getRid() {
        return rid;
    }
    public void setRid(Integer rid) {
        this.rid = rid;
    }
    public String getNumber() {
        return number;
    }
    public void setNumber(String number) {
        this.number = number;
    }
    public String getPatientFirstName() {
        return patientFirstName;
    }
    public void setPatientFirstName(String patientFirstName) {
        this.patientFirstName = patientFirstName;
    }
    public String getPatientLastName() {
        return patientLastName;
    }
    public void setPatientLastName(String patientLastName) {
        this.patientLastName = patientLastName;
    }
    public String getIdentity() {
        return identity;
    }
    public void setIdentity(String identity) {
        this.identity = identity;
    }
    public String getDiagnosis() {
        return diagnosis;
    }
    public void setDiagnosis(String diagnosis) { this.diagnosis = diagnosis; }
    public String getAddDate() {
        return addDate;
    }
    public void setAddDate(String addDate) {
        this.addDate = addDate;
    }
    public String getReportDefinition() {
        return reportDefinition;
    }
    public void setReportDefinition(String reportDefinition) {
        this.reportDefinition = reportDefinition;
    }
    public Set<Laborant> getLaborants() {
        return laborants;
    }
    public void setLaborants(Set<Laborant> laborants) {
        this.laborants = laborants;
    }

    //--METHODS--
    public void addLaborant(Laborant laborant){
        this.laborants.add(laborant);
    }
    public void removeLaborant(Laborant laborant){
        this.laborants.remove(laborant);
    }
    public Laborant findLaborant(Laborant laborant){
        if(this.laborants.contains(laborant)){
            return laborant;
        }
        else return null;
    }

    //--TOSTRING--
    @Override
    public String toString() {
        return "Report{" +
                "rid=" + rid +
                ", number='" + number + '\'' +
                ", patientFirstName='" + patientFirstName + '\'' +
                ", patientLastName='" + patientLastName + '\'' +
                ", identity='" + identity + '\'' +
                ", diagnosis='" + diagnosis + '\'' +
                ", addDate=" + addDate +
                ", report='" + reportDefinition + '\'' +
                '}';
    }
}