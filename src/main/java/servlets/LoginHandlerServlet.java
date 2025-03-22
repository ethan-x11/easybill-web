package servlets;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.ServletContext;
import models.User;

@WebServlet("/LoginHandlerServlet")
public class LoginHandlerServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final String ADMIN_USER = "admin";
    private static final String ADMIN_PASS = "admin";

    @Override
    public void init() throws ServletException {
        // Initialize the users map in the ServletContext if not already present
        ServletContext context = getServletContext();
        if (context.getAttribute("users") == null) {
            Map<String, User> users = new HashMap<>();
            // Add default demo user
            users.put("demo", new User("DEMO123", "Demo User", "demo@example.com", "1", "1234567890", "demo", "demo"));
            context.setAttribute("users", users);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userId = request.getParameter("userId");
        String password = request.getParameter("password");
        String adminId = request.getParameter("adminId");

        HttpSession session = request.getSession();
        ServletContext context = getServletContext();
        Map<String, User> users = (Map<String, User>) context.getAttribute("users");

        if (adminId != null) {
            if (ADMIN_USER.equals(adminId) && ADMIN_PASS.equals(password)) {
                session.setAttribute("username", ADMIN_USER);
                response.sendRedirect("admin.jsp");
            } else {
                session.setAttribute("errorMessage", "Invalid Id or password");
                session.setAttribute("isAdmin", true);
                response.sendRedirect("login.jsp?error=invalid");
            }
        } else {
            User user = users.get(userId);
            if (user != null && user.getPassword().equals(password)) {
                session.setAttribute("username", user.getUserId());
                session.setAttribute("consumerId", user.getConsumerId());
                session.setAttribute("user", user); // Set the User object as a session attribute
                response.sendRedirect("BillListServlet"); // Redirect to BillListServlet after successful login
            } else {
                session.setAttribute("errorMessage", "Invalid Id or password");
                session.setAttribute("isAdmin", false);
                response.sendRedirect("login.jsp?error=invalid");
            }
        }
    }
}