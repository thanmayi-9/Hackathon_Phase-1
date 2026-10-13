import java.util.Scanner;

class TicketBooking {
    // Instance variables
    private String movieName;
    private double ticketPrice;
    private int numberOfTickets;
    private String customerName;

    // Default price constant
    private static final double DEFAULT_PRICE = 200.00;

    // Constructor 1: Fully parameterized constructor
    public TicketBooking(String customerName, String movieName, double ticketPrice, int numberOfTickets) {
        this.customerName = customerName.toUpperCase();
        this.movieName = movieName.toUpperCase();
        this.ticketPrice = ticketPrice;
        this.numberOfTickets = numberOfTickets;
    }

    // Constructor 2: Overloaded constructor with a default ticket price
    public TicketBooking(String customerName, String movieName, int numberOfTickets) {
        this(customerName, movieName, DEFAULT_PRICE, numberOfTickets);
    }

    // Overloaded booking method 1: Full details processing
    public void processBooking() {
        if (!validateTickets()) {
            return;
        }

        double totalAmount = ticketPrice * numberOfTickets;
        double discount = 0.0;

        // Apply 10% discount if 5 or more tickets are booked
        if (numberOfTickets >= 5) {
            discount = totalAmount * 0.10;
        }

        double finalAmount = totalAmount - discount;

        displaySummary("Booking Successful", totalAmount, discount, finalAmount);
    }

    // Overloaded booking method 2: Overloaded option for processing with a custom/special price
    public void processBooking(double specialPrice) {
        this.ticketPrice = specialPrice;
        processBooking();
    }

    // Helper method to validate number of tickets
    private boolean validateTickets() {
        if (numberOfTickets <= 0) {
            System.out.println("Booking Failed: Number of tickets must be greater than zero.\n");
            return false;
        }
        return true;
    }

    // Helper method to display the booking summary
    private void displaySummary(String status, double total, double discount, double finalAmount) {
        System.out.println("\n========== BOOKING SUMMARY ==========");
        System.out.println("Customer Name     : " + customerName);
        System.out.println("Movie Name        : " + movieName);
        System.out.printf("Ticket Price      : Rs. %.2f\n", ticketPrice);
        System.out.println("Number of Tickets : " + numberOfTickets);
        System.out.println("Booking Status    : " + status);
        System.out.printf("Total Amount      : Rs. %.2f\n", total);
        System.out.printf("Discount          : Rs. %.2f\n", discount);
        System.out.printf("Final Amount      : Rs. %.2f\n", finalAmount);
        System.out.println("=====================================\n");
    }

    // Getter for customer name (used in comparison)
    public String getCustomerName() {
        return this.customerName;
    }
}

public class CinemaBookingSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("========== CINEMA TICKET BOOKING SYSTEM ==========");

        // --- BOOKING 1 (Uses Custom Price via Constructor 1) ---
        System.out.println("Enter Details for Booking 1:");
        System.out.print("Enter Customer Name: ");
        String name1 = scanner.nextLine();
        System.out.print("Enter Movie Name: ");
        String movie1 = scanner.nextLine();
        System.out.print("Enter Ticket Price: ");
        double price1 = scanner.nextDouble();
        System.out.print("Enter Number of Tickets: ");
        int tickets1 = scanner.nextInt();
        scanner.nextLine(); // Consume remaining newline character

        // Instantiating with Constructor 1
        TicketBooking booking1 = new TicketBooking(name1, movie1, price1, tickets1);
        booking1.processBooking();


        // --- BOOKING 2 (Uses Default Price via Overloaded Constructor 2) ---
        System.out.println("Enter Details for Booking 2 (Uses Default Price Rs. 200.00):");
        System.out.print("Enter Customer Name: ");
        String name2 = scanner.nextLine();
        System.out.print("Enter Movie Name: ");
        String movie2 = scanner.nextLine();
        System.out.print("Enter Number of Tickets: ");
        int tickets2 = scanner.nextInt();
        scanner.nextLine(); // Consume remaining newline character

        // Instantiating with Constructor 2 (Overloaded)
        TicketBooking booking2 = new TicketBooking(name2, movie2, tickets2);
        booking2.processBooking();


        // --- CUSTOMER VERIFICATION ---
        System.out.println("========== CUSTOMER VERIFICATION ==========");
        boolean namesMatch = booking1.getCustomerName().equalsIgnoreCase(booking2.getCustomerName());
        System.out.println("Booking 1 Customer: " + booking1.getCustomerName());
        System.out.println("Booking 2 Customer: " + booking2.getCustomerName());
        System.out.println("Names Match       : " + namesMatch);
        System.out.println("===========================================");

        scanner.close();
    }
}
