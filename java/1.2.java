// Experiment 1.2 Java



import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args) {

        System.out.println("PRIYANSHU GHOSH");
        System.out.println("21bcs8733");
        VideoStore obj = new VideoStore();
        int choice;
        String video;
        int rating;
        boolean status = true;



        while (status) {
            System.out.println("\n\nMAIN MENU\n");
            System.out.println("1. Add Videos");
            System.out.println("2. Delete Videos");
            System.out.println("3. Display Videos");
            System.out.println("4. Give Rating");
            System.out.println("5. List Inventory");
            System.out.println("6. Exit\n");
            System.out.println("Enter your choice:");

            Scanner sc = new Scanner(System.in);
            choice = 0;

            try {
                choice = sc.nextInt();
            } catch (InputMismatchException e) {
                // Consume the invalid input
                sc.nextLine();
                System.out.println("Invalid input. Please enter a valid choice.");
                continue;
            }

            switch (choice) {
                case 1: {
                    System.out.println("Enter Name of Video:");
                    video = sc.next();
                    obj.addVideo(video);
                    break;
                }
                case 2: {
                    System.out.println("Enter Video name you want to delete:");
                    video = sc.next();
                    obj.doCheckOut(video);
                    break;
                }
                case 3: {
                    System.out.println("Enter Video you want to display:");
                    video = sc.next();
                    obj.doReturn(video);
                    break;
                }
                case 4: {
                    System.out.println("Enter video name to give rating:");
                    video = sc.next();
                    System.out.println("Give Ratings:");
                    try {
                        rating = sc.nextInt();
                        obj.receiveRating(video, rating);
                    } catch (InputMismatchException ex) {
                        // Consume the invalid input
                        sc.nextLine();
                        System.out.println("Invalid rating input. Please enter a valid integer.");
                    }
                    break;
                }
                case 5: {
                    obj.listInventory();
                    break;
                }
                case 6: {
                    obj.exit();
                    break;
                }
                default: {
                    System.out.println("Wrong input!! Try again.");
                    // Consume the newline character
                    sc.nextLine();
                }
            }
        }
    }
}

// ... (rest of the code remains unchanged)

class Video {
    String video;
    boolean checkOut;
    int rating;

    String getName() {
        return video;
    }

    void doCheckOut() {
        checkOut = true;
    }

    void doReturn() {
        checkOut = false;
    }

    void receiveRating(int rating) {
        this.rating = rating;
    }

    int getRating() {
        return rating;
    }

    boolean getCheckOut() {
        return checkOut;
    }

    public Video(String video) {
        this.video = video;
    }
}

class VideoStore {
    Video store[] = new Video[20];
    static int a = 0;

    void addVideo(String name) {
        if (a < 20) {
            store[a] = new Video(name);
            store[a].checkOut = false;
            store[a].receiveRating(0);
            System.out.println("Video added successfully.");
            a++;
        } else {
            System.out.println("Video store is full. Cannot add more videos.");
        }
    }

    void doCheckOut(String name) {
        for (int i = 0; i < a; i++) {
            if (store[i].getName().equals(name)) {
                store[i].doCheckOut();
                System.out.println("Video removed successfully from location " + i);
                return; // exit the loop once video is found
            }
        }
        System.out.println("No such video exists.");
    }

    void doReturn(String name) {
        for (int i = 0; i < a; i++) {
            if (store[i].getName().equals(name)) {
                store[i].doReturn();
                System.out.println(name + " is in location " + i);
                return; // exit the loop once video is found
            }
        }
        System.out.println("No such video exists.");
    }

    void receiveRating(String name, int rating) {
        for (int i = 0; i < a; i++) {
            if (store[i].getName().equals(name)) {
                store[i].receiveRating(rating);
                System.out.println(rating + " ratings are marked for " + name);
                return; // exit the loop once video is found
            }
        }
        System.out.println("No such video exists.");
    }

    void listInventory() {
        if (a == 0) {
            System.out.println("The inventory is empty.");
            return;
        }

        System.out.println("\nVideo Inventory:\n");
        for (int i = 0; i < a; i++) {
            if (!store[i].getCheckOut()) {
                System.out.println("Location " + i + ": Video - " + store[i].video + ", Rating - " + store[i].getRating());
            }
        }
    }

    public void exit() {
        System.out.println("Exiting the program. Goodbye!");
        System.exit(0);
    }
}




