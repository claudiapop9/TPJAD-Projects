package com.tpjad.ejb.assig.entities;

import java.io.Serializable;


public class Person implements Serializable {
    private int id;
    private String cnp;
    private String firstName;
    private String lastName;
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
