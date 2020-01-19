package com.tpjad.ejb.assig.beans.interfaces;
import com.tpjad.ejb.assig.entities.Person;
import java.util.List;


public interface PersonServiceRemote {
    List<Person> getAll();
    Person getPersonByCnp(String cnp);
}
