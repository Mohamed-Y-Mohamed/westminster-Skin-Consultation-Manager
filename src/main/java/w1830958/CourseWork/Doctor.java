/**
 * @author Mohamed Mohamed
 * id number:w18309586
 */
package w1830958.CourseWork;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;


public class Doctor extends Person implements Comparable<Doctor> {


    private String specialisation;
    private int medicalLicenceNumber;
    private ArrayList<Consultation> AppointmentList;

    public Doctor() {

        super();
        AppointmentList=new ArrayList<>();

        specialisation = null;

    }
    
       public Doctor(String fn,String sn,Date dob,Long num,String Specialisations,int MedicalLienseNumber) {

        super(fn,sn,dob,num);
        
        AppointmentList=new ArrayList<>();
        medicalLicenceNumber=MedicalLienseNumber;
        specialisation = Specialisations;

    }

    public ArrayList<Consultation> getAppointmentList() {
        return AppointmentList;
    }

    public void setAppointmentList(ArrayList<Consultation> appointmentList) {
        AppointmentList = appointmentList;
    }

    public void loadspecialisation(String specialisation){
    this.specialisation = specialisation;

}



    public void setSpecialisation() {
        String regex = "[a-zA-Z]+";

        boolean exit = false;
        while (!exit) {
            String specialisation = in.nextLine();
            if (specialisation.matches(regex)) {
                this.specialisation = specialisation;
                exit = true;
            } else {
                System.out.println("specialisation should only contain letters. try again.");
            }
        }
    }

    public void setMLN(int medicalLicenceNumber) {
        this.medicalLicenceNumber = medicalLicenceNumber;
    }

    public String getSpecialisation() {
        return specialisation;
    }

    public double getMLN() {
        return medicalLicenceNumber;
    }

    @Override
    public String toString() {
        return "Doctor Name: " + getFirstName() + " " + getSurName() + ", " + "Date of birth: " + getDateofBirth() + ", " + "Phone Number: " + getPhoneNumber() + ", "
                + "specialisation: " + specialisation + ", "
                + "medicalLicenceNumber=" + medicalLicenceNumber;
    }

    @Override
    public int compareTo(Doctor o) {
        return this.getSurName().compareTo(o.getSurName());

    }


    public void Add(WestminsterSkinConsultationManager DoctorList, Doctor doctor) {
        medicalLicenceNumber = DoctorList.getDoctorList().size() + 1;

        Scanner in = new Scanner(System.in);


        try {
            System.out.println("enter the doctor First Name?");
            doctor.setFirstName();
            System.out.println("enter the doctor Sur Name?");
            doctor.setSurName();
            doctor.setDateofBirth(new Date());
            System.out.println("enter the doctor Phone number?");
            doctor.setPhoneNumber();
            System.out.println("enter the doctor Specialisation?");
            doctor.setSpecialisation();
            DoctorList.addDoctors(doctor);
        } catch (Exception e) {
            System.out.println("invalid input type.\nPlease enter correct requirement?");
        }
    }


    public void Delete(Scanner in, WestminsterSkinConsultationManager DoctorList) {
        System.out.println("Enter the medical license number:");
        int mln = Integer.valueOf(in.nextLine());

        for (int i = 0; i < DoctorList.getDoctorList().size(); i++) {

            if (mln==(DoctorList.getDoctorList().get(i).getMLN()))  {
                System.out.println("doctor you lookng for is found.\n");
                DoctorList.getDoctorList().remove(i);
                System.out.println("the doctor has been removed.\n\n");
                break;
            } else if (mln!=DoctorList.getDoctorList().get(i).getMLN() && i == DoctorList.getDoctorList().size()) {
                System.out.println("name not found.");
            }
        }
    }


    public void save(WestminsterSkinConsultationManager DoctorList) {
        try {
//            FileOutputStream fileDistinction = new FileOutputStream("saveDoctor.csv");
            BufferedWriter saveOb = new BufferedWriter(new FileWriter("saveDoctor.csv"));
            if (DoctorList.getDoctorList().size() > 0) {
                for (int i = 0; i < DoctorList.getDoctorList().size(); i++) {

                    saveOb.write(DoctorList.getDoctorList().get(i).getFirstName() + "," + DoctorList.getDoctorList().get(i).getSurName() + "," + String.valueOf(DoctorList.getDoctorList().get(i).getDateofBirth()) + "," + String.valueOf(DoctorList.getDoctorList().get(i).getPhoneNumber()) + ","
                            + DoctorList.getDoctorList().get(i).getSpecialisation() + ","
                            + String.valueOf(DoctorList.getDoctorList().get(i).getMLN()) + "\n");
                    saveOb.flush();
                }

                System.out.println("save has been completed");
            } else {
                System.out.println("there is no data to store. ");
            }

        } catch (IOException e) {
            System.out.println("io exception.");

        }
    }

    public void load(WestminsterSkinConsultationManager DoctorList) {


        String line;
        String spliter = ",";
        String[] employee;
        try {
            BufferedReader br = new BufferedReader(new FileReader("saveDoctor.csv"));
            boolean retireveconfirm = false;
            while ((line = br.readLine()) != null) {

                employee = line.split(spliter);
                Doctor doctor = new Doctor();

                String fn = employee[0];
                doctor.LoadsetFirstName(fn);
                String sn = employee[1];
                doctor.LoadsetSurName(sn);

                String Date = employee[2];

                doctor.loadsetDateofBirth(Date);

                doctor.loadPhoneNumber(employee[3]);

                doctor.loadspecialisation(employee[4]);
                double sMLN = Double.valueOf(employee[5]);


                doctor.setMLN((int) sMLN);
                DoctorList.addDoctors(doctor);
                retireveconfirm = true;
            }
            if (retireveconfirm) {
                System.out.println("data has been retireved");
            } else {
                System.out.println("there is no data to retireve from file.");
            }


        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        } catch (IOException e) {
            System.out.println("unable to load file.");
        }

    }
}

