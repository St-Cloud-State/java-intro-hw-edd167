import java.util.HashMap;
public class Invoice {
    private static int idCounter = 0;
    private int invoiceId;
    private Client client;
    private HashMap<Product, Integer> products;
    private double totalCost;

    public Invoice(Client client) {
        this.invoiceId = ++idCounter;
        this.client = client;
        this.products = new HashMap<>();
        this.totalCost = 0;
    }

    public void addProduct(Product product, int quantity) {
        products.put(product, quantity);
        totalCost += product.getSalePrice() * quantity;
    }

    public double getTotalCost() {
        return totalCost;
    }

    // Getters...
}
