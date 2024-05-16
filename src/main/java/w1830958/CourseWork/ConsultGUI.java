
/**
 * @author Mohamed Mohamed
 * id number:w18309586
 */

package w1830958.CourseWork;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;

public final class ConsultGUI extends JFrame {

    JFrame frame = new JFrame("Booking");
    Consultation consult = new Consultation();
    Patient p = new Patient();
    JPanel contain1 = new JPanel();
    private final JLabel PID;// Declare component JLabel
    private final JLabel FirstName;      // Declare component JLabel
    private final JTextField FN;  // Declare component JTextField
    private final JLabel SurName;      // Declare component JLabel
    private final JTextField SN; // Declare component JTextField
    private final JLabel DOB;      // Declare component JLabel
    private final JTextField dob; // Declare component JTextField
    private final JLabel PhoneNumber;    // Declare component JLabel
    private final JTextField PN; // Declare component JTextField
    private final JLabel Date;    // Declare component JLabel
    private final JComboBox<String> date; // Declare component JTextField
    private final JLabel Time;    // Declare component JLabel
    private final JComboBox<String> time; // Declare component JTextField
    private final JLabel Note;    // Declare component JLabel
    private final JTextField note; // Declare component JTextField
    private final JLabel Space2;// Declare component JLabel
    private final JLabel Cost;    // Declare component JLabel
    private final JButton Cancel;    // Declare component JButton
    private final JButton Save;    // Declare component JButton
    int num;

    ArrayList<Doctor> doclist;  //constructor for Consult GUI
    Doctor doc = new Doctor();

    ConsultGUI(Doctor doctor, WestminsterSkinConsultationManager doctorlist, int row) {
        doc = doctor;
        num = row;

        doclist = doctorlist.getDoctorList();
        //gred layout
        contain1.setLayout(new GridLayout(10, 2, 20, 20));
        //setting the border space to each side of the panels
        contain1.setBorder(new EmptyBorder(10, 20, 20, 20));

        Color IslandGreen = new Color(43, 174, 102);

        contain1.setBackground(IslandGreen);

//font initialisation
        Font font1 = new Font("SansSerif", Font.BOLD, 20);
        //component Initialization
        PID = new JLabel("Patient ID number: " + p.getID());

        JLabel Space1 = new JLabel();//this to set an empty label to fill the space next to PID Label
        FirstName = new JLabel("First Name:");
        FN = new JTextField();

        SurName = new JLabel("Last Name: ");
        SN = new JTextField();
        DOB = new JLabel("Date Of Birth: ");

        dob = new JTextField();
        dob.addActionListener((ActionEvent e) -> {
            JOptionPane.showMessageDialog(dob, "Enter date of birth in this format: dd/mm/yyyy with the / sign seperating each date.");
        });

        PhoneNumber = new JLabel("Patient Phone number:");
        PN = new JTextField();
        Date = new JLabel("Select Booking Date:");
        date = new JComboBox<>(generateDate());

        Time = new JLabel("Select Booking Time:");
        time = new JComboBox<>(generateTime());

        time.setMaximumSize(time.getPreferredSize());
        Note = new JLabel("Additional note:");
        note = new JTextField();
        Space2 = new JLabel();//this to set an empty label to fill the space next to PID Label

        Cost = new JLabel("Cost: " + consult.getCost());
        Cancel = new JButton("Cancel");
        Save = new JButton("Confirm");

        //adding font to components
        FirstName.setFont(font1);
        SurName.setFont(font1);
        PhoneNumber.setFont(font1);
        DOB.setFont(font1);
        FN.setFont(font1);
        SN.setFont(font1);
        dob.setFont(font1);
        PN.setFont(font1);
        Date.setFont(font1);
        date.setFont(font1);
        Time.setFont(font1);
        time.setFont(font1);
        Note.setFont(font1);
        note.setFont(font1);
        Cost.setFont(font1);

        //adding component to panel then adding panel to frame
        contain1.add(PID);
        contain1.add(Space1);
        contain1.add(FirstName);
        contain1.add(FN);
        contain1.add(SurName);
        contain1.add(SN);
        contain1.add(DOB);
        contain1.add(dob);
        contain1.add(PhoneNumber);
        contain1.add(PN);
        contain1.add(Date);
        contain1.add(date);
        contain1.add(Time);
        contain1.add(time);
        contain1.add(Note);
        contain1.add(note);
        contain1.add(Cost);
        contain1.add(Space2);

        Cancel.addActionListener((ActionEvent e) -> {
            frame.dispose();
        });
        contain1.add(Cancel, BorderLayout.PAGE_END);
        contain1.add(Save, BorderLayout.PAGE_END);
        frame.add(contain1);


        Save.addActionListener(new ActionListenerImpl(consult));
    }


    //generate date for combobox booking date
    public String[] generateDate() {
        String[] choice = new String[7];
        LocalDate d = LocalDate.now();
        int Year = d.getYear();
        int Month = d.getMonth().getValue();
        int Day = d.getDayOfMonth();
        String datesetting;

        for (int i = 0; i < 7; i++) {
            if (Month < 12) {
                if (Day < 31) {
                    Day++;
                    datesetting = Day + "/" + Month + "/" + Year;
                    choice[i] = datesetting;
                } else {

                    Day = 1;
                    Month++;
                    datesetting = Day + "/" + Month + "/" + Year;
                    choice[i] = datesetting;

                }
            } else if (Month == 12) {
                if (Day < 31) {
                    Day++;
                    datesetting = Day + "/" + Month + "/" + Year;
                    choice[i] = datesetting;
                } else {
                    Day = 1;
                    Month = 1;
                    Year++;
                    datesetting = Day + "/" + Month + "/" + Year;
                    choice[i] = datesetting;
                }

            }

        }
        return choice;
    }

    //generate time for combobox booking time
    public String[] generateTime() {
        return new String[]{"08:00", "09:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00", "19:00", "20:00"};
    }
    //event handling set for the second panel which contain the booking date time, cost and notes

    private class ActionListenerImpl implements ActionListener {

        private final Consultation consult;

        public ActionListenerImpl(Consultation consult) {
            this.consult = consult;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            boolean FNValidation = false;
            boolean SNValidation = false;
            boolean DOBValidation = false;
            boolean PNInvalidation = false;
            boolean BDValidation = false;
            boolean BTValidation = false;
            boolean Notevalidation = false;

            //event handling for patient which is stored in first JPanel of the frame with green background. this part holds patient info entered.
            String regex = "[a-zA-Z]+";
            if (FN.getText().matches(regex)) {

                p.LoadsetFirstName(FN.getText());
                FN.setBorder(new LineBorder(Color.black, 1));
                FNValidation = true;
            } else {
                FN.setBorder(new LineBorder(Color.red, 3));
            }
            if (SN.getText().matches(regex)) {

                p.LoadsetSurName(SN.getText());
                SN.setBorder(new LineBorder(Color.black, 1));
                SNValidation = true;
            } else {
                SN.setBorder(new LineBorder(Color.red, 3));
            }
            if (dob.getText().matches("^\\d{2}/\\d{2}/\\d{4}$")) {
                String[] array = dob.getText().split("/");
                int day = Integer.parseInt(array[0]);

                int month = Integer.parseInt(array[1]);
                int year = Integer.parseInt(array[2]);
                if (day <= 31 && month <= 12 && year < 2023 && year > 1904) {
                    p.loadsetDateofBirth(dob.getText());
                    dob.setBorder(new LineBorder(Color.black, 1));
                    DOBValidation = true;

                } else {
                    dob.setBorder(new LineBorder(Color.red, 3));
                    JOptionPane.showMessageDialog(dob, "day is 31 and month is 12 and year range is from 1904 to 2023");

                }

            } else {
                dob.setBorder(new LineBorder(Color.red, 3));
                JOptionPane.showMessageDialog(dob, "Date of birth format is:dd/mm/yyyy");

            }

            if (PN.getText().length() == 11 && PN.getText().charAt(0) == '0' && PN.getText().charAt(1) == '7') {
                p.loadPhoneNumber(PN.getText());
                PN.setBorder(new LineBorder(Color.black, 1));
                PNInvalidation = true;
            } else {
                PN.setBorder(new LineBorder(Color.red, 3));
                JOptionPane.showMessageDialog(PN, "phone number start with 07 and has 11 digits.");
            }
            consult.setPatient(p);

            if (date.getSelectedItem() != null) {
                String d = (String) date.getSelectedItem();
                String[] a = d.split("/");
                int day = Integer.parseInt(a[0]);
                int month = Integer.parseInt(a[1]);
                int year = Integer.parseInt(a[2]);
                consult.setDate(new Date(day, month, year));
                BDValidation = true;
            } else {
                date.setBorder(new LineBorder(Color.red, 3));

            }
            if (time.getSelectedItem() != null) {
                String t = (String) time.getSelectedItem();
                String[] ArrayTime = t.split(":");
                Time time2 = new Time(Integer.parseInt(ArrayTime[1]), Integer.parseInt(ArrayTime[0]));
                consult.setBooking(time2);
                BTValidation = true;
            } else {
                time.setBorder(new LineBorder(Color.red, 3));

            }
            if (!note.getText().isEmpty()) {
                note.setBorder(new LineBorder(Color.black, 1));


                consult.setNotes(encrypt(note.getText()));
                Notevalidation = true;


            } else {
                note.setBorder(new LineBorder(Color.red, 3));

            }

            if (!CostValidate()) {
                consult.setCost(15);
            } else {
                consult.setCost(25);
            }


            if (DOBValidation && BDValidation && FNValidation && SNValidation && Notevalidation && BTValidation && PNInvalidation) {
                doc = reAllocatedDoctor(doc);
                doclist.get(num).getAppointmentList().add(consult);
                WestminsterSkinConsultationManager doctorList = new WestminsterSkinConsultationManager();
                doctorList.getDoctorList().clear();
                for (Doctor doctor : doclist) {
                    doctorList.getDoctorList().add(doctor);
                    frame.dispose();

                }


                JOptionPane.showMessageDialog(Save,  "patient Name: "+consult.getPatient().getFirstName()+ " "+consult.getPatient().getSurName()+ "Booking made on"+consult.getDate()+", At"+consult.getBooking()+"\nWith Doctor"+doc.getFirstName()+" "+doc.getSurName()+"\n Encrypted note: "+consult.getNotes()+"\ncost: £" + consult.getCost());

            } else {
                JOptionPane.showMessageDialog(Save, "an error has been made please check the format before attempting to save again.");
            }
        }
    }

    public static String encrypt(String str) {
        int code;
        String result = "";
        for (int i = 0; i < str.length(); i++) {
            code = Math.round((float) Math.random() * 8 + 1);
            result += code + Integer.toHexString(((int) str.charAt(i)) ^ code) + "-";
        }
        return result.substring(0, result.lastIndexOf("-"));
    }


    public boolean CostValidate() {
        ArrayList<Consultation> appoitment;
        boolean exit = false;
        for (Doctor doctor : doclist) {
            appoitment = new ArrayList<>(doctor.getAppointmentList());

            for (Consultation consultation : appoitment) {
                if (consultation.getPatient().getFirstName().equalsIgnoreCase(p.getFirstName()) && consultation.getPatient().getSurName().equalsIgnoreCase(p.getSurName()) && consultation.getPatient().getDateofBirth().toString().equalsIgnoreCase(p.getDateofBirth().toString())) {
                    appoitment.clear();
                    exit = true;
                    return exit;
                }
            }
        }
        return exit;
    }

    boolean resultTime=false;
    boolean resultDate=false;

    public void AppointmentValidation(Doctor doc) {


                for (int j=0;j<doclist.get(num).getAppointmentList().size();j++){
                    if (doc.getAppointmentList().get(j).getBooking().equals( consult.getBooking()) &&doc.getAppointmentList().get(j).getDate().equals( consult.getDate()))
                    {
                        resultDate = true;
                        resultTime = true;
                        break;

                    }

            }
        }


    public Doctor reAllocatedDoctor(Doctor doc) {
        AppointmentValidation( doc);
        for (Doctor doctor : doclist) {
            if (doctor.equals(doc) && resultDate&&resultTime) {
                for (Doctor value : doclist) {
                    if (!value.equals(doc)) {
                        doc = value;
                        JOptionPane.showMessageDialog(null,"Appoitment is not availible with this doctor.");

                        JOptionPane.showMessageDialog(null,"new Doctor has been assigned.");
                        return doc;
                    }
                }
            } else {
                if (doctor.equals(doc) && (!resultTime ||!resultDate)) {
                    return doc;
                }
            }
        }
        return doc;
    }

}



