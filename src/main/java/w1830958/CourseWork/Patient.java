/**
 * @author Mohamed Mohamed
 * id number:w18309586
 */
package w1830958.CourseWork;

public class Patient extends Person {
private static int count=0;
    private int ID;
    public Patient() {
        super();
count++;
        ID =count;

    }
public void setID(int id){
        ID=id;
}
    public int getID() {
        return ID;
    }



    @Override
    public String toString() {
        return "Patient ID:" + ID + ", Name: "+getFirstName()+" "+getSurName()+", Date OF birth: "+getDateofBirth()+", Phone Number: "+getPhoneNumber();
    }

}
