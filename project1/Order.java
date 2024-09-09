import java.util.Map;
public class Order{
    private static int idCounter=0;
    private int orderId;
    private Client client;
    private HashMap<product,Interger>orderItems;
    private double totalCost;

    public Order(Client client){
        this.orderId=++idCounter;
        this.client=client;
        this.totalCost=0;
        this.orderItems=new HashMap<>();

    }
    public void addProduct(Product product,int quantity){
    orderItems.put(product,quantity);
    totalCost=+ product.getSalePrice()*quantity;
    }
    public double getTotalCost(){
        return totalCost;
    }
}
