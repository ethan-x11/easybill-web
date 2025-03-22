package servlets;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.ServletContext;
import models.User;

@WebServlet("/RegistrationHandlerServlet")
public class RegistrationHandlerServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    public void init() throws ServletException {
        ServletContext context = getServletContext();
        if (context.getAttribute("users") == null) {
            context.setAttribute("users", new HashMap<String, User>());
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String consumerId = request.getParameter("consumerId");
        String consumerName = request.getParameter("consumerName");
        String email = request.getParameter("email");
        String countryCode = request.getParameter("countryCode");
        String mobileNumber = request.getParameter("mobileNumber");
        String userId = request.getParameter("userId");
        String password = request.getParameter("password");

        User user = new User(consumerId, consumerName, email, countryCode, mobileNumber, userId, password);

        ServletContext context = getServletContext();
        Map<String, User> users = (Map<String, User>) context.getAttribute("users");
        users.put(userId, user);

        request.setAttribute("consumerId", consumerId);
        request.setAttribute("userId", userId);
        request.setAttribute("consumerName", consumerName);
        request.setAttribute("username", userId);
        request.setAttribute("email", email);

        request.getRequestDispatcher("registration_success.jsp").forward(request, response);
    }
}