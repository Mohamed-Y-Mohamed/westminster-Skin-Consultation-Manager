

/**
 * @author Mohamed Mohamed
 * id number:w18309586
 */
package w1830958.CourseWork;

public class Consultation  {
    private Time bookingTime;
    private Date BookDate;
    private String notes;
    private Patient patient;
    private float cost;

    Consultation() {
                notes=null;
    }





    public Time getBooking() {
        return bookingTime;
    }

    public void setBooking(Time booking) {
        this.bookingTime = booking;
    }

    public Date getDate() {
        return BookDate;
    }

    public void setDate(Date date) {
        this.BookDate = date;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(int cost) {

        this.cost = cost;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {

        this.patient = patient;
    }

    @Override
    public String toString() {
        return " patient:" + patient +"booking:" +BookDate+", " + bookingTime +  ", notes: " + notes +  ", cost: £" + cost ;
    }







}
