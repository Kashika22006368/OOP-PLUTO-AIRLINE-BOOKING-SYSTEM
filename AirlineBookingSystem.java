import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class AirlineBookingSystem {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        System.out.println("WELCOME TO PLUTO AIRLINE BOOKING SYSTEM");

        System.out.print("Enter the airline: ");
        String airline = scanner.nextLine();

        System.out.print("Enter the flight date (dd/MM/yyyy): ");
        String dateInput = scanner.nextLine();
        Date date = null;
        try {
            date = dateFormat.parse(dateInput);
        } catch (ParseException e) {
            System.out.println("Invalid date format. Please use dd/MM/yyyy.");
            System.exit(1);
        }

        System.out.print("Enter the origin: ");
        String origin = scanner.nextLine();

        System.out.print("Enter the destination: ");
        String destination = scanner.nextLine();

        // Use predefined seats list
        List<String> seats = new ArrayList<>();
        seats.add("1A");
        seats.add("1B");
        seats.add("2A");
        seats.add("2B");

        Flight flight = new Flight(airline, date, origin, destination, seats);

        // Print flight details
        flight.printFlightDetails();
    }

    public static class Flight {
        private String airline;
        private Date date;
        private String origin;
        private String destination;
        private List<String> seats;

        public Flight(String airline, Date date, String origin, String destination, List<String> seats) {
            this.airline = airline;
            this.date = date;
            this.origin = origin;
            this.destination = destination;
            this.seats = seats;
        }

        // Getters
        public String getAirline() {
            return airline;
        }

        public Date getDate() {
            return date;
        }

        public String getOrigin() {
            return origin;
        }

        public String getDestination() {
            return destination;
        }

        public List<String> getSeats() {
            return seats;
        }

        // Setters
        public void setAirline(String airline) {
            this.airline = airline;
        }

        public void setDate(Date date) {
            this.date = date;
        }

        public void setOrigin(String origin) {
            this.origin = origin;
        }

        public void setDestination(String destination) {
            this.destination = destination;
        }

        public void setSeats(List<String> seats) {
            this.seats = seats;
        }

        // Method to print flight details
        public void printFlightDetails() {
            System.out.println("Airline: " + airline);
            System.out.println("Date: " + date);
            System.out.println("Origin: " + origin);
            System.out.println("Destination: " + destination);
            System.out.println("Seats: " + seats);
        }
    }
}

