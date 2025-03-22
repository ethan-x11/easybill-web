package models;

public class User {
    private String consumerId;
    private String consumerName;
    private String email;
    private String countryCode;
    private String mobileNumber;
    private String userId;
    private String password;

    public User(String consumerId, String consumerName, String email, String countryCode, String mobileNumber, String userId, String password) {
        this.consumerId = consumerId;
        this.consumerName = consumerName;
        this.email = email;
        this.countryCode = countryCode;
        this.mobileNumber = mobileNumber;
        this.userId = userId;
        this.password = password;
    }

    // Getters and setters
    public String getConsumerId() { return consumerId; }
    public void setConsumerId(String consumerId) { this.consumerId = consumerId; }

    public String getConsumerName() { return consumerName; }
    public void setConsumerName(String consumerName) { this.consumerName = consumerName; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getCountryCode() { return countryCode; }
    public void setCountryCode(String countryCode) { this.countryCode = countryCode; }

    public String getMobileNumber() { return mobileNumber; }
    public void setMobileNumber(String mobileNumber) { this.mobileNumber = mobileNumber; }

    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
}