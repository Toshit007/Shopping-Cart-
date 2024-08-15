//NAME - Toshit Narwal
//STUDENT NO. - 20056512

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
    // Add getters
    public int getId() {
        return id;
    }
    public String getGender() {
        return gender;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getStreetAddress() {
        return streetAddress;
    }
    public String getCity() {
        return city;
    }
    public String getProvince() {
        return province;
    }
    public String getPostalCode() {
        return postalCode;
    }
    public String getEmailAddress() {
        return emailAddress;
    }
    public String getCcType() {
        return ccType;
    }
    public String getBloodType() {
        return bloodType;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public double getPounds() {
        return pounds;
    }
    public int getHeightInCM() {
        return heightInCM;
    }
    public List<Product> getPurchases() {
        return purchases;
    }

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
}