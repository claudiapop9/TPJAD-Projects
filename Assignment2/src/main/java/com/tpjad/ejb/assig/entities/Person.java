package com.tpjad.ejb.assig.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Person implements Serializable {
    @Id
    //@GeneratedValue
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQMYCLASSID")
    private int id;
    @Column(name = "cnp")
    private String cnp;
    @Column(name = "firstName")
    private String firstName;
    @Column(name = "lastName")
    private String lastName;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "city")
    private City city;

    public Person() {
    }

    public Person(String cnp, String firstName, String lastName, City city) {
        this.cnp = cnp;
        this.firstName = firstName;
        this.lastName = lastName;
        this.city = city;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public String getCnp() {
        return cnp;
    }

    public void setCnp(String cnp) {
        this.cnp = cnp;
    }

    @Override
    public String toString() {
        return "CNP:" + cnp + " First Name: " + firstName + " Last Name: "+ lastName+ "City: " + city;
    }
}
