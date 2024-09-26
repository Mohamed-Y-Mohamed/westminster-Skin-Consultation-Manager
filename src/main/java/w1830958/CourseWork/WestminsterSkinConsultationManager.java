package w1830958.CourseWork;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class WestminsterSkinConsultationManager implements SkinConsultationManager {

    private ArrayList<Doctor> doctorList;

    public WestminsterSkinConsultationManager() {
        doctorList = new ArrayList<>();
    }

    public ArrayList<Doctor> getDoctorList() {
        return doctorList;
    }

    @Override
    public void addDoctors(Doctor doctor) {
        if (doctorList.size() < 10) { // Example capacity
            doctorList.add(doctor);
            System.out.println("Doctor has been added to the list.");
        } else {
            System.out.println("List is full. Cannot add more doctors.");
        }
    }

    public void deleteDoctor(int medicalLicenseNumber) {
        Doctor doctorToDelete = null;
        for (Doctor doctor : doctorList) {
            if (doctor.getMLN() == medicalLicenseNumber) {
                doctorToDelete = doctor;
                break;
            }
        }

        if (doctorToDelete != null) {
            doctorList.remove(doctorToDelete);
            System.out.println("Doctor has been removed from the list.");
        } else {
            System.out.println("Doctor with the given license number not found.");
        }
    }

    @Override
    public void Display() {
        Collections.sort(doctorList);
        if (!doctorList.isEmpty()) {
            for (Doctor doctor : doctorList) {
                System.out.println(doctor.toString());
            }
        } else {
            System.out.println("Doctor list is empty.");
        }
    }

    public void saveDoctorList() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("doctors.csv"))) {
            for (Doctor doctor : doctorList) {
                writer.write(String.format("%s,%s,%s,%s,%s,%d\n",
                        doctor.getFirstName(),
                        doctor.getSurName(),
                        doctor.getDateOfBirth(),
                        doctor.getPhoneNumber() != null ? doctor.getPhoneNumber().toString() : "N/A", // Handling null phone numbers
                        doctor.getSpecialisation(),
                        doctor.getMLN()));
            }
            System.out.println("Doctor list saved successfully.");
        } catch (IOException e) {
            System.out.println("Error saving doctor list: " + e.getMessage());
        }
    }

    public void loadDoctorList() {
        try (BufferedReader reader = new BufferedReader(new FileReader("doctors.csv"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                Doctor doctor = new Doctor();
                doctor.setFirstName(data[0]);
                doctor.setSurName(data[1]);
                doctor.loadsetDateOfBirth(data[2]);
                doctor.loadPhoneNumber(data[3]);
                doctor.loadSpecialisation(data[4]);
                doctor.setMLN(Integer.parseInt(data[5]));
                doctorList.add(doctor);
            }
            System.out.println("Doctor list loaded successfully.");
        } catch (IOException e) {
            System.out.println("Error loading doctor list: " + e.getMessage());
        }
    }

    @Override
    public void menu() {
        System.out.println("1: Input a doctor");
        System.out.println("2: Delete a doctor");
        System.out.println("3: Display doctor list");
        System.out.println("4: Save doctor list");
        System.out.println("5: Load doctor list");
        System.out.println("6: Run GUI");
        System.out.println("7: Exit");
    }

    public static void main(String[] args) {
        WestminsterSkinConsultationManager manager = new WestminsterSkinConsultationManager();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            manager.menu();
            System.out.println("Enter your choice:");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1 -> {
                    Doctor doctor = new Doctor();
                    System.out.println("Enter doctor's first name:");
                    doctor.setFirstName(scanner.nextLine());
                    System.out.println("Enter doctor's last name:");
                    doctor.setSurName(scanner.nextLine());
                    System.out.println("Enter doctor's date of birth (dd/MM/yyyy):");
                    doctor.loadsetDateOfBirth(scanner.nextLine());
                    System.out.println("Enter doctor's phone number:");
                    doctor.loadPhoneNumber(scanner.nextLine());
                    System.out.println("Enter doctor's specialization:");
                    doctor.loadSpecialisation(scanner.nextLine());
                    System.out.println("Enter doctor's medical license number:");
                    doctor.setMLN(scanner.nextInt());
                    manager.addDoctors(doctor);
                }
                case 2 -> {
                    System.out.println("Enter the medical license number of the doctor to delete:");
                    int medicalLicenseNumber = scanner.nextInt();
                    manager.deleteDoctor(medicalLicenseNumber);
                }
                case 3 -> manager.Display();
                case 4 -> manager.saveDoctorList();
                case 5 -> manager.loadDoctorList();
                case 6 -> {
                    GUI gui = new GUI(manager);
                    gui.RunTable(manager);
                }
                case 7 -> {
                    System.out.println("Exiting the program.");
                    System.exit(0);
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
