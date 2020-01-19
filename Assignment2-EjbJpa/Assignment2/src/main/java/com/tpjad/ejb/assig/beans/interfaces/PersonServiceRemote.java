package com.tpjad.ejb.assig.beans.interfaces;

import com.tpjad.ejb.assig.entities.Person;
import javax.ejb.Remote;
import java.util.List;

@Remote
public interface PersonServiceRemote {
    List<Person> getAll();
    Person getPersonByCnp(String cnp);
}
