public class Product {
    private static int idCounter = 0;
    private int productId;
    private String name;
    private int stockQuantity;
    private double salePrice;

    public Product(String name, int stockQuantity, double salePrice) {
        this.productId = ++idCounter;
        this.name = name;
        this.stockQuantity = stockQuantity;
        this.salePrice = salePrice;
    }

    // Getters and setters...

    public int getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public void updateStockQuantity(int quantity) {
        this.stockQuantity += quantity;
    }

    public double getSalePrice() {
        return salePrice;
    }
}
