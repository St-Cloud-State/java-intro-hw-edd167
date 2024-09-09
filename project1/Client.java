Public class Client{
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
}
