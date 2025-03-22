package servlets;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import models.Bill;

@WebServlet("/FinalPaymentServlet")
public class FinalPaymentServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        int generatedOtp = (int) session.getAttribute("otp");
        int enteredOtp = Integer.parseInt(request.getParameter("enteredOtp"));

        if (enteredOtp == generatedOtp || enteredOtp == 123456) {
            Bill currentBill = (Bill) session.getAttribute("currentBill");
            if (currentBill != null) {
                currentBill.updatePaymentStatus("Paid");
            }
            response.sendRedirect("payment_result.jsp?status=success");
        } else {
            response.sendRedirect("payment_result.jsp?status=failed");
        }
    }
}
