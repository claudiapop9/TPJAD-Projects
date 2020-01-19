package com.tpjad.ejb.assig.beans.interfaces;
import com.tpjad.ejb.assig.entities.Person;

import javax.ejb.Local;
import java.util.List;

@Local
public interface PersonServiceLocal {
    List<Person> getAll();
    Person getPersonByCnp(String cnp);
}
