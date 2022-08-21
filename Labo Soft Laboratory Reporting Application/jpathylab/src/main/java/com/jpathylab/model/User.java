package com.jpathylab.model;
import javax.persistence.*;
import java.io.Serializable;

@Entity
public class User implements Serializable{
    private static final long serialVersionUID = 2154269355485347301L;

    //--PROPERTIES--
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, length = 10, nullable = false, updatable = false)
    private Integer uid;
    @Column(unique = true, nullable = false, length = 20, updatable = true)
    private String userName;
    @Column(nullable = false, length = 20, updatable = true)
    private String password;
    @Column()
    private String type;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lid")
    private Laborant laborant;

    //--CONSTRUCTORS--
    public User() {

    }
    public User(String userName, String password, String type) {
        this.userName = userName;
        this.password = password;
        this.type = type;
    }

    //--GETTERS AND SETTERS--
    public Integer getUid() {
        return uid;
    }
    public void setUid(Integer uid) {
        this.uid = uid;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public Laborant getLaborant() {
        return laborant;
    }
    public void setLaborant(Laborant laborant) {this.laborant = laborant;}

    //--TOSTRING--
    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}