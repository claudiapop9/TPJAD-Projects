package servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "FormServlet", urlPatterns = "/calculateServlet")
public class FormServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String height = request.getParameter("height");
        String weight = request.getParameter("weight");

        try {
            double bmi = calculateBMI(Double.parseDouble(weight), Double.parseDouble(height));

            request.setAttribute("bmi", bmi);
            response.setHeader("BMI", String.valueOf(bmi));

            RequestDispatcher dispatcher = request.getRequestDispatcher("form.jsp");
            dispatcher.forward(request, response);
        } catch (Exception e) {
            response.sendRedirect("form.jsp");
        }
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, HttpServletResponse
            response) throws ServletException, IOException {

        RequestDispatcher dispatcher = request.getRequestDispatcher("/form.jsp");
        dispatcher.forward(request, response);

    }

    private Double calculateBMI(Double weight, Double height) {
        return 10000 * weight / (height * height);
    }
}
