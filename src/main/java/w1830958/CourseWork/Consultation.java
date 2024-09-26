package w1830958.CourseWork;

public class Consultation {

    private Time bookingTime;
    private Date bookingDate;  // Use your custom Date class here
    private String notes;
    private Patient patient;
    private float cost;

    public Consultation() {
        this.notes = "";
        this.cost = 0.0f;
    }

    // Getter and Setter for booking time
    public Time getBooking() {
        return bookingTime;
    }

    public void setBooking(Time bookingTime) {
        this.bookingTime = bookingTime;
    }

    // Getter and Setter for booking date (using your custom Date class)
    public Date getDate() {
        return bookingDate;
    }

    public void setDate(Date bookingDate) {
        this.bookingDate = bookingDate;
    }

    // Getter and Setter for notes
    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    // Getter and Setter for patient
    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    // Getter and Setter for cost
    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Patient: " + patient + ", Booking Date: " + bookingDate + ", Time: " + bookingTime + ", Notes: " + notes + ", Cost: £" + cost;
    }
}
