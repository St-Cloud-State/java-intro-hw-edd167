import java.util.ArrayList;
import java.util.HashMap;

public class WarehouseSystem {
    private ArrayList<Client> clients;
    private ArrayList<Product> products;
    private ArrayList<Order> orders;
    private ArrayList<Invoice> invoices;
    private HashMap<Product, Integer> waitlist;  // To track waitlisted products

    public WarehouseSystem() {
        clients = new ArrayList<>();
        products = new ArrayList<>();
        orders = new ArrayList<>();
        invoices = new ArrayList<>();
        waitlist = new HashMap<>();
    }

    // 1. Add a new client
    public void addClient(String name, String address) {
        clients.add(new Client(name, address));
    }

    // 2. Add multiple products
    public void addProducts(ArrayList<Product> newProducts) {
        products.addAll(newProducts);
    }

    // 3. Process a client's order (checkout process)
    public void processOrder(Client client) {
        Order order = new Order(client);
        ArrayList<WishlistItem> wishlist = client.getWishlist();

        for (WishlistItem item : wishlist) {
            Product product = item.getProduct();
            int quantityRequested = item.getQuantity();
            
            // Check stock availability
            if (product.getStockQuantity() >= quantityRequested) {
                // Add to the order and update stock
                order.addProduct(product, quantityRequested);
                product.adjustStock(-quantityRequested);
            } else {
                // Not enough stock, add to waitlist
                waitlist.put(product, waitlist.getOrDefault(product, 0) + quantityRequested);
            }
        }

        // Create invoice for shipped items
        Invoice invoice = createInvoice(order);
        invoices.add(invoice);

        // Clear the processed items from wishlist
        client.getWishlist().clear();

        // Debit client's account for the amount due
        client.debitBalance(invoice.getTotalCost());
        
        // Add order to client's orders
        client.addOrder(order);
        
        System.out.println("Order processed and invoice generated for Client: " + client.getName());
    }

    // 4. Generate an invoice for a client's order
    public Invoice createInvoice(Order order) {
        Invoice invoice = new Invoice(order.getClient());
        HashMap<Product, Integer> orderItems = order.getOrderItems();

        for (Product product : orderItems.keySet()) {
            int quantity = orderItems.get(product);
            invoice.addProduct(product, quantity);
        }

        return invoice;
    }

    // 5. Accept payment from a client
    public void acceptPayment(Client client, double amount) {
        client.creditBalance(amount);
        System.out.println("Payment of $" + amount + " accepted from Client: " + client.getName());
    }

    // 6. Accept a shipment and update stock / fulfill waitlist
    public void acceptShipment(int productId, int quantity) {
        Product product = findProductById(productId);
        if (product != null) {
            // Check waitlist first
            if (waitlist.containsKey(product)) {
                int waitlistedQty = waitlist.get(product);
                if (quantity >= waitlistedQty) {
                    System.out.println("Fulfilling waitlisted orders for product: " + product.getName());
                    quantity -= waitlistedQty;
                    waitlist.remove(product);  // All waitlisted items fulfilled
                } else {
                    waitlist.put(product, waitlistedQty - quantity);  // Partial fulfillment
                    quantity = 0;
                }
            }
            product.adjustStock(quantity);  // Update stock with remaining quantity
            System.out.println("Shipment accepted for product: " + product.getName() + ", updated stock: " + product.getStockQuantity());
        } else {
            System.out.println("Product not found!");
        }
    }

    // 7. Queries: List all transactions for a specified client
    public void listTransactionsForClient(int clientId) {
        Client client = findClientById(clientId);
        if (client != null) {
            System.out.println("Transactions for Client: " + client.getName());
            for (Transaction transaction : client.getTransactions()) {
                System.out.println("Date: " + transaction.getDate() + ", Description: " + transaction.getDescription() + ", Amount: $" + transaction.getAmount());
            }
        } else {
            System.out.println("Client not found!");
        }
    }

    // 8. Queries: List all clients with outstanding balances
    public void listClientsWithOutstandingBalance() {
        System.out.println("Clients with outstanding balances:");
        for (Client client : clients) {
            if (client.getBalance() < 0) {
                System.out.println("Client: " + client.getName() + ", Outstanding Balance: $" + Math.abs(client.getBalance()));
            }
        }
    }

    // 9. Queries: List all products, quantity in stock, and total quantity of outstanding (waitlisted) orders
    public void listAllProducts() {
        System.out.println("Product Inventory:");
        for (Product product : products) {
            int waitlistedQty = waitlist.getOrDefault(product, 0);
            System.out.println("Product: " + product.getName() + ", Stock Quantity: " + product.getStockQuantity() + ", Waitlisted Quantity: " + waitlistedQty);
        }
    }

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
