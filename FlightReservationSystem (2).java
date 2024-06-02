public class FlightReservationSystem {
    
    //Aminuddin Razif Bin Arman 22007578

    public static void main(String[] args) {
        // Create instances of the Flight, Seat, Price, and Client classes
        Flight flight = new Flight("AA123", "New York", "Los Angeles", "10:00 AM", "1:00 PM");
        Seat seat = new Seat("12A", "Economy", true);
        Price price = new Price(299.99, "USD");
        Client client = new Client("John Doe", "A12345678", "john123@gmail.com");

        // Create an instance of the FlightReservation class
        FlightReservation reservation = new FlightReservation(flight, seat, price, client);

        // Test the methods (these methods are blank and will not produce any output)
        reservation.reserveSeat();
        reservation.cancelReservation();
        reservation.updateReservation(
            new Flight("BB456", "San Francisco", "Chicago", "2:00 PM", "5:00 PM"),
            new Seat("14C", "Business", true),
            new Price(499.99, "USD")
        );
        reservation.getReservationDetails();

        // Print to confirm test execution
        System.out.println("Flight reservation methods have been called.");
    }
}

class Flight {
    private String flightNumber;
    private String departure;
    private String destination;
    private String departureTime;
    private String arrivalTime;

    public Flight(String flightNumber, String departure, String destination, String departureTime, String arrivalTime) {
        this.flightNumber = flightNumber;
        this.departure = departure;
        this.destination = destination;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
    }

    // Getters and setters can be added here if needed
}

class Seat {
    private String seatNumber;
    private String classType;
    private boolean isAvailable;

    public Seat(String seatNumber, String classType, boolean isAvailable) {
        this.seatNumber = seatNumber;
        this.classType = classType;
        this.isAvailable = isAvailable;
    }

    // Getters and setters can be added here if needed
}

class Price {
    private double amount;
    private String currency;

    public Price(double amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    // Getters and setters can be added here if needed
}

class Client {
    private String name;
    private String passportNumber;
    private String contactDetails;

    public Client(String name, String passportNumber, String contactDetails) {
        this.name = name;
        this.passportNumber = passportNumber;
        this.contactDetails = contactDetails;
    }

    // Getters and setters can be added here if needed
}

class FlightReservation {
    private Flight flight;
    private Seat seat;
    private Price price;
    private Client client;

    public FlightReservation(Flight flight, Seat seat, Price price, Client client) {
        this.flight = flight;
        this.seat = seat;
        this.price = price;
        this.client = client;
    }

    public void reserveSeat() {
        // Implementation goes here
    }

    public void cancelReservation() {
        // Implementation goes here
    }

    public void updateReservation(Flight newFlight, Seat newSeat, Price newPrice) {
        // Implementation goes here
    }

    public void getReservationDetails() {
        // Implementation goes here
    }

    // Getters and setters can be added here if needed
}

