package w1830958.CourseWork;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class GUI extends AbstractTableModel {
    ArrayList<Doctor> DoctorArray;
    private final String[] columnNames = {"First Name", "Last Name", "Date of Birth", "Phone Number", "Specialisation", "Medical license number"};

    // Constructor
    public GUI(WestminsterSkinConsultationManager DoctorList) {
        DoctorArray = DoctorList.getDoctorList();
    }

    @Override
    public int getRowCount() {
        return DoctorArray.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Object temp = null;

        switch (columnIndex) {
            case 0 -> temp = DoctorArray.get(rowIndex).getFirstName();
            case 1 -> temp = DoctorArray.get(rowIndex).getSurName();
            case 2 -> temp = DoctorArray.get(rowIndex).getDateOfBirth();
            case 3 -> temp = DoctorArray.get(rowIndex).getPhoneNumber();
            case 4 -> temp = DoctorArray.get(rowIndex).getSpecialisation();
            case 5 -> temp = DoctorArray.get(rowIndex).getMLN();
        }
        return temp;
    }

    @Override
    public String getColumnName(int col) {
        return columnNames[col];
    }

    public void RunTable(WestminsterSkinConsultationManager doctorList) {
        GUI tableModel = new GUI(doctorList);
        JTable myTable = new JTable(tableModel);
        JScrollPane mytable = new JScrollPane(myTable);

        JFrame myFrame = new JFrame("Doctor List");
        myFrame.add(mytable);
        myFrame.setVisible(true);
        myFrame.setSize(1200, 600);

        myTable.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = ((JTable) e.getSource()).getSelectedRow();
                Doctor doctor = doctorList.getDoctorList().get(row);

                JButton b = new JButton("Print List of Appointments");
                myFrame.add(b, BorderLayout.PAGE_END);
                b.setBackground(Color.CYAN);
                b.setPreferredSize(new Dimension(600, 50));
                myFrame.validate();

                ConsultGUI consultGUI = new ConsultGUI(doctor, doctorList, row);
                consultGUI.frame.setSize(600, 700);
                consultGUI.frame.setVisible(true);

                b.addMouseListener(new MouseListener() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        PrintAppointments printAppointments = new PrintAppointments(doctorList.getDoctorList());
                        printAppointments.run(doctorList.getDoctorList());
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
    }
}
