//JEEVANATHAN A/L ARUMUGAM
//22005408


import java.util.ArrayList;
import java.util.List;

class Seats {
    private List<String> seats;

    public Seats() {
        seats = new ArrayList<>();
    }

    // Method to add a seat
    public void addSeat(String seat) {
        if (!seats.contains(seat)) {
            seats.add(seat);
        } else {
            System.out.println("Seat " + seat + " is already taken.");
        }
    }

    // Method to remove a seat
    public void removeSeat(String seat) {
        if (seats.contains(seat)) {
            seats.remove(seat);
        } else {
            System.out.println("Seat " + seat + " does not exist.");
        }
    }

    // Method to print all seats
    public void printSeats() {
        System.out.println("Current seats:");
        for (String seat : seats) {
            System.out.println(seat);
        }
    }

    // Method to find a seat
    public boolean findSeat(String seat) {
        return seats.contains(seat);
    }
}

public class Main {
    public static void main(String[] args) {
        Seats seats = new Seats();

        // Testing addSeat method
        seats.addSeat("1A");
        seats.addSeat("1B");

        // Testing printSeats method
        System.out.println("Seats after adding:");
        seats.printSeats();

        // Testing findSeat method
        System.out.println("Seat 1A found: " + seats.findSeat("1A"));
        System.out.println("Seat 2A found: " + seats.findSeat("2A"));

        // Testing removeSeat method
        seats.removeSeat("1A");
        System.out.println("Seats after removing 1A:");
        seats.printSeats();
    }
}

