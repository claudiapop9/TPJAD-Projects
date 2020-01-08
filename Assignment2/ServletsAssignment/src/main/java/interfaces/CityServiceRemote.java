package interfaces;

import entities.City;

import javax.ejb.Remote;
import java.util.List;

@Remote
public interface CityServiceRemote {
    City getByName(String name);

    List<City> getAll();

    List<City> getByCountryRegion(String country, String region);
}
