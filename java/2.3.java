// Experiment 2.3 Java

import java.util.ArrayList;
import java.util.Scanner;

public class StringListOperations {
    private static ArrayList<String> stringList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nString List Operations:");
            System.out.println("1. Insert");
            System.out.println("2. Delete");
            System.out.println("3. Display");
            System.out.println("4. Search");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    insertItem(scanner);
                    break;
                case 2:
                    deleteItem(scanner);
                    break;
                case 3:
                    displayItems();
                    break;
                case 4:
                    searchItem(scanner);
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 5.");
            }
        } while (choice != 5);

        scanner.close();
    }

    private static void insertItem(Scanner scanner) {
        System.out.print("Enter the string to insert: ");
        String newItem = scanner.next();
        stringList.add(newItem);
        System.out.println("Item inserted successfully.");
    }

    private static void deleteItem(Scanner scanner) {
        if (stringList.isEmpty()) {
            System.out.println("List is empty. Nothing to delete.");
            return;
        }

        System.out.print("Enter the string to delete: ");
        String itemToDelete = scanner.next();
        if (stringList.remove(itemToDelete)) {
            System.out.println("Item deleted successfully.");
        } else {
            System.out.println("Item not found in the list.");
        }
    }

    private static void displayItems() {
        if (stringList.isEmpty()) {
            System.out.println("List is empty.");
            return;
        }

        System.out.println("Items in the list:");
        for (String item : stringList) {
            System.out.println(item);
        }
    }

    private static void searchItem(Scanner scanner) {
        if (stringList.isEmpty()) {
            System.out.println("List is empty.");
            return;
        }

        System.out.print("Enter the string to search: ");
        String itemToSearch = scanner.next();
        if (stringList.contains(itemToSearch)) {
            System.out.println("Item found in the list.");
        } else {
            System.out.println("Item not found in the list.");
        }
    }
}
