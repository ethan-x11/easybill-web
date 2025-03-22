package models;

public class Bill {
    private String billId;
    private String billUnit;
    private String billMonth;
    private String billDate;
    private String dueDate;
    private String billAmount;
    private String paymentStatus;

    public Bill(String billId, String billUnit, String billMonth, String billDate, String dueDate, String billAmount, String paymentStatus) {
        this.billId = billId;
        this.billUnit = billUnit;
        this.billMonth = billMonth;
        this.billDate = billDate;
        this.dueDate = dueDate;
        this.billAmount = billAmount;
        this.paymentStatus = paymentStatus;
    }

    // Getters and setters
    public String getBillId() { return billId; }
    public void setBillId(String billId) { this.billId = billId; }

    public String getBillUnit() { return billUnit; }
    public void setBillUnit(String billUnit) { this.billUnit = billUnit; }

    public String getBillMonth() { return billMonth; }
    public void setBillMonth(String billMonth) { this.billMonth = billMonth; }

    public String getBillDate() { return billDate; }
    public void setBillDate(String billDate) { this.billDate = billDate; }

    public String getDueDate() { return dueDate; }
    public void setDueDate(String dueDate) { this.dueDate = dueDate; }

    public String getBillAmount() { return billAmount; }
    public void setBillAmount(String billAmount) { this.billAmount = billAmount; }

    public String getPaymentStatus() { return paymentStatus; }
    public void setPaymentStatus(String paymentStatus) { this.paymentStatus = paymentStatus; }

    public void updatePaymentStatus(String newStatus) {
        this.paymentStatus = newStatus;
    }
}