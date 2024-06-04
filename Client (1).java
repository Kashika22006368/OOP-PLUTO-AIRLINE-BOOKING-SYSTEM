// Client Data by : Izzamer bin Baharuddin 22005742


import java.util.List;
import java.util.ArrayList;

public class Client {
    private String name;
    private String phoneNumber;
    private List<FlightReservation> flightReservations;

    public Client(String name, String phoneNumber, List<FlightReservation> flightReservations) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.flightReservations = flightReservations;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<FlightReservation> getFlightReservations() {
        return flightReservations;
    }

    public void setFlightReservations(List<FlightReservation> flightReservations) {
        this.flightReservations = flightReservations;
    }

    public static void main(String[] args) {
        List<FlightReservation> reservations = new ArrayList<>();
        Client client = new Client("Izzamer bin Baharuddin", "22005742", reservations);

        System.out.println("Client Name: " + client.getName());
        System.out.println("Client Phone Number: " + client.getPhoneNumber());
        System.out.println("Number of Reservations: " + client.getFlightReservations().size());
    }
}

class FlightReservation {
    public FlightReservation() {
    }
}

// Client Data by : Izzamer bin Baharuddin 22005742