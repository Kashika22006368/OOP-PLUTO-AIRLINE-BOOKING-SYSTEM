//KASHIKA PILLAI A/P KALAI SELVAM 22006368

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PlutoAirline {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("WELCOME TO PLUTO AIRLINE BOOKING SYSTEM");

        try {
            // Get user input for flight details
            // Since the airline is not entered by the user, you can set it directly
            String airline = "Pluto Airline"; // Example airline name

            System.out.println("Enter Date (yyyy-MM-dd): ");
            String dateString = scanner.nextLine();
            LocalDate date = LocalDate.parse(dateString);

            System.out.println("Enter Origin: ");
            String origin = scanner.nextLine();

            System.out.println("Enter Destination: ");
            String destination = scanner.nextLine();

            System.out.println("Enter Number of Seats: ");
            int numOfSeats = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            // Create a list of dummy seats with all seats available
            List<Seat> seats = new ArrayList<>();
            for (int i = 1; i <= numOfSeats; i++) {
                seats.add(new Seat(i, 'O')); // All seats are initially available
            }

            // Create a Flight object with user input
            Flight flight = new Flight(airline, date, origin, destination, seats);

            // Display available seats
            displayAvailableSeats(flight);

            // Display seating arrangement
            displaySeatingArrangement(flight);

            // Select a seat
            System.out.println("Enter the seat number you want to book: ");
            int selectedSeatNumber = scanner.nextInt();
            boolean seatFound = false;
            for (Seat seat : flight.getSeats()) {
                if (seat.getSeatNumber() == selectedSeatNumber && seat.getAvailability() == 'O') {
                    seat.setAvailability('X'); // Mark the seat as booked
                    seatFound = true;
                    break;
                }
            }
            if (seatFound) {
                System.out.println("Seat " + selectedSeatNumber + " booked successfully.");
            } else {
                System.out.println("Seat " + selectedSeatNumber + " is not available or does not exist.");
            }
        } catch (DateTimeParseException e) {
            System.out.println("Invalid date format. Please enter date in the format yyyy-MM-dd.");
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }

    // Method to display available seats
    private static void displayAvailableSeats(Flight flight) {
        System.out.println("Available Seats:");
        for (Seat seat : flight.getSeats()) {
            if (seat.getAvailability() == 'O') {
                System.out.println("Seat Number: " + seat.getSeatNumber());
            }
        }
    }

  private static void displaySeatingArrangement(Flight flight) {
    System.out.println("Seating Arrangement:");
    int columnCount = 0;
    for (int i = 0; i < flight.getSeats().size(); i++) {
        Seat seat = flight.getSeats().get(i);
        System.out.print(seat.getAvailability() + " ");
        columnCount++;
        if (columnCount == 6) {
            System.out.println(); // New line after every 6 seats
            columnCount = 0; // Reset column count for the next row
        }
    }
}

}

class Flight {
    private String airline;
    private LocalDate date;  // Using LocalDate for better practice
    private String origin;
    private String destination;
    private List<Seat> seats;

    // Constructor
    public Flight(String airline, LocalDate date, String origin, String destination, List<Seat> seats) {
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

    public LocalDate getDate() {
        return date;
    }

    public String getOrigin() {
        return origin;
    }

    public String getDestination() {
        return destination;
    }

    public List<Seat> getSeats() {
        return seats;
    }
}

class Seat {
    private int seatNumber;
    private char availability; // 'O' for available, 'X' for not available

    // Constructor
    public Seat(int seatNumber, char availability) {
        this.seatNumber = seatNumber;
        this.availability = availability;
    }

    // Getters
    public int getSeatNumber() {
        return seatNumber;
    }

    public char getAvailability() {
        return availability;
    }

    // Setter
    public void setAvailability(char availability) {
        this.availability = availability;
    }
}
