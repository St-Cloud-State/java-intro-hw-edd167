public class WishlistItem{
    private Product product;
    private int quantity;

    public WishlistItem(Product product,int quantity){
        this.product=product;
        this.quantity=quantity;
    }
    public Product getProduct(){
         return product;
    }
    public int getQuantity(){
        return quantity;
    }
}