// Author: Arash Heidarzadeh Naeini

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class GroceryQueueSimulator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Queue<String> queue = new LinkedList<>();
        
        // Clearing the screen
        System.out.print("\u000c");


        while (true) {
            // Displaying the menu
            System.out.println("\nChoose an option:");
            System.out.println("1. Insert (Enqueue)");
            System.out.println("2. Remove (Dequeue)");
            System.out.println("3. Peek (Front Element)");
            System.out.println("4. Check Empty");
            System.out.println("5. Check Full");
            System.out.println("6. Size");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt(); // Read the user's choice
            scanner.nextLine(); // Consume the newline

            switch (choice) {
                case 1: // Insert
                    System.out.print("Enter customer name to enqueue: ");
                    // Read the customer's name 
                    String name = scanner.nextLine();
                    // Add the customer's name to the queue
                    queue.add(name);
                    System.out.println("Customer added: " + name);
                    break;
                case 2: // Remove
                    if (!queue.isEmpty()) {
                        System.out.println("Customer removed: " + queue.remove());
                    } else {
                        System.out.println("Queue is empty, no customer to remove.");
                    }
                    break;
                case 3: // Peek
                    if (!queue.isEmpty()) {
                        System.out.println("First customer in line: " + queue.peek());
                    } else {
                        System.out.println("Queue is empty, no customers to display.");
                    }
                    break;
                case 4: // Check Empty
                    System.out.println("Queue is empty: " + queue.isEmpty());
                    break;
                case 5: // Check Full
                    // Since LinkedList has no capacity limit, it's never "full"
                    System.out.println("Queue is full: false");
                    break;
                case 6: // Size
                    System.out.println("Number of customers in queue: " + queue.size());
                    break;
                default: // Having a default case in case the user enters an invalid number.
                    System.out.println("Invalid choice. Please enter a number between 1 and 6.");
                    continue;
            }

            // Check if the user wants to continue
            System.out.print("Do you want to continue? (Yes/No): ");
            String answer = scanner.nextLine();
            if (answer.equalsIgnoreCase("No")) {
                break;
            }
        }

        // Terminating the program
        scanner.close();
        System.out.println("Program terminated.");
    }
}
