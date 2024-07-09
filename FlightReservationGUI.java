package com.example.FlightReservation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

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
    private JTextField priceAmountField;
    private JTextField priceCurrencyField;
    private JTextField clientNameField;
    private JTextField clientPassportNumberField;
    private JTextField clientContactDetailsField;

    public FlightReservationGUI() {
        frame = new JFrame("Flight Reservation System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        JPanel flightPanel = new JPanel();
        flightPanel.setBorder(BorderFactory.createTitledBorder("Flight Information"));
        flightPanel.setLayout(new GridLayout(5, 2));
        flightPanel.add(new JLabel("Flight Number:"));
        flightNumberField = new JTextField();
        flightPanel.add(flightNumberField);
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

        JPanel seatPanel = new JPanel();
        seatPanel.setBorder(BorderFactory.createTitledBorder("Seat Information"));
        seatPanel.setLayout(new GridLayout(3, 2));
        seatPanel.add(new JLabel("Seat Number:"));
        seatNumberField = new JTextField();
        seatPanel.add(seatNumberField);
        seatPanel.add(new JLabel("Class Type:"));
        classTypeField = new JTextField();
        seatPanel.add(classTypeField);
        seatPanel.add(new JLabel("Is Available:"));
        isAvailableCheckBox = new JCheckBox();
        seatPanel.add(isAvailableCheckBox);

        JPanel pricePanel = new JPanel();
        pricePanel.setBorder(BorderFactory.createTitledBorder("Price Information"));
        pricePanel.setLayout(new GridLayout(2, 2));
        pricePanel.add(new JLabel("Price Amount:"));
        priceAmountField = new JTextField();
        pricePanel.add(priceAmountField);
        pricePanel.add(new JLabel("Price Currency:"));
        priceCurrencyField = new JTextField();
        pricePanel.add(priceCurrencyField);

        JPanel clientPanel = new JPanel();
        clientPanel.setBorder(BorderFactory.createTitledBorder("Client Information"));
        clientPanel.setLayout(new GridLayout(3, 2));
        clientPanel.add(new JLabel("Client Name:"));
        clientNameField = new JTextField();
        clientPanel.add(clientNameField);
        clientPanel.add(new JLabel("Client Passport Number:"));
        clientPassportNumberField = new JTextField();
        clientPanel.add(clientPassportNumberField);
        clientPanel.add(new JLabel("Client Contact Details:"));
        clientContactDetailsField = new JTextField();
        clientPanel.add(clientContactDetailsField);

        JPanel buttonPanel = new JPanel();
        JButton reserveButton = new JButton("Reserve");
        reserveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Flight flight = new Flight(flightNumberField.getText(), departureField.getText(), destinationField.getText(), departureTimeField.getText(), arrivalTimeField.getText());
                Seat seat = new Seat(seatNumberField.getText(), classTypeField.getText(), isAvailableCheckBox.isSelected());
                Price price = new Price(Double.parseDouble(priceAmountField.getText()), priceCurrencyField.getText());
                Client client = new Client(clientNameField.getText(), clientPassportNumberField.getText(), clientContactDetailsField.getText());
                FlightReservation reservation = new FlightReservation(flight, seat, price, client);

                // Add reservation to database or perform other necessary actions
                System.out.println("Reservation made successfully!");
            }
        });
        buttonPanel.add(reserveButton);

        JButton cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Clear all fields
                flightNumberField.setText("");
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
            }
        });
        buttonPanel.add(cancelButton);

        frame.add(flightPanel, BorderLayout.NORTH);
        frame.add(seatPanel, BorderLayout.CENTER);
        frame.add(pricePanel, BorderLayout.EAST);
        frame.add(clientPanel, BorderLayout.SOUTH);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new FlightReservationGUI();
            }
        });
    }
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