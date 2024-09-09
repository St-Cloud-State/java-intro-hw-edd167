public class Client{
private static int idCounter=0;
private int clientId;
private String name;
private String address;
private double balance;
private ArrayList<Transactions>transactions;
private ArrayList<WishListItems>wishlist;
private ArrayList<Order>orders;

 public Client(String name,String address){
 this.clientId=++idCounter;
 this.name=name;
 this.address=address;
 this.balance=0;
 this.transactions=new ArrayList<>();
 this.wishlist=new ArrayList<>();
 }
 //getters and setter methods
 //method to add transactions 
 public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }
      //method to add product to wishlist
    public void addToWishlist(Product product, int quantity) {
        wishlist.add(new WishlistItem(product, quantity));
    }
    // method to get products in wishlist
    public ArrayList<WishlistItem> getWishlist() {
        return wishlist;
    }
  //method to add orders
    public void addOrder(Order order) {
        orders.add(order);
    }
// method returns clientId
    public int getClientId() {
        return clientId;
    }
//method to get name of client
    public String getName() {
        return name;
    }
//method to debit customer balance
    public void debitBalance(double amount) {
        balance -= amount;
    }
//method to credit customer balance 
    public void creditBalance(double amount) {
        balance += amount;
    }
//method to get customer balance
    public double getBalance() {
        return balance;
    }
//method to get all transactions in the system
    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }

}
