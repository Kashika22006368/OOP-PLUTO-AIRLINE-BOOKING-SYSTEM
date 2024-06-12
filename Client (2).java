/* Izzamer bin Baharuddin 22005472 */
/* Izzamer bin Baharuddin 22005472 */
/* Izzamer bin Baharuddin 22005472 */

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

    public Client(String name, String phoneNumber) {
        this(name, phoneNumber, new ArrayList<>());
    }

    public Client() {
        this("", "", new ArrayList<>());
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
        Client client = new Client("Izzamer", "123-456-7890", reservations);

        System.out.println("Client Name: " + client.getName());
        System.out.println("Client Phone Number: " + client.getPhoneNumber());
        System.out.println("Number of Reservations: " + client.getFlightReservations().size());

        Client client2 = new Client("Izzamer bin Baharuddin", "123-123-123");
        System.out.println("Client2 Name: " + client2.getName());
        System.out.println("Client2 Phone Number: " + client2.getPhoneNumber());
        System.out.println("Number of Reservations for Client2: " + client2.getFlightReservations().size());

        Client client3 = new Client();
        System.out.println("Client3 Name: " + client3.getName());
        System.out.println("Client3 Phone Number: " + client3.getPhoneNumber());
        System.out.println("Number of Reservations for Client3: " + client3.getFlightReservations().size());
    }
}

class FlightReservation {
    private String flightNumber;
    private String departureDate;
    private String arrivalDate;

    public FlightReservation(String flightNumber, String departureDate, String arrivalDate) {
        this.flightNumber = flightNumber;
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
    }

    public FlightReservation() {
        this("", "", "");
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }

    public String getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(String arrivalDate) {
        this.arrivalDate = arrivalDate;
    }
}
