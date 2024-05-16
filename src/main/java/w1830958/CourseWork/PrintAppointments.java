/**
 * @author Mohamed Mohamed
 * id number:w18309586
 */
package w1830958.CourseWork;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class PrintAppointments extends AbstractTableModel {

    ArrayList<Doctor> Doctorlist;
    int count = 0;

    private final String[] columnNames = {"Doctor Full Name", "Doctor Medical license number", "Consultations"};

    //contractor
    public PrintAppointments(ArrayList<Doctor> doctorlist) {
        Doctorlist = doctorlist;
    }

    @Override
    public int getRowCount() {
        return Doctorlist.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Object temp = "list is empty";
        switch (columnIndex) {
            case 0:
                temp = Doctorlist.get(rowIndex).getFirstName() + " " + Doctorlist.get(rowIndex).getSurName();
                break;
            case 1:
                temp = Doctorlist.get(rowIndex).getMLN();
                break;
            case 2:
                temp = Doctorlist.get(rowIndex).getAppointmentList();

        }
        return temp;

    }

    public String getColumnName(int col) {
        return columnNames[col];
    }

    public void run(ArrayList<Doctor> doctolist) {
        JFrame frame1 = new JFrame();
        PrintAppointments tableModel = new PrintAppointments(doctolist);
        JTable myTable = new JTable(tableModel);
        JScrollPane mytable = new JScrollPane(myTable);
        frame1.add(mytable);
        JButton button = new JButton("Decrypt note");
        button.setSize(1400, 50);
        button.setBackground(Color.CYAN);
        frame1.add(button, BorderLayout.PAGE_END);
        button.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (count < 1) {

                    decrypt();
                    frame1.dispose();
                    count++;
                    tableModel.run(doctolist);
                    JOptionPane.showMessageDialog(button, "data has been decrypted.");

                } else {
                    JOptionPane.showMessageDialog(button, "date already decrypted.");
                }
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
        frame1.setSize(1400, 700);
        frame1.setVisible(true);
    }

    public void decrypt() {

        for (int i = 0; i < Doctorlist.size(); i++) {
            for (int j = 0; j < Doctorlist.get(i).getAppointmentList().size(); j++) {
                String note = decrypt(Doctorlist.get(i).getAppointmentList().get(j).getNotes());

                Doctorlist.get(i).getAppointmentList().get(j).setNotes(note);
            }
        }
    }

    public static String decrypt(String str) {

        str = str.replace("-", "");
        String result = "";
        try {
            for (int i = 0; i < str.length(); i += 3) {
                String hex = str.substring(i + 1, i + 3);
                result += (char) (Integer.parseInt(hex, 16) ^ (Integer.parseInt(String.valueOf(str.charAt(i)))));
            }
        } catch (Exception e) {
            System.out.println();
        }
        return result;
    }

}
