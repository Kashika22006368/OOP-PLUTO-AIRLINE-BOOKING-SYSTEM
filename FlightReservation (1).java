//AMINUDDIN RAZIF BIN ARMAN 22007578//

public class FlightReservation {
    private Flight flight;
    private Seat seat;
    private Price price;
    private Client client;

    // Default constructor
    public FlightReservation() {}

    // Constructor with all parameters
    public FlightReservation(Flight flight, Seat seat, Price price, Client client) {
        this.flight = flight;
        this.seat = seat;
        this.price = price;
        this.client = client;
    }

    // Constructor without Price parameter
    public FlightReservation(Flight flight, Seat seat, Client client) {
        this.flight = flight;
        this.seat = seat;
        this.client = client;
    }

    // Constructor without Client parameter
    public FlightReservation(Flight flight, Seat seat, Price price) {
        this.flight = flight;
        this.seat = seat;
        this.price = price;
    }

    // Getter and Setter methods
    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public Seat getSeat() {
        return seat;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }

    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    // Additional methods for reservation management
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

    public static void main(String[] args) {
        // Create instances of Flight, Seat, Price, and Client
        Flight flight = new Flight("AA123", "New York", "Los Angeles", "2024-06-15 08:00", "2024-06-15 11:00");
        Seat seat = new Seat("12A", "Economy", true);
        Price price = new Price(299.99, "USD");
        Client client = new Client("John Doe", "123456789", "john.doe@example.com");

        // Create a FlightReservation instance
        FlightReservation reservation = new FlightReservation(flight, seat, price, client);

        // Print reservation details
        System.out.println("Flight Number: " + reservation.getFlight().getFlightNumber());
        System.out.println("Seat Number: " + reservation.getSeat().getSeatNumber());
        System.out.println("Price: " + reservation.getPrice().getAmount() + " " + reservation.getPrice().getCurrency());
        System.out.println("Client Name: " + reservation.getClient().getName());
        System.out.println("Client Passport Number: " + reservation.getClient().getPassportNumber());
        System.out.println("Client Contact Details: " + reservation.getClient().getContactDetails());

        // Testing getters and setters
        reservation.setFlight(new Flight("BB456", "San Francisco", "Chicago", "2024-07-01 10:00", "2024-07-01 14:00"));
        reservation.setSeat(new Seat("14C", "Business", true));
        reservation.setPrice(new Price(499.99, "USD"));
        reservation.setClient(new Client("Jane Smith", "987654321", "jane.smith@example.com"));

        System.out.println("Updated Flight Number: " + reservation.getFlight().getFlightNumber());
        System.out.println("Updated Seat Number: " + reservation.getSeat().getSeatNumber());
        System.out.println("Updated Price: " + reservation.getPrice().getAmount() + " " + reservation.getPrice().getCurrency());
        System.out.println("Updated Client Name: " + reservation.getClient().getName());
    }
}

class Flight {
    private String flightNumber;
    private String departure;
    private String destination;
    private String departureTime;
    private String arrivalTime;

    // Default constructor
    public Flight() {}

    // Parameterized constructor
    public Flight(String flightNumber, String departure, String destination, String departureTime, String arrivalTime) {
        this.flightNumber = flightNumber;
        this.departure = departure;
        this.destination = destination;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
    }

    // Getter and Setter methods
    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }
}

class Seat {
    private String seatNumber;
    private String classType;
    private boolean isAvailable;

    // Default constructor
    public Seat() {}

    // Parameterized constructor
    public Seat(String seatNumber, String classType, boolean isAvailable) {
        this.seatNumber = seatNumber;
        this.classType = classType;
        this.isAvailable = isAvailable;
    }

    // Getter and Setter methods
    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public String getClassType() {
        return classType;
    }

    public void setClassType(String classType) {
        this.classType = classType;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }
}

class Price {
    private double amount;
    private String currency;

    // Default constructor
    public Price() {}

    // Parameterized constructor
    public Price(double amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    // Getter and Setter methods
    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}

class Client {
    private String name;
    private String passportNumber;
    private String contactDetails;

    // Default constructor
    public Client() {}

    // Parameterized constructor
    public Client(String name, String passportNumber, String contactDetails) {
        this.name = name;
        this.passportNumber = passportNumber;
        this.contactDetails = contactDetails;
    }

    // Getter and Setter methods
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public String getContactDetails() {
        return contactDetails;
    }

    public void setContactDetails(String contactDetails) {
        this.contactDetails = contactDetails;
    }
}
