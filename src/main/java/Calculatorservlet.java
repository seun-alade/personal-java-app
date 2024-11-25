// File: CalculatorServlet.java
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/calculator")
public class CalculatorServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.getWriter().println("<html><body>");
        response.getWriter().println("<h1>Simple Calculator</h1>");
        response.getWriter().println("<form method='POST'>");
        response.getWriter().println("Number 1: <input type='text' name='num1'><br>");
        response.getWriter().println("Number 2: <input type='text' name='num2'><br>");
        response.getWriter().println("Operation: ");
        response.getWriter().println("<select name='operation'>");
        response.getWriter().println("<option value='add'>Add</option>");
        response.getWriter().println("<option value='subtract'>Subtract</option>");
        response.getWriter().println("<option value='multiply'>Multiply</option>");
        response.getWriter().println("<option value='divide'>Divide</option>");
        response.getWriter().println("</select><br>");
        response.getWriter().println("<input type='submit' value='Calculate'>");
        response.getWriter().println("</form>");
        response.getWriter().println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        double num1 = Double.parseDouble(request.getParameter("num1"));
        double num2 = Double.parseDouble(request.getParameter("num2"));
        String operation = request.getParameter("operation");

        double result = 0;
        String message = null;

        switch (operation) {
            case "add":
                result = num1 + num2;
                message = "Addition";
                break;
            case "subtract":
                result = num1 - num2;
                message = "Subtraction";
                break;
            case "multiply":
                result = num1 * num2;
                message = "Multiplication";
                break;
            case "divide":
                if (num2 != 0) {
                    result = num1 / num2;
                    message = "Division";
                } else {
                    message = "Error: Division by zero!";
                }
                break;
            default:
                message = "Invalid Operation!";
        }

        response.getWriter().println("<html><body>");
        response.getWriter().println("<h1>Simple Calculator - Result</h1>");
        if (message != null && message.startsWith("Error")) {
            response.getWriter().println("<p style='color: red;'>" + message + "</p>");
        } else {
            response.getWriter().println("<p>" + message + ": " + result + "</p>");
        }
        response.getWriter().println("<a href='/calculator'>Back</a>");
        response.getWriter().println("</body></html>");
    }
}
