package ru.sberbank.edu;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Hello world!
 *
 */
public class FinancialServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        PrintWriter writer = resp.getWriter();

        writer.write("<html>");
        writer.write("<body>");
        writer.write("<h1> FinancialServlet </h>");
        writer.write("</body>");
        writer.write("</html>");
    }
}
