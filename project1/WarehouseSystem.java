import java.util.ArrayList;
import java.util.HashMap;

public class WarehouseSystem {
    private ArrayList<Client> clients;
    private ArrayList<Product> products;
    private ArrayList<Order> orders;
    private ArrayList<Invoice> invoices;
    private HashMap<Product, Integer> waitlist;  // To track waitlisted products

    private int nextClientId = 1;  // Start clientId generation from 1
    private int nextProductId = 1; // Start productId generation from 1

    public WarehouseSystem() {
        clients = new ArrayList<>();
        products = new ArrayList<>();
        orders = new ArrayList<>();
        invoices = new ArrayList<>();
        waitlist = new HashMap<>();
    }

    // 1. Add a new client
    public void addClient(String name, String address) {
        Client client = new Client(nextClientId++, name, address);  // Auto-increment clientId
        clients.add(client);
        System.out.println("Client added: ID=" + client.getClientId() + ", Name=" + name);
    }

    // 2. Add multiple products
    public void addProducts(ArrayList<Product> newProducts) {
        for (Product product : newProducts) {
            product.setProductId(nextProductId++);  // Assign unique productId
            products.add(product);
            System.out.println("Product added: ID=" + product.getProductId() + ", Name=" + product.getName());
        }
    }

    // Other methods remain the same (processOrder, acceptPayment, etc.)

    // Helper: Find client by ID
    public Client findClientById(int clientId) {
        for (Client client : clients) {
            if (client.getClientId() == clientId) {
                return client;
            }
        }
        return null;
    }

    // Helper: Find product by ID
    public Product findProductById(int productId) {
        for (Product product : products) {
            if (product.getProductId() == productId) {
                return product;
            }
        }
        return null;
    }

    
}
