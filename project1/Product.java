//class to track the products in the warehouse
import java.util.ArrayList;
public class Product{
    private int productId;
    private String name;
    private int stockQuantity;
    private double salePrice;
//construct for class product
    public Product(String name,int stockQuantity,double salePrice){
        this.name=name;
        this.stockQuantity=stockQuantity;
        this.salePrice=salePrice;
    }
    //getter and setter methods
    public int getProductId(){
        return productId;
    }
    public void setProductId(int productId) {
        this.productId = productId;
    public String getName(){
        return name;
    }
    public int getStockQuantity(){
        return stockQuantity;
    }
    public double getSalePrice(){
        return salePrice;
    }
    public int updateStockQuantity(int quantity){
          return this.stockQuantity=+ quantity;
    }
}