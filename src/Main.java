import repository.EventRepository;
import repository.ReservationRepository;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        EventRepository ep = new EventRepository();
        ReservationRepository rr = new ReservationRepository();

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n1. Create Event");
            System.out.println("2. Show All Events");
            System.out.println("3. Update Event");
            System.out.println("4. Cancel Event");
            System.out.println("5. Create Reservation");
            System.out.println("6. Cancel Reservation");
            System.out.println("7. Show All Reservations");
            System.out.println("8. Reports");
            System.out.println("9. Exit");
            System.out.print("Select an option: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1" -> System.out.println("Creating Event...");
                case "2" -> System.out.println("Showing all events...");
                case "3" -> System.out.println("Updating Event...");
                case "4" -> System.out.println("Cancelling Event...");
                case "5" -> System.out.println("Creating Reservation...");
                case "6" -> System.out.println("Cancelling Reservation...");
                case "7" -> System.out.println("Showing all reservations...");
                case "8" -> System.out.println("Reports...");
                case "9" -> running = false;
                default -> System.out.println("Invalid choice!");
            }
        }
        scanner.close();
    }
    }
}