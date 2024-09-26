package w1830958.CourseWork;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class PrintAppointments extends AbstractTableModel {

    ArrayList<Doctor> doctorList;
    private final String[] columnNames = {"Doctor Full Name", "Medical License Number", "Consultations"};

    // Constructor
    public PrintAppointments(ArrayList<Doctor> doctorList) {
        this.doctorList = doctorList;
    }

    @Override
    public int getRowCount() {
        return doctorList.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Doctor doctor = doctorList.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return doctor.getFirstName() + " " + doctor.getSurName();
            case 1:
                return doctor.getMLN();
            case 2:
                return doctor.getAppointmentList().toString(); // Adjust this as needed
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int col) {
        return columnNames[col];
    }

    public void run(ArrayList<Doctor> doctorList) {
        JFrame frame = new JFrame("Doctor Appointments");
        PrintAppointments tableModel = new PrintAppointments(doctorList);
        JTable myTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(myTable);
        frame.add(scrollPane);

        JButton decryptButton = new JButton("Decrypt Note");
        frame.add(decryptButton, BorderLayout.PAGE_END);
        decryptButton.setPreferredSize(new Dimension(600, 50));
        decryptButton.setBackground(Color.CYAN);

        decryptButton.addMouseListener(new MouseListener() {
            private boolean isDecrypted = false;

            @Override
            public void mouseClicked(MouseEvent e) {
                if (!isDecrypted) {
                    decryptNotes();
                    frame.dispose();
                    run(doctorList);
                    JOptionPane.showMessageDialog(null, "Notes decrypted.");
                    isDecrypted = true;
                } else {
                    JOptionPane.showMessageDialog(null, "Already decrypted.");
                }
            }



            // In PrintAppointments class
            private void decryptNotes() {
                for (Doctor doctor : doctorList) {
                    for (Consultation consultation : doctor.getAppointmentList()) {
                        String decryptedNote = decrypt(consultation.getNotes());
                        consultation.setNotes(decryptedNote);  // Replace the encrypted note with the decrypted version
                    }
                }
            }

            // Decrypt method that reverses the encryption
            private String decrypt(String encryptedText) {
                StringBuilder decrypted = new StringBuilder();
                int key = 5;  // Same key that was used for encryption

                for (int i = 0; i < encryptedText.length(); i++) {
                    char decryptedChar = (char) (encryptedText.charAt(i) ^ key);  // XOR again with the same key
                    decrypted.append(decryptedChar);  // Append decrypted character
                }

                return decrypted.toString();  // Return the decrypted string
            }


            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });

        frame.setSize(1400, 700);
        frame.setVisible(true);
    }
}

