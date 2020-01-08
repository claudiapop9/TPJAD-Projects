package beans;

import entities.Person;
import interfaces.PersonServiceLocal;
import interfaces.PersonServiceRemote;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
public class PersonBeanImpl implements PersonServiceLocal, PersonServiceRemote {
    @PersistenceContext(unitName = "tpjad_assig2_ejb")
    private EntityManager manager;

    @Override
    public List<Person> getAll() {
        TypedQuery<Person> query = manager.createQuery("SELECT p FROM Person p", Person.class);
        return query.getResultList();
    }

    @Override
    public Person getPersonByCnp(String cnp) {
        TypedQuery<Person> query = manager.createQuery("SELECT p FROM Person AS p WHERE p.cnp = :cnp", Person.class);
        query.setParameter("cnp", cnp);
        return query.getSingleResult();
    }
}
