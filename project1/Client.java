import java.util.ArrayList;

public class Client {
    private static int idCounter = 0;
    private int clientId;
    private String name;
    private String address;
    private double balance;
    private ArrayList<Transaction> transactions;
    private ArrayList<WishlistItem> wishlist;
    private ArrayList<Order> orders;

    public Client(String name, String address) {
        this.clientId = ++idCounter;
        this.name = name;
        this.address = address;
        this.balance = 0;
        this.transactions = new ArrayList<>();
        this.wishlist = new ArrayList<>();
        this.orders = new ArrayList<>();
    }

    // Getters and setters...
    
    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

    public void addToWishlist(Product product, int quantity) {
        wishlist.add(new WishlistItem(product, quantity));
    }

    public ArrayList<WishlistItem> getWishlist() {
        return wishlist;
    }

    public void addOrder(Order order) {
        orders.add(order);
    }

    public int getClientId() {
        return clientId;
    }

    public String getName() {
        return name;
    }

    public void debitBalance(double amount) {
        balance -= amount;
    }

    public void creditBalance(double amount) {
        balance += amount;
    }

    public double getBalance() {
        return balance;
    }

    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }
}
