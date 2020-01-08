package entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class City implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQMYCLASSID")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "region")
    private String region;
    @Column(name = "country")
    private String country;

    public City() {
    }

    public City(int id, String name, String region, String country) {
        this.id = id;
        this.name = name;
        this.region = region;
        this.country = country;
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

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Name: " + name + " Region: "+ region+ "Country: " + country;
    }
}
