package interfaces;

import entities.Person;

import javax.ejb.Local;
import java.util.List;

@Local
public interface PersonServiceLocal {
    List<Person> getAll();
    Person getPersonByCnp(String cnp);
}
