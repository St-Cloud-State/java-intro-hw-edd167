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
