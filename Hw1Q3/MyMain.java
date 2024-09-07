import java.io.*;
import java.util.Scanner;

public class MyMain {
    public static void main(String[] args) throws IOException {
        // Create a PersonList object
        PersonList personList = new PersonList();
        
        // Create an input file with data for person objects
        String inputFile = "persons.txt";
        try (InputStream input = new FileInputStream(inputFile)) {
            personList.store(input); // Use the store method of PersonList
        }

        // Display the person objects in the PersonList
        System.out.println("Person list:");
        try (OutputStream output = System.out) {
            personList.display(output); // Use the display method of PersonList
        }

        // Test the find method
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter an ID to find:");
        String sid = scanner.nextLine();
        int index = personList.find(sid); // Use the find method of PersonList
        if (index != -1) {
            System.out.println("Person found at index " + index + ": " + personList.getList().get(index));
        } else {
            System.out.println("Person with ID " + sid + " not found.");
        }
        
        scanner.close();
    }
}
