import java.util.HashMap;

public class Order {
    private Client client;
    private HashMap<Product, Integer> orderItems;

    public Order(Client client) {
        this.client = client;
        this.orderItems = new HashMap<>();
    }

    // Method to add a product to the order
    public void addProduct(Product product, int quantity) {
        orderItems.put(product, orderItems.getOrDefault(product, 0) + quantity);
    }

    // Getter for client
    public Client getClient() {
        return client;
    }

    // Getter for order items
    public HashMap<Product, Integer> getOrderItems() {
        return orderItems;
    }

    // Additional method to get the total number of items in the order
    public int getTotalItems() {
        int totalItems = 0;
        for (int quantity : orderItems.values()) {
            totalItems += quantity;
        }
        return totalItems;
    }
}
