//seatsGUI
//JEEVANATHAN A/L ARUMUGAM 22005408

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

class Seats {
    private List<String> seats;

    public Seats() {
        seats = new ArrayList<>();
    }

    public void addSeat(String seat) {
        if (!seats.contains(seat)) {
            seats.add(seat);
        } else {
            System.out.println("Seat " + seat + " is already taken.");
        }
    }

    public void removeSeat(String seat) {
        if (seats.contains(seat)) {
            seats.remove(seat);
        } else {
            System.out.println("Seat " + seat + " does not exist.");
        }
    }

    public void printSeats() {
        System.out.println("Current seats:");
        for (String seat : seats) {
            System.out.println(seat);
        }
    }

    public boolean findSeat(String seat) {
        return seats.contains(seat);
    }

    public List<String> getSeats() {
        return seats;
    }
}

public class SeatsGUI {

    private JFrame frame;
    private JTextField seatField;
    private JTextArea outputArea;
    private Seats seats;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                SeatsGUI window = new SeatsGUI();
                window.frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public SeatsGUI() {
        seats = new Seats();
        initialize();
    }

    private void initialize() {
        frame = new JFrame("Seats Management System");
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel();
        frame.getContentPane().add(inputPanel, BorderLayout.NORTH);
        inputPanel.setLayout(new GridLayout(2, 2, 5, 5));

        inputPanel.add(new JLabel("Seat:"));
        seatField = new JTextField();
        inputPanel.add(seatField);

        JButton btnAddSeat = new JButton("Add Seat");
        inputPanel.add(btnAddSeat);

        JButton btnRemoveSeat = new JButton("Remove Seat");
        inputPanel.add(btnRemoveSeat);

        outputArea = new JTextArea();
        outputArea.setEditable(false);
        frame.getContentPane().add(new JScrollPane(outputArea), BorderLayout.CENTER);

        btnAddSeat.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                handleAddSeat();
            }
        });

        btnRemoveSeat.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                handleRemoveSeat();
            }
        });
    }

    private void handleAddSeat() {
        String seat = seatField.getText();
        if (seat.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Please enter a seat number.");
            return;
        }
        seats.addSeat(seat);
        seatField.setText("");
        updateOutput();
    }

    private void handleRemoveSeat() {
        String seat = seatField.getText();
        if (seat.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Please enter a seat number.");
            return;
        }
        seats.removeSeat(seat);
        seatField.setText("");
        updateOutput();
    }

    private void updateOutput() {
        outputArea.setText("Current seats:\n");
        for (String seat : seats.getSeats()) {
            outputArea.append(seat + "\n");
        }
    }
}