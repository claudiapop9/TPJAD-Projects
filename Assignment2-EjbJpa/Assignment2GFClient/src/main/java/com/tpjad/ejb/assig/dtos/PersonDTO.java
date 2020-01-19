package com.tpjad.ejb.assig.dtos;

import com.tpjad.ejb.assig.entities.Person;

import java.io.Serializable;

public class PersonDTO implements Serializable {
    private int id=-1;
    private String cnp = "";
    private String firstName  = "";
    private String lastName = "";
    private int cityId = -1;

    public PersonDTO() {
    }

    public PersonDTO(Person person) {
        this.id= person.getId();
        this.cnp=person.getCnp();
        this.firstName=person.getFirstName();
        this.lastName=person.getLastName();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCnp() {
        return cnp;
    }

    public void setCnp(String cnp) {
        this.cnp = cnp;
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

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }
}
