package w1830958.CourseWork;

public class Patient extends Person {
    private static int count = 0;
    private int ID;

    public Patient() {
        super();
        this.ID = ++count;
    }

    public int getID() {
        return ID;
    }

    public void setID(int id) {
        this.ID = id;
    }

    @Override
    public String toString() {
        return String.format("Patient ID: %d, Name: %s %s", ID, getFirstName(), getSurName());
    }
}
