import java.io.*;
import java.util.LinkedList;
import java.util.Scanner;

public class MyMain {
    // Store method that reads data from input stream and stores it in the LinkedList
    public static void store(InputStream input, LinkedList<Person> list) throws IOException {
        Scanner scanner = new Scanner(input);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] data = line.split(","); // Assuming comma-separated values in the file (id,name,age)
            if (data.length == 3) {
                String id = data[0].trim();
                String firstName = data[1].trim();
                String lastName = data[2].trim();
                Person person = new Person(id, firstName, lastName);
                list.add(person);
            }
        }
        scanner.close();
    }

    // Display method that writes all people details from LinkedList to the output stream
    public static void display(OutputStream output, LinkedList<Person> list) throws IOException {
        PrintWriter writer = new PrintWriter(output);
        for (Person person : list) {
            writer.println(person);
        }
        writer.flush();
    }

    // Find method that searches for a person by ID and returns the index or -1 if not found
    public static int find(String sid, LinkedList<Person> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId().equals(sid)) {
                return i;
            }
        }
        return -1; // Person not found
    }

    // Main method
    public static void main(String[] args) throws IOException {
        LinkedList<Person> personList = new LinkedList<>();
        
        // Create an input file with data for person objects
        String inputFile = "people.txt";
        try (InputStream input = new FileInputStream(inputFile)) {
            store(input, personList);
        }

        // Display the person objects in the linked list
        System.out.println("Person list:");
        try (OutputStream output = System.out) {
            display(output, personList);
        }

        // Test the find method
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter an ID to find:");
        String sid = scanner.nextLine();
        int index = find(sid, personList);
        if (index != -1) {
            System.out.println("Person found at index " + index + ": " + personList.get(index));
        } else {
            System.out.println("Person with ID " + sid + " not found.");
        }
        
        scanner.close();
    }
}