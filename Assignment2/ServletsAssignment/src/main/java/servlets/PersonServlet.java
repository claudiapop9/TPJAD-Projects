package servlets;

import beans.PersonBeanImpl;
import entities.Person;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "PersonServlet", urlPatterns = "/person")
public class PersonServlet extends HttpServlet {
    private PersonBeanImpl personService = new PersonBeanImpl();
    //    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//       try {
//            request.setAttribute("fullName", fullName);
//            response.setHeader("FullName", fullName);
//
//            RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
//            dispatcher.forward(request, response);
//        } catch (Exception e) {
//            response.sendRedirect("index.jsp");
//        }
//    }

    @Override
    protected void doGet(javax.servlet.http.HttpServletRequest request, HttpServletResponse
            response) throws ServletException, IOException {
        String cnp = request.getParameter("cnp");
        Person person = personService.getPersonByCnp(cnp);

        response.setContentType("text/json");
        PrintWriter out = response.getWriter();
        StringBuilder textResponse = new StringBuilder("[" + person + "]");
        out.println(textResponse);
    }
}