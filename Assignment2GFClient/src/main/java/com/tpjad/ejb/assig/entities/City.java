package com.tpjad.ejb.assig.entities;
import java.io.Serializable;


public class City implements Serializable, Comparable {
    private int id;
    private String name;
    private String region;
    private String country;


    public City() {
        super();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }


    @Override
    public int compareTo(Object o) {
        if (this == o) return 0;
        if (!(o instanceof City)) return -1;
        return getName().compareTo(((City) o).getName());
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", region='" + region + '\'' +
                ", country='" + country + '}';
    }
}
