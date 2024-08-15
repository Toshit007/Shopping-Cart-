package ca.georgian.test2;

public class Product {
    private int id;
    private String sku;
    private String name;
    private double salePrice;
    private double regularPrice;
    private String image;  // URL for image

    @Override
    public String toString() {
        return name + "-$" + salePrice;
    }

}
