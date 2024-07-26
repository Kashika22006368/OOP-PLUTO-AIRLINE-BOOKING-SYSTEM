//airlinebookingsystemGUI
//kashika pillai kalai selvam 22006368
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class AirlineBookingSystemGUI {

    private JFrame frame;
    private JTextField airlineField;
    private JTextField dateField;
    private JTextField originField;
    private JTextField destinationField;
    private JTextArea outputArea;
    private SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                AirlineBookingSystemGUI window = new AirlineBookingSystemGUI();
                window.frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public AirlineBookingSystemGUI() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame("PLUTO Airline Booking System");
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel();
        frame.getContentPane().add(inputPanel, BorderLayout.CENTER);
        inputPanel.setLayout(new GridLayout(5, 2, 5, 5));

        JLabel lblAirline = new JLabel("Enter the airline:");
        inputPanel.add(lblAirline);

        airlineField = new JTextField();
        inputPanel.add(airlineField);
        airlineField.setColumns(10);

        JLabel lblDate = new JLabel("Enter the flight date (dd/MM/yyyy):");
        inputPanel.add(lblDate);

        dateField = new JTextField();
        inputPanel.add(dateField);
        dateField.setColumns(10);

        JLabel lblOrigin = new JLabel("Enter the origin:");
        inputPanel.add(lblOrigin);

        originField = new JTextField();
        inputPanel.add(originField);
        originField.setColumns(10);

        JLabel lblDestination = new JLabel("Enter the destination:");
        inputPanel.add(lblDestination);

        destinationField = new JTextField();
        inputPanel.add(destinationField);
        destinationField.setColumns(10);

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
        String airline = airlineField.getText();
        String dateInput = dateField.getText();
        Date date = null;
        try {
            date = dateFormat.parse(dateInput);
        } catch (ParseException e) {
            outputArea.setText("Invalid date format. Please use dd/MM/yyyy.");
            return;
        }

        String origin = originField.getText();
        String destination = destinationField.getText();

        List<String> seats = new ArrayList<>();
        seats.add("1A");
        seats.add("1B");
        seats.add("2A");
        seats.add("2B");

        Flight flight = new Flight(airline, date, origin, destination, seats);

        outputArea.setText(flight.getFlightDetails());
    }

    public static class Flight {
        private String airline;
        private Date date;
        private String origin;
        private String destination;
        private List<String> seats;

        public Flight(String airline, Date date, String origin, String destination, List<String> seats) {
            this.airline = airline;
            this.date = date;
            this.origin = origin;
            this.destination = destination;
            this.seats = seats;
        }

        public String getFlightDetails() {
            StringBuilder sb = new StringBuilder();
            sb.append("Airline: ").append(airline).append("\n");
            sb.append("Date: ").append(date).append("\n");
            sb.append("Origin: ").append(origin).append("\n");
            sb.append("Destination: ").append(destination).append("\n");
            sb.append("Seats: ").append(seats).append("\n");
            return sb.toString();
        }
    }
}