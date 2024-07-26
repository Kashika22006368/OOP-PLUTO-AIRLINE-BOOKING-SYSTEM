//seatGUI
// Puvandraan Wilson 22002099


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class SeatGUI {
    private JFrame frame;
    private JTextField numberField;
    private JTextField clientField;
    private JCheckBox statusCheckBox;
    private JTextArea outputArea;
    private List<Seat> seats;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                SeatGUI window = new SeatGUI();
                window.frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public SeatGUI() {
        seats = new ArrayList<>();
        initialize();
    }

    private void initialize() {
        frame = new JFrame("Seat Management System");
        frame.setBounds(100, 100, 500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel();
        frame.getContentPane().add(inputPanel, BorderLayout.NORTH);
        inputPanel.setLayout(new GridLayout(3, 2, 5, 5));

        inputPanel.add(new JLabel("Seat Number:"));
        numberField = new JTextField();
        inputPanel.add(numberField);

        inputPanel.add(new JLabel("Client:"));
        clientField = new JTextField();
        inputPanel.add(clientField);

        inputPanel.add(new JLabel("Status (Booked):"));
        statusCheckBox = new JCheckBox();
        inputPanel.add(statusCheckBox);

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
        String number = numberField.getText();
        String client = clientField.getText();
        boolean status = statusCheckBox.isSelected();

        if (number.isEmpty() || client.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Please enter both seat number and client.");
            return;
        }

        seats.add(new Seat(number, status, client));
        numberField.setText("");
        clientField.setText("");
        statusCheckBox.setSelected(false);
        updateOutput();
    }

    private void handleRemoveSeat() {
        String number = numberField.getText();

        if (number.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Please enter a seat number.");
            return;
        }

        seats.removeIf(seat -> seat.getNumber().equals(number));
        numberField.setText("");
        updateOutput();
    }

    private void updateOutput() {
        outputArea.setText("Current seats:\n");
        for (Seat seat : seats) {
            outputArea.append(seat + "\n");
        }
    }
}

class Seat {
    private String number;
    private boolean status;
    private String client;

    public Seat(String number, boolean status, String client) {
        this.number = number;
        this.status = status;
        this.client = client;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    @Override
    public String toString() {
        return "Seat{" +
                "number='" + number + '\'' +
                ", status=" + status +
                ", client='" + client + '\'' +
                '}';
    }
}