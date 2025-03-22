<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="models.User" %>
<%@ page import="models.Bill" %>
<%@ page import="jakarta.servlet.http.HttpSession" %>

<!DOCTYPE html>
<html>
<head>
    <title>Easybills</title>
    <link rel="stylesheet" type="text/css" href="css/styles.css">
</head>
<body>
    <%@ include file="fragments/navbarLoggedin.jsp"%>
    <div class="payment-container">
        <h2 class="payment-h2">Pay Your Bill</h2>

        <%
        User user = (User) session.getAttribute("user");
        Bill bill = (Bill) session.getAttribute("currentBill");
        Double totalDue = (Double) session.getAttribute("totalDue");

        if (user == null || bill == null || totalDue == null) {
            response.sendRedirect("bill_listing.jsp");
            return;
        }
        %>

        <form action="PaymentProcessingServlet" method="post" class="payment-form">
            <table class="payment-table">
                <tr>
                    <td>Name:</td>
                    <td><%= user.getConsumerName() %></td>
                </tr>
                <tr>
                    <td>Consumer No:</td>
                    <td><%= user.getConsumerId() %></td>
                </tr>
                <tr>
                    <td>Bill ID:</td>
                    <td><%= bill.getBillId() %></td>
                </tr>
                <tr>
                    <td>Bill Units:</td>
                    <td><%= bill.getBillUnit() %> kWh</td>
                </tr>
                <tr>
                    <td>Bill Month:</td>
                    <td><%= bill.getBillMonth() %></td>
                </tr>
                <tr>
                    <td>Bill Date:</td>
                    <td><%= bill.getBillDate() %></td>
                </tr>
                <tr>
                    <td>Due Date:</td>
                    <td><%= bill.getDueDate() %></td>
                </tr>
                <tr>
                    <td>Total Due Amount:</td>
                    <td>$<%= totalDue %></td>
                </tr>
                <tr>
                    <td>Payment Method:</td>
                    <td>
                        <select name="paymentMethod" class="payment-select">
                            <option value="debit">Debit Card</option>
                            <option value="credit">Credit Card</option>
                        </select>
                    </td>
                </tr>
            </table>

            <input type="hidden" name="consumerNo" value="<%= user.getConsumerId() %>" class="payment-input">
            <input type="hidden" name="billId" value="<%= bill.getBillId() %>" class="payment-input">
            <input type="hidden" name="totalAmount" value="<%= totalDue %>" class="payment-input">
            <input type="submit" value="Pay Now" class="payment-input">
            <a href="BillListServlet" class="payment-a">Cancel</a>
        </form>

        <%-- Footer --%>
        <%@ include file="fragments/footer.jsp"%>
    </div>
</body>
</html>