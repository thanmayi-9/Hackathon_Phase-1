
    import java.util.Scanner;

class MovieTicket {
    String movieName;
    double ticketPrice;
    int numberOfTickets;

    MovieTicket(String movieName, double ticketPrice, int numberOfTickets) {
        this.movieName = movieName;
        this.ticketPrice = ticketPrice;
        this.numberOfTickets = numberOfTickets;
    }

    double calculateTotal() {
        return ticketPrice * numberOfTickets;
    }

    double calculateDiscount() {
        if (numberOfTickets >= 5) {
            return calculateTotal() * 0.10;
        } else {
            return 0;
        }
    }

    double calculateFinalAmount() {
        return calculateTotal() - calculateDiscount();
    }

    void displayBill() {
        System.out.println("\n--- Movie Ticket Bill ---");
        System.out.println("Movie Name: " + movieName);
        System.out.printf("Ticket Price: %.2f%n", ticketPrice);
        System.out.println("Number of Tickets: " + numberOfTickets);
        System.out.printf("Discount: %.2f%n", calculateDiscount());
        System.out.printf("Final Amount: %.2f%n", calculateFinalAmount());
    }
}

public class hackathon{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.printf("Enter movie name: ");
        String movieName = sc.nextLine();

        System.out.printf("Enter ticket price: ");
        double ticketPrice = sc.nextDouble();

        System.out.printf("Enter number of tickets: ");
        int numberOfTickets = sc.nextInt();

        MovieTicket ticket =
                new MovieTicket(movieName, ticketPrice, numberOfTickets);

        ticket.displayBill();

        sc.close();
    }
}

