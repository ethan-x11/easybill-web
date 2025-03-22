package servlets;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpSession;
import models.User;
import models.Bill;

@WebServlet("/PaymentProcessingServlet")
public class PaymentProcessingServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    HttpSession session = request.getSession();
    User user = (User) session.getAttribute("user");
    Bill bill = (Bill) session.getAttribute("currentBill");
    Double totalDue = (Double) session.getAttribute("totalDue");

    if (user == null || bill == null || totalDue == null) {
      response.sendRedirect("login.jsp");
      return;
    }

    String paymentMethod = request.getParameter("paymentMethod");

    boolean paymentSuccess = Math.random() > 0.2;

    request.setAttribute("consumerId", user.getConsumerId());
    request.setAttribute("billId", bill.getBillId());
    request.setAttribute("paymentMethod", paymentMethod.toUpperCase());
    request.setAttribute("totalAmount", totalDue);
    request.setAttribute("paymentSuccess", paymentSuccess);

    RequestDispatcher dispatcher = request.getRequestDispatcher("card_details.jsp");
    dispatcher.forward(request, response);
  }
}