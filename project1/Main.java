import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        WarehouseSystem warehouse = new WarehouseSystem();
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        // Sample data (clients and products)
        warehouse.addClient("bob jame", "123 Main St");
        warehouse.addClient("Jane willaim", "456 Elm St");

        ArrayList<Product> newProducts = new ArrayList<>();
        newProducts.add(new Product("Laptop", 10, 1000.00));
        newProducts.add(new Product("Phone", 20, 500.00));
        newProducts.add(new Product("Headphones", 30, 100.00));
        warehouse.addProducts(newProducts);

        while (!exit) {
            System.out.println("\n---- Warehouse System ----");
            System.out.println("1. Add new client");
            System.out.println("2. List all products");
            System.out.println("3. Add products to a client's wishlist");
            System.out.println("4. Process a client's order");
            System.out.println("5. Accept payment");
            System.out.println("6. Accept shipment");
            System.out.println("7. List all clients with outstanding balances");
            System.out.println("8. List all transactions for a client");
            System.out.println("9. Exit");
            System.out.print("Select an option: ");
            int option = scanner.nextInt();
            scanner.nextLine();  // Clear newline

            switch (option) {
                case 1:
                    System.out.print("Enter client name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter client address: ");
                    String address = scanner.nextLine();
                    warehouse.addClient(name, address);
                    System.out.println("Client added successfully.");
                    break;

                case 2:
                    warehouse.listAllProducts();
                    break;

                case 3:
                    System.out.print("Enter client ID: ");
                    int clientId = scanner.nextInt();
                    Client client = warehouse.findClientById(clientId);
                    if (client != null) {
                        warehouse.listAllProducts();
                        System.out.print("Enter product ID to add to wishlist: ");
                        int productId = scanner.nextInt();
                        System.out.print("Enter quantity: ");
                        int quantity = scanner.nextInt();
                        Product product = warehouse.findProductById(productId);
                        if (product != null) {
                            client.addToWishlist(product, quantity);
                            System.out.println("Product added to wishlist.");
                        } else {
                            System.out.println("Product not found.");
                        }
                    } else {
                        System.out.println("Client not found.");
                    }
                    break;

                case 4:
                    System.out.print("Enter client ID: ");
                    clientId = scanner.nextInt();
                    client = warehouse.findClientById(clientId);
                    if (client != null) {
                        warehouse.processOrder(client);
                    } else {
                        System.out.println("Client not found.");
                    }
                    break;

                case 5:
                    System.out.print("Enter client ID: ");
                    clientId = scanner.nextInt();
                    client = warehouse.findClientById(clientId);
                    if (client != null) {
                        System.out.print("Enter payment amount: ");
                        double paymentAmount = scanner.nextDouble();
                        warehouse.acceptPayment(client, paymentAmount);
                    } else {
                        System.out.println("Client not found.");
                    }
                    break;

                case 6:
                    //System.out.print("Enter product ID: ");
                    //productId = scanner.nextInt();
                    System.out.print("Enter shipment quantity: ");
                    quantity = scanner.nextInt();
                    warehouse.acceptShipment(productId, quantity);
                    break;

                case 7:
                    warehouse.listClientsWithOutstandingBalance();
                    break;

                case 8:
                    System.out.print("Enter client ID: ");
                    clientId = scanner.nextInt();
                    warehouse.listTransactionsForClient(clientId);
                    break;

                case 9:
                    exit = true;
                    System.out.println("Exiting system.");
                    break;

                default:
                    System.out.println("Invalid option.");
                    break;
            }
        }

        scanner.close();
    }
}
