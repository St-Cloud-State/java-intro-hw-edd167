public class Pesron{
    Private String firstName;
    Private String lastName;
    Private String id;

// constructor
public Pesron(String firstName,String lastName,String id){
    this.firstName=firstName;
    this.lastName=lastName;
    this.id=id;
}
// accessor methods
     String getFirstname(){
        return firstName;
     }
     String getLastname(){
     return lastName;
     }
     String getId(){
        return id;
     }
// toString method 
public String toString(){
    String myString = firstName +"\n"+lastName+ "\n" +id"\n"
    return myString;
}
}
public class Main{
    public static void main(String[],args){
        Pesron p1= new Pesron();
       System.out.println(p1.getFirstname("edwin"));
       System.out.println(p1.getLastname("Maikara"));
       System.out.println(p1.getid("56"));
    }
}