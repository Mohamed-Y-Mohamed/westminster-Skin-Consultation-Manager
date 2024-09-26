package w1830958.CourseWork;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class Person {

    private String firstName;
    private String surName;
    private Date dateOfBirth;
    private Long phoneNumber;

    public Person() {
        this.firstName = null;
        this.surName = null;
        this.phoneNumber = null;
    }

    public Person(String fn, String sn, Date dob, Long pn) {
        this.firstName = fn;
        this.surName = sn;
        this.dateOfBirth = dob;
        this.phoneNumber = pn;
    }

    // Getter and setter methods
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        if (phoneNumber.matches("^07\\d{9}$")) {
            this.phoneNumber = Long.parseLong(phoneNumber);
        } else {
            throw new IllegalArgumentException("Invalid phone number format. Phone number must be 11 digits and start with 07.");
        }
    }

    public void loadPhoneNumber(String phoneNumber) {
        try {
            setPhoneNumber(phoneNumber);
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid phone number in data file. Defaulting to null.");
            this.phoneNumber = null;  // Handle invalid phone numbers gracefully during loading
        }
    }

    public void loadsetDateOfBirth(String date) {
        // Parse date in the format "dd/MM/yyyy"
        String[] parts = date.split("/");
        int day = Integer.parseInt(parts[0]);
        int month = Integer.parseInt(parts[1]);
        int year = Integer.parseInt(parts[2]);
        this.dateOfBirth = new Date(day, month, year);
    }
}
