package w1830958.CourseWork;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ConsultGUI extends JFrame {

    private Consultation consult = new Consultation();
    private Patient patient = new Patient();
    private ArrayList<Doctor> doctorList;
    private Doctor doctor;
    private JPanel contain1 = new JPanel(new GridLayout(10, 2, 20, 20));
    private JTextField fnField, snField, dobField, pnField, noteField;
    private JComboBox<String> dateCombo, timeCombo;
    private JLabel costLabel;
    private JButton cancelBtn, saveBtn;

    public JFrame frame;

    public ConsultGUI(Doctor doctor, WestminsterSkinConsultationManager manager, int rowNum) {
        this.doctor = doctor;
        this.doctorList = manager.getDoctorList();

        setupFrame();
        setupComponents();
        setupActions();
    }

    private void setupFrame() {
        frame = new JFrame("Consultation Booking");
        contain1.setBorder(new EmptyBorder(10, 20, 20, 20));
        contain1.setBackground(new Color(43, 174, 102));
        frame.add(contain1);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    private void setupComponents() {
        Font labelFont = new Font("SansSerif", Font.BOLD, 20);

        fnField = new JTextField();
        snField = new JTextField();
        dobField = new JTextField();
        pnField = new JTextField();
        noteField = new JTextField();
        dateCombo = new JComboBox<>(generateDateOptions());
        timeCombo = new JComboBox<>(generateTimeOptions());
        costLabel = new JLabel("Cost: " + consult.getCost());

        cancelBtn = new JButton("Cancel");
        saveBtn = new JButton("Save");

        addLabeledComponent("First Name:", fnField, labelFont);
        addLabeledComponent("Last Name:", snField, labelFont);
        addLabeledComponent("Date of Birth:", dobField, labelFont);
        addLabeledComponent("Phone Number:", pnField, labelFont);
        addLabeledComponent("Booking Date:", dateCombo, labelFont);
        addLabeledComponent("Booking Time:", timeCombo, labelFont);
        addLabeledComponent("Notes:", noteField, labelFont);
        contain1.add(costLabel);
        contain1.add(new JLabel());
        contain1.add(cancelBtn);
        contain1.add(saveBtn);
    }

    private void addLabeledComponent(String label, JComponent component, Font font) {
        JLabel lbl = new JLabel(label);
        lbl.setFont(font);
        component.setFont(font);
        contain1.add(lbl);
        contain1.add(component);
    }

    private void setupActions() {
        cancelBtn.addActionListener(e -> frame.dispose());

        saveBtn.addActionListener(e -> {
            if (validateInput()) {
                Doctor availableDoctor = findAvailableDoctor(consult.getDate(), consult.getBooking());
                if (availableDoctor != null) {
                    consult.setPatient(patient);  // Assign the patient to the consultation
                    consult.setCost(25);  // Set cost or calculate dynamically
                    availableDoctor.getAppointmentList().add(consult);  // Add consultation to available doctor

                    JOptionPane.showMessageDialog(this, "Booking successful with Dr. " +
                            availableDoctor.getFirstName() + " " + availableDoctor.getSurName());
                    frame.dispose();
                } else {
                    JOptionPane.showMessageDialog(this, "No doctors available at the selected time.");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Error in the input. Please fix and try again.");
            }
        });
    }

    // Finds an available doctor for the given date and time
    private Doctor findAvailableDoctor(Date date, Time time) {
        for (Doctor doc : doctorList) {
            if (doc.isAvailable(date, time)) {
                return doc;  // Found an available doctor
            }
        }
        return null;  // No available doctors
    }

    private boolean validateInput() {
        // Add validation logic for the form inputs
        return true;  // Simplified for brevity
    }

    private String[] generateDateOptions() {
        return new String[]{"27/09/2024", "28/09/2024", "29/09/2024"};
    }

    private String[] generateTimeOptions() {
        return new String[]{"08:00", "09:00", "10:00", "11:00", "12:00"};
    }
}
