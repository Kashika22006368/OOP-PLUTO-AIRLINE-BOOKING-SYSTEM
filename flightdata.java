//KASHIKA PILLAI A/P KALAI SELVAM 
//22006368

import java.util.ArrayList;
import java.util.List;

class Flight {
    // Add attributes for the Flight class
    private String flightNumber;
    private String destination;
    private String departureTime;

    // Constructor
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

    // Method to add a flight
    public void addFlight(Flight flight) {
        flights.add(flight);
        System.out.println("Flight added: " + flight);
    }

    // Method to remove a flight
    public void removeFlight(Flight flight) {
        flights.remove(flight);
        System.out.println("Flight removed: " + flight);
    }

    // Method to print all flights
    public void printFlights() {
        for (Flight flight : flights) {
            System.out.println(flight);
        }
    }

    // Method to find a flight by flight number
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

        Flight flight1 = new Flight("PA101", "Malaysia", "10:00 AM");
        Flight flight2 = new Flight("PA102", "Los Angeles", "12:00 PM");

        flights.addFlight(flight1);
        flights.addFlight(flight2);

        System.out.println("\nAll flights:");
        flights.printFlights();

        System.out.println("\nFinding flight PA101:");
        Flight foundFlight = flights.findFlight("PA101");
        System.out.println(foundFlight != null ? foundFlight : "Flight not found");

        flights.removeFlight(flight1);
        System.out.println("\nAll flights after removal:");
        flights.printFlights();
    }
}
