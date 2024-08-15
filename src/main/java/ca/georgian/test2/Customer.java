package ca.georgian.test2;

import java.util.List;

public class Customer {
    private int id;
    private String gender;
    private String firstName;
    private String lastName;
    private String streetAddress;
    private String city;
    private String province;
    private String postalCode;
    private String emailAddress;
    private String ccType;
    private String bloodType;
    private String phoneNumber;
    private double pounds;
    private int heightInCM;
    private List<Product> purchases;

    // Getters
    public int getId() { return id; }
    public String getGender() { return gender; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getStreetAddress() { return streetAddress; }
    public String getCity() { return city; }
    public String getProvince() { return province; }
    public String getPostalCode() { return postalCode; }
    public String getEmailAddress() { return emailAddress; }
    public String getCcType() { return ccType; }
    public String getBloodType() { return bloodType; }
    public String getPhoneNumber() { return phoneNumber; }
    public double getPounds() { return pounds; }
    public int getHeightInCM() { return heightInCM; }
    public List<Product> getPurchases() { return purchases; }

    // Setters
    public void setId(int id) { this.id = id; }
    public void setGender(String gender) { this.gender = gender; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public void setStreetAddress(String streetAddress) { this.streetAddress = streetAddress; }
    public void setCity(String city) { this.city = city; }
    public void setProvince(String province) { this.province = province; }
    public void setPostalCode(String postalCode) { this.postalCode = postalCode; }
    public void setEmailAddress(String emailAddress) { this.emailAddress = emailAddress; }
    public void setCcType(String ccType) { this.ccType = ccType; }
    public void setBloodType(String bloodType) { this.bloodType = bloodType; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
    public void setPounds(double pounds) { this.pounds = pounds; }
    public void setHeightInCM(int heightInCM) { this.heightInCM = heightInCM; }
    public void setPurchases(List<Product> purchases) { this.purchases = purchases; }

    public double getTotalPurchases() {
        return purchases.stream()
                .mapToDouble(Product::getSalePrice)
                .sum();
    }

    public double getTotalSavings() {
        return purchases.stream()
                .mapToDouble(p -> p.getRegularPrice() - p.getSalePrice())
                .sum();
    }

    public boolean hasSavedFiveOrMore() {
        return purchases.stream()
                .allMatch(p -> p.getRegularPrice() - p.getSalePrice() >= 5);
    }

    public String getTotalPurchasesFormatted() {
        return String.format("$%.2f", getTotalPurchases());
    }
}
