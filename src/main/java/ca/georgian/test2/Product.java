//NAME - Toshit Narwal
//STUDENT NO. - 20056512

package ca.georgian.test2;

public class Product {
    private int id;
    private String sku;
    private String name;
    private double salePrice;
    private double regularPrice;
    private String image;  // URL for the image

    // Constructor
    public Product(int id, String sku, String name, double salePrice, double regularPrice, String image) {
        this.id = id;
        this.sku = sku;
        this.name = name;
        this.salePrice = salePrice;
        this.regularPrice = regularPrice;
        this.image = image;
    }

    @Override
    public String toString() {
        return name + "-$" + salePrice;
    }

    // Getters and Setters (if needed)
    // Add other necessary methods here
    // Getters
    public int getId() {
        return id;
    }

    public String getSku() {
        return sku;
    }

    public String getName() {
        return name;
    }

    public double getSalePrice() {
        return salePrice;
    }

    public double getRegularPrice() {
        return regularPrice;
    }

    public String getImage() {
        return image;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSalePrice(double salePrice) {
        this.salePrice = salePrice;
    }

    public void setRegularPrice(double regularPrice) {
        this.regularPrice = regularPrice;
    }

    public void setImage(String image) {
        this.image = image;
    }
}