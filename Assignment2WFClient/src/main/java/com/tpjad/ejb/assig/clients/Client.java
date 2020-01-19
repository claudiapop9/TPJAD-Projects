package com.tpjad.ejb.assig.clients;

import com.tpjad.ejb.assig.beans.interfaces.CityServiceRemote;
import com.tpjad.ejb.assig.beans.interfaces.PersonServiceRemote;
import com.tpjad.ejb.assig.entities.City;

import javax.naming.InitialContext;
import java.util.List;
import java.util.Properties;

public class Client {
    static final Properties JNDI = new Properties();

    static {
        JNDI.put("java.naming.factory.initial", "org.jboss.naming.remote.client.InitialContextFactory");
        JNDI.put("java.naming.provider.url", "http-remoting://localhost:8080");
    }

    static final String JNDICityService = "Assig2WAR/CityBeanImpl!com.tpjad.ejb.assig.beans.interfaces.CityServiceRemote";
    static final String JNDIPersonService = "Assig2WAR/PersonBeanImpl!com.tpjad.ejb.assig.beans.interfaces.PersonServiceRemote";

    public static void main(String[] args) throws Exception {
        CityServiceRemote cityServiceProxy = (CityServiceRemote) (new InitialContext(JNDI).lookup(JNDICityService));
        PersonServiceRemote personServiceProxy = (PersonServiceRemote) (new InitialContext(JNDI).lookup(JNDIPersonService));

        List<String> countries = cityServiceProxy.getAllCountries();

        countries.forEach(country -> {
            List<City> cities = cityServiceProxy.getByCountry(country);

            System.out.println("[ " + country + " ]");
            cities.forEach(city -> System.out.println(" - " + city.getName()));
        });
    }
}
