package com.tpjad.ejb.assig.servlets;


import com.tpjad.ejb.assig.beans.interfaces.CityServiceLocal;
import com.tpjad.ejb.assig.beans.interfaces.PersonServiceLocal;
import com.tpjad.ejb.assig.dtos.CityDTO;
import com.tpjad.ejb.assig.dtos.PersonDTO;
import com.tpjad.ejb.assig.entities.City;
import com.tpjad.ejb.assig.entities.Person;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("")
public class ClientServlet extends HttpServlet {
    @EJB
    private CityServiceLocal cityService;
    @EJB
    private PersonServiceLocal personService;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("/client-home.jsp");

        List<City> cities = this.cityService.getAll();
        request.setAttribute("cities", cities);

        List<Person> persons = this.personService.getAll();
        request.setAttribute("persons", persons);

        rd.forward(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PersonDTO personDTO = new PersonDTO();
        CityDTO cityDTO = new CityDTO();

        List<City> cities = this.cityService.getAll();
        List<Person> persons = this.personService.getAll();

        if (!request.getParameter("cnp").isEmpty()) {
            personDTO.setCnp(request.getParameter("cnp"));
            Person person = this.personService.getPersonByCnp(personDTO.getCnp());
            persons = new ArrayList<>();
            persons.add(person);
        }else {
            request.setAttribute("cnp", null);
        }

        if (!request.getParameter("country").isEmpty()) {
            cityDTO.setCountry(request.getParameter("country"));
            cities = this.cityService.getByCountry(cityDTO.getCountry());
        }else {
            request.setAttribute("country", null);
        }

        if (!request.getParameter("cityName").isEmpty()) {
            cityDTO.setName(request.getParameter("cityName"));
            City city = this.cityService.getByName(cityDTO.getName());
            cities = new ArrayList<>();
            cities.add(city);
        }else {
            request.setAttribute("cityName", null);
        }

        request.setAttribute("cities", cities);
        request.setAttribute("persons", persons);

        RequestDispatcher rd = request.getRequestDispatcher("/client-home.jsp");
        rd.forward(request, response);
    }
}
