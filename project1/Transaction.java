import java.util.Date;
public class Transaction{
    private Date date;
    private String description;
    private double amount;

    //constructor
    public Transaction(String description,double amount){
        this.date= new Date();
        this.description=description;
        this.amount=amount;
    }
    public Date getDate(){
        return date;
    }
    public String getDescription(){
        return description;
    }
    public double getAmount(){
        return amount;
    }
}