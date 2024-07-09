//izzamer bin baharuddin 22005742

package com.explaination.Client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class ClientGUI {
    private JFrame frame;
    private JTextField nameField;
    private JTextField phoneNumberField;
    private DefaultListModel<FlightReservation> reservationListModel;
    private JList<FlightReservation> reservationList;
    private JButton addButton;
    private JButton removeButton;

    public ClientGUI() {
        frame = new JFrame("Client GUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        
        JPanel clientPanel = new JPanel();
        clientPanel.setLayout(new GridLayout(2, 2));
        clientPanel.add(new JLabel("Name:"));
        nameField = new JTextField();
        clientPanel.add(nameField);
        clientPanel.add(new JLabel("Phone Number:"));
        phoneNumberField = new JTextField();
        clientPanel.add(phoneNumberField);

        
        JPanel reservationPanel = new JPanel();
        reservationPanel.setLayout(new BorderLayout());
        reservationListModel = new DefaultListModel<>();
        reservationList = new JList<>(reservationListModel);
        reservationList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        reservationPanel.add(new JScrollPane(reservationList), BorderLayout.CENTER);

        
        JPanel buttonPanel = new JPanel();
        addButton = new JButton("Add Reservation");
        addButton.addActionListener(new AddButtonListener());
        buttonPanel.add(addButton);
        removeButton = new JButton("Remove Reservation");
        removeButton.addActionListener(new RemoveButtonListener());
        buttonPanel.add(removeButton);

        
        frame.add(clientPanel, BorderLayout.NORTH);
        frame.add(reservationPanel, BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        frame.pack();
        frame.setVisible(true);
    }

    private class AddButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String flightNumber = JOptionPane.showInputDialog(frame, "Enter flight number:");
            String departureDate = JOptionPane.showInputDialog(frame, "Enter departure date:");
            String arrivalDate = JOptionPane.showInputDialog(frame, "Enter arrival date:");
            FlightReservation reservation = new FlightReservation(flightNumber, departureDate, arrivalDate);
            reservationListModel.addElement(reservation);
        }
    }

    private class RemoveButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int selectedIndex = reservationList.getSelectedIndex();
            if (selectedIndex != -1) {
                reservationListModel.remove(selectedIndex);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ClientGUI();
            }
        });
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

    @Override
    public String toString() {
        return "Flight " + flightNumber + " - Departure: " + departureDate + ", Arrival: " + arrivalDate;
    }
}