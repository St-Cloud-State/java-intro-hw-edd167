public class Client {
    private int clientID;
    private String name;
    private String email;
    private String shippingAddress;
    private Wishlist wishlist;
    private Waitlist waitlist;
    private List<Order> orderHistory;

    // Constructor
    public Client(int clientID, String name, String email, String shippingAddress, String phoneNumber) {
        this.clientID = clientID;
        this.name = name;
        this.email = email;
        this.shippingAddress = shippingAddress;
        this.phoneNumber = phoneNumber;
        this.wishlist = new Wishlist(this);
        this.waitlist = new Waitlist(this);
        this.orderHistory = new ArrayList<>();
    }

    // Getters and Setters
    public int getClientID() {
        return clientID;
    }

    public void setClientID(int clientID) {
        this.clientID = clientID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Wishlist getWishlist() {
        return wishlist;
    }

    public void setWishlist(Wishlist wishlist) {
        this.wishlist = wishlist;
    }

    public Waitlist getWaitlist() {
        return waitlist;
    }

    public void setWaitlist(Waitlist waitlist) {
        this.waitlist = waitlist;
    }

    public List<Order> getOrderHistory() {
        return orderHistory;
    }

    public void setOrderHistory(List<Order> orderHistory) {
        this.orderHistory = orderHistory;
    }
}
