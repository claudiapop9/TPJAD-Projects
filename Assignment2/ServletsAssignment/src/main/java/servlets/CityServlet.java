package servlets;

import beans.CityBeanImpl;
import entities.City;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "CityServlet", urlPatterns = "/city")
public class CityServlet extends HttpServlet {

    CityBeanImpl cityService = new CityBeanImpl();
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String height = request.getParameter("height");
//        String weight = request.getParameter("weight");
//
//        try {
//            double bmi = calculateBMI(Double.parseDouble(weight), Double.parseDouble(height));
//
//            request.setAttribute("bmi", bmi);
//            response.setHeader("BMI", String.valueOf(bmi));
//
//            RequestDispatcher dispatcher = request.getRequestDispatcher("form.jsp");
//            dispatcher.forward(request, response);
//        } catch (Exception e) {
//            response.sendRedirect("form.jsp");
//        }
//    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, HttpServletResponse
            response) throws ServletException, IOException {

        String country = request.getParameter("country");
        String region = request.getParameter("region");
        List<City> citiesByCountryRegion = cityService.getByCountryRegion(country, region);

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        StringBuilder textResponse = new StringBuilder();
        for (City c : citiesByCountryRegion) {
            textResponse.append("\"").append(c.getName()).append("\", ");
        }
        textResponse = new StringBuilder("[" + textResponse.substring(0, textResponse.length()) + "]");
        out.println(textResponse);
    }


//    private Double calculateBMI(Double weight, Double height) {
//        return 10000 * weight / (height * height);
//    }
}
