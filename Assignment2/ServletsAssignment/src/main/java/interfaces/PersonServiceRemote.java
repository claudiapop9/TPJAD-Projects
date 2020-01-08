package interfaces;

import entities.Person;

import javax.ejb.Remote;
import java.util.List;

@Remote
public interface PersonServiceRemote {
    List<Person> getAll();
    Person getPersonByCnp(String cnp);
}
