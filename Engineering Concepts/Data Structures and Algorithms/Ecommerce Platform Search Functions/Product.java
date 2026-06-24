// Product class represents a product in the e-commerce platform
public class Product {

    // Attributes used for searching
    int productId;
    String productName;
    String category;

    // Constructor to initialize product details
    public Product(int productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }
}