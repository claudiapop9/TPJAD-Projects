package servlets;

import beans.CityBeanImpl;
import beans.PersonBeanImpl;
import entities.City;
import entities.Person;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ClientServlet", urlPatterns = "")
public class ClientServlet extends HttpServlet {
    private PersonBeanImpl personService = new PersonBeanImpl();
    private CityBeanImpl cityService = new CityBeanImpl();

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");

        List<Person> persons = this.personService.getAll();
        request.setAttribute("persons", persons);

        List<City> cities = this.cityService.getAll();
        request.setAttribute("cities", cities);

        rd.forward(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String cnp = request.getParameter("cnp");
        Person person = this.personService.getPersonByCnp(cnp);
        request.setAttribute("person", person);

        List<City> cities = this.cityService.getAll();
        request.setAttribute("cities", cities);

        RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
        rd.forward(request, response);
    }
}
