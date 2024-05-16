/**
 * @author Mohamed Mohamed
 * id number:w18309586
 */
package w1830958.CourseWork;


import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class Person {

    private String FirstName;
    private String SurName;
    private Date DateofBirth;
    private Long PhoneNumber;

    public Person() {

        FirstName = null;
        SurName = null;
        PhoneNumber = null;
    }
      public Person(String fn,String sn,Date dob,Long Pn) {

        FirstName = fn;
        SurName = sn;
        DateofBirth=dob;
        PhoneNumber = Pn;
    }
    Scanner in = new Scanner(System.in);

    public void LoadsetFirstName(String firstName) {
        this.FirstName =firstName ;

    }


    public void setFirstName() {
      boolean exit=false;
        while(!exit){
            String regex = "^[a-zA-Z]+$";

        String firstName=in.nextLine();


            if (firstName.matches(regex)){
        this.FirstName = firstName;
                exit=true;

            }
else{
                System.out.println("invalid input. name only has letters. try again");
}}}
    public String getFirstName() {
        return FirstName;
    }



    public void LoadsetSurName(String surname) {
        this.SurName =surname ;

    }

        public void setSurName() {
        boolean exit=false;
        while(!exit){
            String regex = "^[a-zA-Z]+$";

            String surname=in.nextLine();

            if (surname.matches(regex)){
                this.SurName =surname ;
                exit=true;
            }
            else{
                System.out.println("invalid input. name only has letters. try again");

    }}}
    public String getSurName() {
        return SurName;
    }


    public void setDateofBirth(Date DateofBirth) {
        boolean exit = false;
        while (!exit) {
            System.out.println("enter the Year you born in?");
            DateofBirth.setYear();
            System.out.println("Enter the Month you born in?");
            DateofBirth.setMonth();
            System.out.println("enter the Day you born in?");
            DateofBirth.setDay();


                this.DateofBirth = DateofBirth;
                exit = true;

            }
        }


    public void loadsetDateofBirth(String DateofBirth) {
        String[] dateretireve;
        dateretireve = DateofBirth.split("/");
        String day = dateretireve[0];

        String replace = day.replace(" ", "");
        int date = Integer.parseInt(replace);
        int month = Integer.parseInt(dateretireve[1]);
        int year = Integer.parseInt(dateretireve[2]);
        this.DateofBirth = new Date(date, month, year);
    }


    public Date getDateofBirth() {
        return DateofBirth;
    }








    public void setPhoneNumber() {
        Pattern p = Pattern.compile("^\\d{11}$");

        boolean w = false;
        while (!w) {
            try {

                String length = in.nextLine();
                Matcher m = p.matcher(length);

                if (m.matches() &&length.charAt(0)=='0' && length.charAt(1)=='7' ) {
                   Long phoneNumber = Long.parseLong(length);
                    this.PhoneNumber = phoneNumber;
                    w = true;
                } else {
                    System.out.println(" this is not a uk Mobile number\nplease try again with a number starting with 07:");
                }
            } catch (Exception e) {
                System.out.println("invalid type. please enter numbers only.");
            }

        }
    }

    public void loadPhoneNumber(String phoneNumber) {

        PhoneNumber = Long.valueOf(phoneNumber);
    }

    public Long getPhoneNumber() {
        return PhoneNumber;
    }
}
