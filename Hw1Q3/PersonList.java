import java.io.*;
import java.util.LinkedList;
import java.util.Scanner;

public class PersonList {
    private LinkedList<Person> list;

    // Constructor to initialize the LinkedList
    public PersonList() {
        list = new LinkedList<>();
    }

    // Store method to read data from input stream and stores it in the LinkedList
    public void store(InputStream input) throws IOException {
        Scanner scanner = new Scanner(input);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] data = line.split(","); // Assuming comma-separated values in the file (id,firstName,lastName)
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

    // Display method that writes all persons from LinkedList to the output stream
    public void display(OutputStream output) throws IOException {
        PrintWriter writer = new PrintWriter(output);
        for (Person person : list) {
            writer.println(person);
        }
        writer.flush();
    }

    // Find method that searches for a person by ID and returns the index or -1 if not found
    public int find(String sid) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId().equals(sid)) {
                return i;
            }
        }
        return -1; // Person not found
    }

    // Getter for the list (for potential future use)
    public LinkedList<Person> getList() {
        return list;
    }
}