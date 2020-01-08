package beans;

import entities.City;
import interfaces.CityServiceLocal;
import interfaces.CityServiceRemote;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
public class CityBeanImpl implements CityServiceLocal, CityServiceRemote {
    @PersistenceContext(unitName = "tpjad_assig2_ejb")
    private EntityManager manager;

    @Override
    public City getByName(String name) {
        TypedQuery<City> query = manager.createQuery("SELECT c FROM City AS c WHERE c.name = :name", City.class);
        query.setParameter("name", name);
        return query.getSingleResult();
    }

    @Override
    public List<City> getAll() {
        TypedQuery<City> query = manager.createQuery("SELECT c FROM City c", City.class);
        return query.getResultList();
    }

    @Override
    public List<City> getByCountryRegion(String country, String region) {
        TypedQuery<City> query = manager.createQuery("SELECT c FROM City AS c WHERE c.country = :country and c.region = :region", City.class);
        query.setParameter("country", country);
        query.setParameter("region", region);
        return query.getResultList();
    }
}
