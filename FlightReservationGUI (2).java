//flightreservationGUI
//AMINUDDIN RAZIF BIN ARMAN 22007578
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FlightReservationGUI {

    private JFrame frame;
    private JTextField flightNumberField;
    private JTextField departureField;
    private JTextField destinationField;
    private JTextField departureTimeField;
    private JTextField arrivalTimeField;
    private JTextField seatNumberField;
    private JTextField classTypeField;
    private JCheckBox isAvailableCheckBox;
    private JTextField amountField;
    private JTextField currencyField;
    private JTextField clientNameField;
    private JTextField passportNumberField;
    private JTextField contactDetailsField;
    private JTextArea outputArea;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                FlightReservationGUI window = new FlightReservationGUI();
                window.frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public FlightReservationGUI() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame("Flight Reservation System");
        frame.setBounds(100, 100, 600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel();
        frame.getContentPane().add(inputPanel, BorderLayout.CENTER);
        inputPanel.setLayout(new GridLayout(12, 2, 5, 5));

        // Flight Information
        inputPanel.add(new JLabel("Flight Number:"));
        flightNumberField = new JTextField();
        inputPanel.add(flightNumberField);

        inputPanel.add(new JLabel("Departure:"));
        departureField = new JTextField();
        inputPanel.add(departureField);

        inputPanel.add(new JLabel("Destination:"));
        destinationField = new JTextField();
        inputPanel.add(destinationField);

        inputPanel.add(new JLabel("Departure Time:"));
        departureTimeField = new JTextField();
        inputPanel.add(departureTimeField);

        inputPanel.add(new JLabel("Arrival Time:"));
        arrivalTimeField = new JTextField();
        inputPanel.add(arrivalTimeField);

        // Seat Information
        inputPanel.add(new JLabel("Seat Number:"));
        seatNumberField = new JTextField();
        inputPanel.add(seatNumberField);

        inputPanel.add(new JLabel("Class Type:"));
        classTypeField = new JTextField();
        inputPanel.add(classTypeField);

        inputPanel.add(new JLabel("Is Available:"));
        isAvailableCheckBox = new JCheckBox();
        inputPanel.add(isAvailableCheckBox);

        // Price Information
        inputPanel.add(new JLabel("Amount:"));
        amountField = new JTextField();
        inputPanel.add(amountField);

        inputPanel.add(new JLabel("Currency:"));
        currencyField = new JTextField();
        inputPanel.add(currencyField);

        // Client Information
        inputPanel.add(new JLabel("Client Name:"));
        clientNameField = new JTextField();
        inputPanel.add(clientNameField);

        inputPanel.add(new JLabel("Passport Number:"));
        passportNumberField = new JTextField();
        inputPanel.add(passportNumberField);

        inputPanel.add(new JLabel("Contact Details:"));
        contactDetailsField = new JTextField();
        inputPanel.add(contactDetailsField);

        JButton btnSubmit = new JButton("Submit");
        inputPanel.add(btnSubmit);

        outputArea = new JTextArea();
        outputArea.setEditable(false);
        frame.getContentPane().add(new JScrollPane(outputArea), BorderLayout.SOUTH);

        btnSubmit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                handleSubmit();
            }
        });
    }

    private void handleSubmit() {
        String flightNumber = flightNumberField.getText();
        String departure = departureField.getText();
        String destination = destinationField.getText();
        String departureTime = departureTimeField.getText();
        String arrivalTime = arrivalTimeField.getText();

        Flight flight = new Flight(flightNumber, departure, destination, departureTime, arrivalTime);

        String seatNumber = seatNumberField.getText();
        String classType = classTypeField.getText();
        boolean isAvailable = isAvailableCheckBox.isSelected();

        Seat seat = new Seat(seatNumber, classType, isAvailable);

        double amount = Double.parseDouble(amountField.getText());
        String currency = currencyField.getText();

        Price price = new Price(amount, currency);

        String clientName = clientNameField.getText();
        String passportNumber = passportNumberField.getText();
        String contactDetails = contactDetailsField.getText();

        Client client = new Client(clientName, passportNumber, contactDetails);

        FlightReservation reservation = new FlightReservation(flight, seat, price, client);

        outputArea.setText("Reservation Details:\n");
        outputArea.append("Flight Number: " + reservation.getFlight().getFlightNumber() + "\n");
        outputArea.append("Departure: " + reservation.getFlight().getDeparture() + "\n");
        outputArea.append("Destination: " + reservation.getFlight().getDestination() + "\n");
        outputArea.append("Departure Time: " + reservation.getFlight().getDepartureTime() + "\n");
        outputArea.append("Arrival Time: " + reservation.getFlight().getArrivalTime() + "\n");
        outputArea.append("Seat Number: " + reservation.getSeat().getSeatNumber() + "\n");
        outputArea.append("Class Type: " + reservation.getSeat().getClassType() + "\n");
        outputArea.append("Is Available: " + reservation.getSeat().isAvailable() + "\n");
        outputArea.append("Amount: " + reservation.getPrice().getAmount() + " " + reservation.getPrice().getCurrency() + "\n");
        outputArea.append("Client Name: " + reservation.getClient().getName() + "\n");
        outputArea.append("Passport Number: " + reservation.getClient().getPassportNumber() + "\n");
        outputArea.append("Contact Details: " + reservation.getClient().getContactDetails() + "\n");
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

        public String getFlightNumber() {
            return flightNumber;
        }

        public String getDeparture() {
            return departure;
        }

        public String getDestination() {
            return destination;
        }

        public String getDepartureTime() {
            return departureTime;
        }

        public String getArrivalTime() {
            return arrivalTime;
        }
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

        public String getSeatNumber() {
            return seatNumber;
        }

        public String getClassType() {
            return classType;
        }

        public boolean isAvailable() {
            return isAvailable;
        }
    }

    class Price {
        private double amount;
        private String currency;

        public Price(double amount, String currency) {
            this.amount = amount;
            this.currency = currency;
        }

        public double getAmount() {
            return amount;
        }

        public String getCurrency() {
            return currency;
        }
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

        public String getName() {
            return name;
        }

        public String getPassportNumber() {
            return passportNumber;
        }

        public String getContactDetails() {
            return contactDetails;
        }
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

        public Flight getFlight() {
            return flight;
        }

        public Seat getSeat() {
            return seat;
        }

        public Price getPrice() {
            return price;
        }

        public Client getClient() {
            return client;
        }
    }
}