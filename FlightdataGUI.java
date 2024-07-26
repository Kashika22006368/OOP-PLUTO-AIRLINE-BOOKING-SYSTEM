//flightdataGUI
//KASHIKA PILLAI KALAI SELVAM 22006368

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

class Flight {
    private String flightNumber;
    private String destination;
    private String departureTime;

    public Flight(String flightNumber, String destination, String departureTime) {
        this.flightNumber = flightNumber;
        this.destination = destination;
        this.departureTime = departureTime;
    }

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
    private List<Flight> flights;

    public Flights() {
        flights = new ArrayList<>();
    }

    public void addFlight(Flight flight) {
        flights.add(flight);
        System.out.println("Flight added: " + flight);
    }

    public void removeFlight(Flight flight) {
        flights.remove(flight);
        System.out.println("Flight removed: " + flight);
    }

    public void printFlights() {
        for (Flight flight : flights) {
            System.out.println(flight);
        }
    }

    public Flight findFlight(String flightNumber) {
        for (Flight flight : flights) {
            if (flight.getFlightNumber().equals(flightNumber)) {
                return flight;
            }
        }
        return null;
    }

    public List<Flight> getFlights() {
        return flights;
    }
}

public class FlightGUI {
    private JFrame frame;
    private JTextField flightNumberField;
    private JTextField destinationField;
    private JTextField departureTimeField;
    private JTextArea outputArea;
    private Flights flights;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                FlightGUI window = new FlightGUI();
                window.frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public FlightGUI() {
        flights = new Flights();
        initialize();
    }

    private void initialize() {
        frame = new JFrame("Flight Management System");
        frame.setBounds(100, 100, 500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel();
        frame.getContentPane().add(inputPanel, BorderLayout.NORTH);
        inputPanel.setLayout(new GridLayout(4, 2, 5, 5));

        inputPanel.add(new JLabel("Flight Number:"));
        flightNumberField = new JTextField();
        inputPanel.add(flightNumberField);

        inputPanel.add(new JLabel("Destination:"));
        destinationField = new JTextField();
        inputPanel.add(destinationField);

        inputPanel.add(new JLabel("Departure Time:"));
        departureTimeField = new JTextField();
        inputPanel.add(departureTimeField);

        JButton btnAddFlight = new JButton("Add Flight");
        inputPanel.add(btnAddFlight);

        JButton btnRemoveFlight = new JButton("Remove Flight");
        inputPanel.add(btnRemoveFlight);

        outputArea = new JTextArea();
        outputArea.setEditable(false);
        frame.getContentPane().add(new JScrollPane(outputArea), BorderLayout.CENTER);

        btnAddFlight.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                handleAddFlight();
            }
        });

        btnRemoveFlight.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                handleRemoveFlight();
            }
        });
    }

    private void handleAddFlight() {
        String flightNumber = flightNumberField.getText();
        String destination = destinationField.getText();
        String departureTime = departureTimeField.getText();

        if (flightNumber.isEmpty() || destination.isEmpty() || departureTime.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Please enter all fields.");
            return;
        }

        flights.addFlight(new Flight(flightNumber, destination, departureTime));
        flightNumberField.setText("");
        destinationField.setText("");
        departureTimeField.setText("");
        updateOutput();
    }

    private void handleRemoveFlight() {
        String flightNumber = flightNumberField.getText();

        if (flightNumber.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Please enter a flight number.");
            return;
        }

        Flight flight = flights.findFlight(flightNumber);
        if (flight != null) {
            flights.removeFlight(flight);
            updateOutput();
        } else {
            JOptionPane.showMessageDialog(frame, "Flight not found.");
        }
    }

    private void updateOutput() {
        outputArea.setText("Current flights:\n");
        for (Flight flight : flights.getFlights()) {
            outputArea.append(flight + "\n");
        }
    }
}