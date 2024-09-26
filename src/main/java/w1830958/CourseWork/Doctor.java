package w1830958.CourseWork;

import java.util.ArrayList;

public class Doctor extends Person implements Comparable<Doctor> {

    private String specialization;
    private int medicalLicenseNumber;
    private ArrayList<Consultation> appointmentList;

    public Doctor() {
        super();
        this.appointmentList = new ArrayList<>();
    }

    public Doctor(String fn, String sn, Date dob, Long pn, String specialization, int licenseNumber) {
        super(fn, sn, dob, pn);
        this.specialization = specialization;
        this.medicalLicenseNumber = licenseNumber;
        this.appointmentList = new ArrayList<>();
    }

    public ArrayList<Consultation> getAppointmentList() {
        return appointmentList;
    }

    public String getSpecialisation() {
        return specialization;
    }

    public void loadSpecialisation(String specialization) {
        this.specialization = specialization;
    }

    public void setMLN(int medicalLicenseNumber) {
        this.medicalLicenseNumber = medicalLicenseNumber;
    }

    public int getMLN() {
        return medicalLicenseNumber;
    }

    // Method to check if the doctor is available for a given date and time
    public boolean isAvailable(Date date, Time time) {
        for (Consultation consultation : appointmentList) {
            if (consultation.getDate().equals(date) && consultation.getBooking().equals(time)) {
                return false;  // Doctor is unavailable at the given date and time
            }
        }
        return true;  // Doctor is available
    }

    @Override
    public String toString() {
        return String.format("Doctor: %s %s, Specialization: %s, License: %d",
                getFirstName(), getSurName(), specialization, medicalLicenseNumber);
    }

    @Override
    public int compareTo(Doctor o) {
        return this.getSurName().compareTo(o.getSurName());
    }
}
