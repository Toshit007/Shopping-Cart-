package ca.georgian.test2;

import java.util.ArrayList;

public class MainApp {
    public static void main(String[] args) {
        String filePath = "src/main/resources/ca/georgian/test2/customers.json"; // Update this path if needed
        ArrayList<Customer> customers = JsonParser.parseCustomersJson(filePath);

        //Print all customers
        for (Customer customer : customers) {
            System.out.println(customer.getFirstName() + " " + customer.getLastName());
        }
    }
}
