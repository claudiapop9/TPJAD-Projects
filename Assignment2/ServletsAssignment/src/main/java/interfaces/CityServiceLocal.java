package interfaces;

import entities.City;

import javax.ejb.Local;
import java.util.List;

@Local
public interface CityServiceLocal {

    City getByName(String name);

    List<City> getByCountryRegion(String country, String region);

    List<City> getAll();
}
