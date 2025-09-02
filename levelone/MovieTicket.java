class MovieTicket {
    String movieName;
    int seatNumber;
    double price;
    boolean booked;

    MovieTicket(String movieName) {
        this.movieName = movieName;
        this.booked = false;
    }

    public void bookTicket(int seatNumber, double price) {
        if (!booked) {
            this.seatNumber = seatNumber;
            this.price = price;
            this.booked = true;
            System.out.println("Ticket booked successfully!");
        } else {
            System.out.println("Seat already booked!");
        }
    }

    public void displayTicket() {
        if (booked) {
            System.out.println("----- Ticket Details -----");
            System.out.println("Movie Name : " + movieName);
            System.out.println("Seat Number: " + seatNumber);
            System.out.println("Price      : " + price);
        } else {
            System.out.println("No ticket booked yet!");
        }
    }
}

public class MovieBookingSystem {
    public static void main(String[] args) {
        MovieTicket ticket1 = new MovieTicket("Inception");
        MovieTicket ticket2 = new MovieTicket("Interstellar");

        ticket1.displayTicket();
        System.out.println();

        ticket1.bookTicket(12, 250);
        ticket1.displayTicket();
        System.out.println();

        ticket1.bookTicket(15, 300); 
        System.out.println();

        ticket2.bookTicket(8, 200);
        ticket2.displayTicket();
    }
}
