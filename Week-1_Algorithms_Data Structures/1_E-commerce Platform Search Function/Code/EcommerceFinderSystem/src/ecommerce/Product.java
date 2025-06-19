package ecommerce;

public class Product {
    private String productId;
    private String productName;
    private String category;

    public Product(String id, String name, String category) {
        this.productId = id;
        this.productName = name;
        this.category = category;
    }

    public String getProductName() {
        return productName;
    }

    public String toString() {
        return "Product[ID=" + productId + ", Name=" + productName + ", Category=" + category + "]";
    }
}
