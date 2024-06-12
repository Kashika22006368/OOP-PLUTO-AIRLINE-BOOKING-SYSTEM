//KASHIKA PILLAI A/P KALAI SELVAM
//22006368


import java.util.ArrayList;
import java.util.List;

class Flight {
    // Add attributes for the Flight class
    private String flightNumber;
    private String destination;
    private String departureTime;

    // Default constructor
    public Flight() {
    }

    // Constructor with flightNumber
    public Flight(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    // Constructor with flightNumber and destination
    public Flight(String flightNumber, String destination) {
        this.flightNumber = flightNumber;
        this.destination = destination;
    }

    // Constructor with all attributes
    public Flight(String flightNumber, String destination, String departureTime) {
        this.flightNumber = flightNumber;
        this.destination = destination;
        this.departureTime = departureTime;
    }

    // Getters and Setters
    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
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

    @Override
    public String toString() {
        return "Flight{" +
                "flightNumber='" + flightNumber + '\'' +
                ", destination='" + destination + '\'' +
                ", departureTime='" + departureTime + '\'' +
                '}';
    }
}

class Flights {
    // List of flights
    private List<Flight> flights;

    // Constructor
    public Flights() {
        flights = new ArrayList<>();
    }

    // To add a flight
    public void addFlight(Flight flight) {
        flights.add(flight);
        System.out.println("Flight added: " + flight);
    }

    // To remove a flight
    public void removeFlight(Flight flight) {
        flights.remove(flight);
        System.out.println("Flight removed: " + flight);
    }

    // To print all flights
    public void printFlights() {
        for (Flight flight : flights) {
            System.out.println(flight);
        }
    }

    // To find a flight by flight number
    public Flight findFlight(String flightNumber) {
        for (Flight flight : flights) {
            if (flight.getFlightNumber().equals(flightNumber)) {
                return flight;
            }
        }
        return null;
    }
}

public class flightdata {
    public static void main(String[] args) {
        Flights flights = new Flights();

        // Test different constructors
        Flight flight1 = new Flight("PA101", "Malaysia", "10:00 AM");
        Flight flight2 = new Flight("PA102", "Los Angeles", "12:00 PM");
        Flight flight3 = new Flight("PA103", "Bangkok");
        Flight flight4 = new Flight("PA104");

        flights.addFlight(flight1);
        flights.addFlight(flight2);
        flights.addFlight(flight3);
        flights.addFlight(flight4);

        System.out.println("\nAll flights:");
        flights.printFlights();

        System.out.println("\nFinding flight PA101:");
        Flight foundFlight = flights.findFlight("PA101");
        System.out.println(foundFlight != null ? foundFlight : "Flight not found");

        flights.removeFlight(flight1);
        System.out.println("\nAll flights after removal:");
        flights.printFlights();

        // Setting attributes using setters
        flight4.setDestination("Maldives");
        flight4.setDepartureTime("6:00 PM");
        System.out.println("\nUpdated flight PA104:");
        System.out.println(flight4);
    }
}
