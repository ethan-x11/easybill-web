package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.Bill;

@WebServlet("/BillListServlet")
public class BillListServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Bill> bills = new ArrayList<>();
        bills.add(new Bill("BILL123456", "150 kWh", "March 2025", "2025-03-01", "2025-03-15", "75.00", "Unpaid"));
        bills.add(new Bill("BILL123455", "100 kWh", "February 2025", "2025-02-01", "2025-02-15", "50.00", "Unpaid"));
        bills.add(new Bill("BILL123454", "120 kWh", "January 2025", "2025-01-01", "2025-01-15", "60.00", "Paid"));

        request.setAttribute("bills", bills);

        request.getRequestDispatcher("bill_listing.jsp").forward(request, response);
    }
}