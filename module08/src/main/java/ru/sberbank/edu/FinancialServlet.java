package ru.sberbank.edu;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/finance/*", loadOnStartup = 1)
public class FinancialServlet extends HttpServlet {
    Сalculation сalculation = null;
    FinancialFields financialFields = null;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = getAction(req);
        if ("/calc".equals(action)) {
            req.setAttribute("profit", сalculation.getProfit());
            getServletContext().getRequestDispatcher("/profit.jsp").forward(req, resp);
        } else {
            getServletContext().getRequestDispatcher("/finance.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = getAction(req);
        if ("/calc".equals(action)) {
            String years = req.getParameter("years");
            String sum = req.getParameter("sum");
            String percentage = req.getParameter("percentage");
            try {
                financialFields  = new FinancialFields(Integer.parseInt(years), Double.parseDouble(sum), Double.parseDouble(percentage));
            } catch (NumberFormatException ex) {
                getServletContext().getRequestDispatcher("/errordata.jsp").forward(req, resp);
            }
            if ( financialFields.getSum() < 0 || financialFields.getYears() < 0 || financialFields.getPercentage() < 0) {
                getServletContext().getRequestDispatcher("/errordata.jsp").forward(req, resp);
            }
            if (financialFields.getSum() < 50000){
                getServletContext().getRequestDispatcher("/errorsum.jsp").forward(req, resp);
            }
            сalculation = new Сalculation(financialFields);
            req.setAttribute("profit", сalculation.getProfit());
            getServletContext().getRequestDispatcher("/profit.jsp").forward(req, resp);
        }
    }

    private String getAction(HttpServletRequest request) {
        String controllerName = "/finance";
        String url = request.getRequestURI();
        int controllerStartIndex = url.indexOf(controllerName);
        return url.substring(controllerStartIndex + controllerName.length());
    }
}
