/**
 * @author Mohamed Mohamed
 * id number:w18309586
 */
package w1830958.CourseWork;
//imported statements

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

//Main class with ArrayList for Doctor List
public class WestminsterSkinConsultationManager implements SkinConsultationManager {

    private ArrayList<Doctor> DoctorList;

    public WestminsterSkinConsultationManager() {
        DoctorList = new ArrayList<>();
    }
    //getter and setter for ArrayList

    public ArrayList<Doctor> getDoctorList() {
        return DoctorList;
    }

    public void setDoctorList(ArrayList<Doctor> DoctorList) {
        this.DoctorList = DoctorList;
    }

    //addDoctor method to allow the pbject doctor to be added to array when choice 1 selected
    @Override
    public void addDoctors(Doctor doctor) {
        int count = 10;
        if (DoctorList.size() < count) {
            DoctorList.add(doctor);
        } else {
            System.out.println("list is full.");
        }
    }

    //Display method to display the content of array when choice 3 selected.
    @Override
    public void Display() {
        Collections.sort(DoctorList);
        if (!DoctorList.isEmpty()) {
            for (Doctor doctor : DoctorList) {

                System.out.println(doctor.toString());
            }
        } else {
            System.out.println("List is empty ");
        }

    }

    //        menu of choices to be printed when program run
    @Override
    public void menu() {
        System.out.println("1:  Input a doctor information.");
        System.out.println("2:  Delete a doctor information.");
        System.out.println("3:  Display a list of doctors information.");
        System.out.println("4:  Store a doctors information to text file.");
        System.out.println("5:  Retrieve a doctors information privously stored to text file.");
        System.out.println("6:  Run GUI to print list of doctor on table.");
        System.out.println("7:  Run GUI for booked Appointments with doctors.");
        System.out.println("8:  Terminate the program.");

    }

    //main program run
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        //creating an instance of ArrayList that is created above the main
        WestminsterSkinConsultationManager doctorList = new WestminsterSkinConsultationManager();
        //boolean for loop to initalsation to run the switch as many as needed.
        boolean loop = false;

//        //while loop initialisation
        while (!loop) {
//            //Scanner to get inputs
//            //creating an instance of doctor object
            Doctor doctor = new Doctor();

//            //creating an instance of GUI class
//
            try {  //try error handling setting
                doctorList.menu();
                System.out.println("enter a number representing one of the choices.");
//                //integer value to collect choice selected for menu
                int input = Integer.parseInt(in.nextLine());
//                //switch case to process the input choice selected by user.
                switch (input) {
                    //Case numbers and task to be completed when number entered by user

                    case 1 -> {
                        doctor.Add(doctorList, doctor);
                        System.out.println("Doctor has been added to the list.");

                    }
                    case 2 ->
                        doctor.Delete(in, doctorList);
                    case 3 ->
                        doctorList.Display();
                    case 4 ->
                        doctor.save(doctorList);
                    case 5 ->
                        doctor.load(doctorList);
                    case 6 -> {
                        GUI gui = new GUI(doctorList);
                        gui.RunTable(doctorList);
                    }
                    case 7 -> {
                        PrintAppointments printAppoitments=new PrintAppointments(doctorList.getDoctorList());
                        printAppoitments.run(doctorList.getDoctorList());

                    }
                    case 8 ->{
                        System.exit(0);}
                    default ->
                        System.out.println("invalid input try again.");
                }
//catch to catch any number format error type entered by user.
            } catch (NumberFormatException ex) {
                System.out.println("the input is not an number. please enter a number.");
            }
        }

    }

}
