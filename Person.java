public class Person{
    private String firstName;
    private String lastName;
    private String id;

// constructor
public Person(String firstName,String lastName,String id){
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
    String myString = firstName +"\n"+lastName+ "\n" +id+"\n";
    return myString;
}
}
public class Main{
    public static void main(String[] args){
        Person p1= new Person("edwin","Maikara","35376");
       System.out.println(p1);
       
    }
}