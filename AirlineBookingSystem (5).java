package com.example.FlightReservation;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

// Main GUI class
public class MainAppGUI {
    private JFrame frame;
    private JPanel cardPanel;
    private CardLayout cardLayout;

    // FlightReservationGUI components
    private JTextField flightNumberField;
    private JTextField flightNameField;
    private JTextField departureField;
    private JTextField destinationField;
    private JTextField departureTimeField;
    private JTextField arrivalTimeField;
    private JTextField seatNumberField;
    private JTextField classTypeField;
    private JCheckBox isAvailableCheckBox;
    private JTextField priceAmountField;
    private JTextField priceCurrencyField;
    private JTextField clientNameField;
    private JTextField clientPassportNumberField;
    private JTextField clientContactDetailsField;
    private JTextField clientPhoneNumberField;
    private JTextField flightDateField1;

    // AirlineBookingSystemGUI components
    private JTextField airlineNameField;
    private JTextField flightDateField;

    public MainAppGUI() {
        frame = new JFrame("Booking System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);

        // FlightReservationGUI Panel
        JPanel flightReservationPanel = new JPanel();
        flightReservationPanel.setLayout(new BoxLayout(flightReservationPanel, BoxLayout.Y_AXIS));
        flightReservationPanel.setBackground(new Color(240, 248, 255)); // AliceBlue background

        // Flight Information Panel
        JPanel flightPanel = new JPanel();
        flightPanel.setBackground(new Color(255, 250, 240)); // FloralWhite background
        flightPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.DARK_GRAY), "Flight Information", TitledBorder.LEFT, TitledBorder.TOP, new Font("Arial", Font.BOLD, 12), Color.DARK_GRAY));
        flightPanel.setLayout(new GridLayout(7, 2, 5, 5));
        flightPanel.setOpaque(true);

        flightPanel.add(new JLabel("Flight Number:"));
        flightNumberField = new JTextField();
        flightPanel.add(flightNumberField);

        flightPanel.add(new JLabel("Flight Name:"));
        flightNameField = new JTextField();
        flightPanel.add(flightNameField);

        flightPanel.add(new JLabel("Flight Date:"));
        flightDateField1 = new JTextField();
        flightPanel.add(flightDateField1);

        flightPanel.add(new JLabel("Departure:"));
        departureField = new JTextField();
        flightPanel.add(departureField);

        flightPanel.add(new JLabel("Destination:"));
        destinationField = new JTextField();
        flightPanel.add(destinationField);

        flightPanel.add(new JLabel("Departure Time:"));
        departureTimeField = new JTextField();
        flightPanel.add(departureTimeField);

        flightPanel.add(new JLabel("Arrival Time:"));
        arrivalTimeField = new JTextField();
        flightPanel.add(arrivalTimeField);

        // Seat Information Panel
        JPanel seatPanel = new JPanel();
        seatPanel.setBackground(new Color(224, 255, 255)); // LightCyan background
        seatPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.DARK_GRAY), "Seat Information", TitledBorder.LEFT, TitledBorder.TOP, new Font("Arial", Font.BOLD, 12), Color.DARK_GRAY));
        seatPanel.setLayout(new GridLayout(3, 2, 5, 5));
        seatPanel.setOpaque(true);

        seatPanel.add(new JLabel("Seat Number:"));
        seatNumberField = new JTextField();
        seatPanel.add(seatNumberField);

        seatPanel.add(new JLabel("Class Type:"));
        classTypeField = new JTextField();
        seatPanel.add(classTypeField);

        seatPanel.add(new JLabel("Is Available:"));
        isAvailableCheckBox = new JCheckBox();
        seatPanel.add(isAvailableCheckBox);

        // Price Information Panel
        JPanel pricePanel = new JPanel();
        pricePanel.setBackground(new Color(255, 255, 224)); // LightYellow background
        pricePanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.DARK_GRAY), "Price Information", TitledBorder.LEFT, TitledBorder.TOP, new Font("Arial", Font.BOLD, 12), Color.DARK_GRAY));
        pricePanel.setLayout(new GridLayout(2, 2, 5, 5));
        pricePanel.setOpaque(true);

        pricePanel.add(new JLabel("Price Amount:"));
        priceAmountField = new JTextField();
        pricePanel.add(priceAmountField);

        pricePanel.add(new JLabel("Price Currency:"));
        priceCurrencyField = new JTextField();
        pricePanel.add(priceCurrencyField);

        // Client Information Panel
        JPanel clientPanel = new JPanel();
        clientPanel.setBackground(new Color(240, 255, 240)); // HoneyDew background
        clientPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.DARK_GRAY), "Client Information", TitledBorder.LEFT, TitledBorder.TOP, new Font("Arial", Font.BOLD, 12), Color.DARK_GRAY));
        clientPanel.setLayout(new GridLayout(5, 2, 5, 5));
        clientPanel.setOpaque(true);

        clientPanel.add(new JLabel("Client Name:"));
        clientNameField = new JTextField();
        clientPanel.add(clientNameField);

        clientPanel.add(new JLabel("Client Phone Number:"));
        clientPhoneNumberField = new JTextField();
        clientPanel.add(clientPhoneNumberField);

        clientPanel.add(new JLabel("Client Passport Number:"));
        clientPassportNumberField = new JTextField();
        clientPanel.add(clientPassportNumberField);

        clientPanel.add(new JLabel("Client Contact Details:"));
        clientContactDetailsField = new JTextField();
        clientPanel.add(clientContactDetailsField);

        // Button Panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(new Color(255, 204, 153)); // LightOrange background
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

        JButton reserveButton = new JButton("Reserve");
        reserveButton.setFont(new Font("Arial", Font.BOLD, 14));
        reserveButton.setBackground(new Color(102, 204, 255)); // LightBlue background
        reserveButton.setForeground(Color.BLACK);
        reserveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Flight flight = new Flight(flightNumberField.getText(), flightNameField.getText(), flightDateField1.getText(), departureField.getText(), destinationField.getText(), departureTimeField.getText(), arrivalTimeField.getText());
                Seat seat = new Seat(seatNumberField.getText(), classTypeField.getText(), isAvailableCheckBox.isSelected());
                Price price = new Price(Double.parseDouble(priceAmountField.getText()), priceCurrencyField.getText());
                Client client = new Client(clientNameField.getText(), clientPassportNumberField.getText(), clientContactDetailsField.getText(), clientPhoneNumberField.getText());
                FlightReservation reservation = new FlightReservation(flight, seat, price, client);

                // Add reservation to database
                addReservationToDatabase(reservation);
            }
        });
        buttonPanel.add(reserveButton);

        JButton cancelButton = new JButton("Cancel");
        cancelButton.setFont(new Font("Arial", Font.BOLD, 14));
        cancelButton.setBackground(new Color(255, 99, 71)); // Tomato background
        cancelButton.setForeground(Color.BLACK);
        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Clear all fields
                flightNumberField.setText("");
                flightNameField.setText("");
                flightDateField1.setText("");
                departureField.setText("");
                destinationField.setText("");
                departureTimeField.setText("");
                arrivalTimeField.setText("");
                seatNumberField.setText("");
                classTypeField.setText("");
                isAvailableCheckBox.setSelected(false);
                priceAmountField.setText("");
                priceCurrencyField.setText("");
                clientNameField.setText("");
                clientPassportNumberField.setText("");
                clientContactDetailsField.setText("");
                clientPhoneNumberField.setText("");
            }
        });
        buttonPanel.add(cancelButton);

        flightReservationPanel.add(flightPanel);
        flightReservationPanel.add(seatPanel);
        flightReservationPanel.add(pricePanel);
        flightReservationPanel.add(clientPanel);
        flightReservationPanel.add(buttonPanel);

        // AirlineBookingSystemGUI Panel
        JPanel airlineBookingPanel = new JPanel();
        airlineBookingPanel.setLayout(new BorderLayout());

        JPanel bookingPanel = new JPanel();
        bookingPanel.setBackground(new Color(255, 228, 225)); // MistyRose background
        bookingPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.DARK_GRAY), "Booking Information", TitledBorder.LEFT, TitledBorder.TOP, new Font("Arial", Font.BOLD, 12), Color.DARK_GRAY));
        bookingPanel.setLayout(new GridLayout(2, 2, 5, 5));

        bookingPanel.add(new JLabel("Airline Name:"));
        airlineNameField = new JTextField();
        bookingPanel.add(airlineNameField);

        bookingPanel.add(new JLabel("Flight Date:"));
        flightDateField = new JTextField();
        bookingPanel.add(flightDateField);

        airlineBookingPanel.add(bookingPanel, BorderLayout.CENTER);

        JButton searchButton = new JButton("Search");
        searchButton.setFont(new Font("Arial", Font.BOLD, 14));
        searchButton.setBackground(new Color(102, 204, 255)); // LightBlue background
        searchButton.setForeground(Color.BLACK);
        searchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Implement search functionality here
                JOptionPane.showMessageDialog(frame, "Search functionality is not implemented.");
            }
        });
        airlineBookingPanel.add(searchButton, BorderLayout.SOUTH);

        // Add panels to cardPanel
        cardPanel.add(flightReservationPanel, "FlightReservation");
        cardPanel.add(airlineBookingPanel, "AirlineBooking");

        // Add cardPanel to frame
        frame.add(cardPanel, BorderLayout.CENTER);

        // Add a menu bar
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Menu");
        JMenuItem flightReservationMenuItem = new JMenuItem("Flight Reservation");
        flightReservationMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "FlightReservation");
            }
        });
        JMenuItem airlineBookingMenuItem = new JMenuItem("Airline Booking");
        airlineBookingMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "AirlineBooking");
            }
        });
        menu.add(flightReservationMenuItem);
        menu.add(airlineBookingMenuItem);
        menuBar.add(menu);
        frame.setJMenuBar(menuBar);

        // Set frame size and visibility
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void addReservationToDatabase(FlightReservation reservation) {
        String url = "jdbc:mysql://localhost:3306/abs"; // Updated database name
        String username = "root"; // Default MySQL username for XAMPP
        String password = ""; // Default MySQL password for XAMPP, usually empty

        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            String sql = "INSERT INTO absdb (Flight_Num, Flight_Name, Flight_Date, Departure, Destination, Departure_Time, Arrival_Time, Seat_Num, Class_Type, Is_Avail, Price_Amount, Price_Currency, Client_Name, Client_Phone_Num, Client_Passport_Num, Client_Contact_Details) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, reservation.getFlight().getFlightNumber());
            stmt.setString(2, reservation.getFlight().getFlightName());
            stmt.setString(3, reservation.getFlight().getFlightDate());
            stmt.setString(4, reservation.getFlight().getDeparture());
            stmt.setString(5, reservation.getFlight().getDestination());
            stmt.setString(6, reservation.getFlight().getDepartureTime());
            stmt.setString(7, reservation.getFlight().getArrivalTime());
            stmt.setString(8, reservation.getSeat().getSeatNumber());
            stmt.setString(9, reservation.getSeat().getClassType());
            stmt.setBoolean(10, reservation.getSeat().isAvailable());
            stmt.setDouble(11, reservation.getPrice().getAmount());
            stmt.setString(12, reservation.getPrice().getCurrency());
            stmt.setString(13, reservation.getClient().getName());
            stmt.setString(14, reservation.getClient().getPhoneNumber());
            stmt.setString(15, reservation.getClient().getPassportNumber());
            stmt.setString(16, reservation.getClient().getContactDetails());

            stmt.executeUpdate();
            JOptionPane.showMessageDialog(frame, "Reservation added successfully!");
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(frame, "Error adding reservation to database: " + ex.getMessage());
        }
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new MainAppGUI();
            }
        });
    }
}

// Flight class
class Flight {
    private String flightNumber;
    private String flightName;
    private String flightDate;
    private String departure;
    private String destination;
    private String departureTime;
    private String arrivalTime;

    // Constructor, getters, and setters
    public Flight(String flightNumber, String flightName, String flightDate, String departure, String destination, String departureTime, String arrivalTime) {
        this.flightNumber = flightNumber;
        this.flightName = flightName;
        this.flightDate = flightDate;
        this.departure = departure;
        this.destination = destination;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
    }

    public String getFlightNumber() { return flightNumber; }
    public String getFlightName() { return flightName; }
    public String getFlightDate() { return flightDate; }
    public String getDeparture() { return departure; }
    public String getDestination() { return destination; }
    public String getDepartureTime() { return departureTime; }
    public String getArrivalTime() { return arrivalTime; }
}

// Seat class
class Seat {
    private String seatNumber;
    private String classType;
    private boolean isAvailable;

    // Constructor, getters, and setters
    public Seat(String seatNumber, String classType, boolean isAvailable) {
        this.seatNumber = seatNumber;
        this.classType = classType;
        this.isAvailable = isAvailable;
    }

    public String getSeatNumber() { return seatNumber; }
    public String getClassType() { return classType; }
    public boolean isAvailable() { return isAvailable; }
}

// Price class
class Price {
    private double amount;
    private String currency;

    // Constructor, getters, and setters
    public Price(double amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public double getAmount() { return amount; }
    public String getCurrency() { return currency; }
}

// Client class
class Client {
    private String name;
    private String passportNumber;
    private String contactDetails;
    private String phoneNumber;

    // Constructor, getters, and setters
    public Client(String name, String passportNumber, String contactDetails, String phoneNumber) {
        this.name = name;
        this.passportNumber = passportNumber;
        this.contactDetails = contactDetails;
        this.phoneNumber = phoneNumber;
    }

    public String getName() { return name; }
    public String getPassportNumber() { return passportNumber; }
    public String getContactDetails() { return contactDetails; }
    public String getPhoneNumber() { return phoneNumber; }
}

// FlightReservation class
class FlightReservation {
    private Flight flight;
    private Seat seat;
    private Price price;
    private Client client;

    // Constructor, getters, and setters
    public FlightReservation(Flight flight, Seat seat, Price price, Client client) {
        this.flight = flight;
        this.seat = seat;
        this.price = price;
        this.client = client;
    }

    public Flight getFlight() { return flight; }
    public Seat getSeat() { return seat; }
    public Price getPrice() { return price; }
    public Client getClient() { return client; }
}