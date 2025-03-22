<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="models.Bill" %>
<!DOCTYPE html>
<html>
<head>
    <title>Bill Listing</title>
    <link rel="stylesheet" type="text/css" href="css/styles.css">
</head>
<body>
    <%@ include file="fragments/navbarLoggedin.jsp"%>
    <div class="bill-listing-container">
        <div class="current-bill-card">
            <h2>Current Bill Details</h2>
            <%
                List<Bill> bills = (List<Bill>) request.getAttribute("bills");
                double totalDue = 0.0;
                if (bills != null && !bills.isEmpty()) {
                    for (Bill bill : bills) {
                        if ("Unpaid".equalsIgnoreCase(bill.getPaymentStatus())) {
                            totalDue += Double.parseDouble(bill.getBillAmount());
                        }
                    }
                    Bill currentBill = bills.get(0); // Assuming the first bill is the current bill
                    session.setAttribute("currentBill", currentBill);
                    session.setAttribute("totalDue", totalDue);
            %>
            <p><strong>Bill ID:</strong> <%= currentBill.getBillId() %></p>
            <p><strong>Current Unit Used:</strong> <%= currentBill.getBillUnit() %></p>
            <p><strong>Current Bill Due:</strong> <%= currentBill.getBillAmount() %></p>
            <p><strong>Bill Date:</strong> <%= currentBill.getBillDate() %></p>
            <p><strong>Total Bill Due:</strong> <%= totalDue %></p>
            <p><strong>Due Date:</strong> <%= currentBill.getDueDate() %></p>
            <form action="payment.jsp" method="get">
                <input type="hidden" name="billId" value="<%= currentBill.getBillId() %>">
                <input type="hidden" name="totalAmount" value="<%= currentBill.getBillAmount() %>">
                <input type="submit" value="Pay Now" class="btn">
            </form>
            <%
                } else {
            %>
            <p>No Bill Found</p>
            <%
                }
            %>
        </div>

        <h2>Previous Bills</h2>
        <table class="bill-table">
            <thead>
                <tr>
                    <th>Bill Unit</th>
                    <th>Month</th>
                    <th>Bill ID</th>
                    <th>Bill Date</th>
                    <th>Due Date</th>
                    <th>Bill Amount</th>
                    <th>Payment Status</th>
                </tr>
            </thead>
            <tbody>
                <%
                    if (bills != null && bills.size() > 1) {
                        for (int i = 1; i < bills.size(); i++) {
                            Bill bill = bills.get(i);
                %>
                <tr>
                    <td><%= bill.getBillUnit() %></td>
                    <td><%= bill.getBillMonth() %></td>
                    <td><%= bill.getBillId() %></td>
                    <td><%= bill.getBillDate() %></td>
                    <td><%= bill.getDueDate() %></td>
                    <td><%= bill.getBillAmount() %></td>
                    <td><%= bill.getPaymentStatus() %></td>
                </tr>
                <%
                        }
                    }
                %>
            </tbody>
        </table>
    </div>
    <%@ include file="fragments/footer.jsp"%>
</body>
</html>