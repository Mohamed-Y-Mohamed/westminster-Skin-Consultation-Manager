/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package w1830958.CourseWork;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Mo
 * all the methods in this class are called in main in westminsterSkinConsultationManager class 
 */
public class DoctorTest {
    public DoctorTest() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of getAppointmentList method, of class Doctor.
     */
    public void testGetAppointmentList() {
    }

    /**
     * Test of setAppointmentList method, of class Doctor.
     */
    public void testSetAppointmentList() {
    }

    /**
     * Test of loadSpecialisation method, of class Doctor.
     */
    public void testLoadspecialisation() {
        
    }

    /**
     * Test of setSpecialisation method, of class Doctor.
     */
    public void testSetSpecialisation() {
    }

    /**
     * Test of setMLN method, of class Doctor.
     */
    public void testSetMLN() {
    }

    /**
     * Test of getSpecialisation method, of class Doctor.
     */
    public void testGetSpecialisation() {
    }

    /**
     * Test of getMLN method, of class Doctor.
     */
    public void testGetMLN() {
    }

    /**
     * Test of toString method, of class Doctor.
     */
    public void testToString() {
    }

    /**
     * Test of compareTo method, of class Doctor.
     */
    public void testCompareTo() {
    }

    /**
     * Test of Add method, of class Doctor.
     */
    @Test

    public void testAdd() {
        WestminsterSkinConsultationManagerTest test=new WestminsterSkinConsultationManagerTest ();
        System.out.println("Add");
       
        Date dob=new Date(02,03,2000);
        Doctor doctor;
        long num=07334433434;
        doctor = new Doctor("ali","jaber",dob,num, "skin",1);
        Doctor  doctor1 = new Doctor("ali","jaber",dob,num, "skin",4);
        Doctor  doctor2 = new Doctor("ali","jaber",dob,num, "skin",2);
        Doctor  doctor3 = new Doctor("ali","jaber",dob,num, "skin",3);

        test.testAddDoctors(doctor);
        test.testAddDoctors(doctor1);
        test.testAddDoctors(doctor2);
        test.testAddDoctors(doctor3);

    }

    /**
     * Test of Delete method, of class Doctor.
     */
@Test

    public void testDelete() {
        WestminsterSkinConsultationManagerTest test=new WestminsterSkinConsultationManagerTest ();

         Date dob=new Date(02,03,2000);
        Doctor doctor;
        long num=07334433434;
        doctor = new Doctor("ali","jaber",dob,num, "skin",1);
        Doctor  doctor1 = new Doctor("ali","jaber",dob,num, "skin",4);
        Doctor  doctor2 = new Doctor("ali","jaber",dob,num, "skin",2);
        Doctor  doctor3 = new Doctor("ali","jaber",dob,num, "skin",3);

       test.testAddDoctors(doctor);
        test.testAddDoctors(doctor1);
       test.testAddDoctors(doctor2);
      test.testAddDoctors(doctor3);

        int medicalliencsenumber=1;
 for (int i = 0; i < test.DoctorList.size(); i++) {

            if (medicalliencsenumber==(test.DoctorList.get(i).getMLN()))  {
test.DoctorList.remove(medicalliencsenumber);
                
                break;
            } else if (medicalliencsenumber!=test.DoctorList.get(i).getMLN() && i == test.DoctorList.size()) {
                System.out.println("name not found.");
            }
    }
    }

    /**
     * Test of save method, of class Doctor.
     */
@Test

    public void testSave() {
                WestminsterSkinConsultationManagerTest test=new WestminsterSkinConsultationManagerTest ();

        
                 Date dob=new Date(02,03,2000);
        Doctor doctor;
        long num=07334433434;
        doctor = new Doctor("ali","jaber",dob,num, "skin",1);
        Doctor  doctor1 = new Doctor("ali","jaber",dob,num, "skin",4);
        Doctor  doctor2 = new Doctor("ali","jaber",dob,num, "skin",2);
        Doctor  doctor3 = new Doctor("ali","jaber",dob,num, "skin",3);

      test.testAddDoctors(doctor);
        test.testAddDoctors(doctor1);
       test.testAddDoctors(doctor2);
      test.testAddDoctors(doctor3);

        try{
         BufferedWriter saveOb = new BufferedWriter(new FileWriter("westminsterSkinConsultationManager\\src\\test\\java\\w1830958\\CourseWork\\testsaveDoctor.csv"));
            if (test.DoctorList.size() > 0) {
                for (int i = 0; i < test.DoctorList.size(); i++) {

                    saveOb.write(test.DoctorList.get(i).getFirstName() + "," + test.DoctorList.get(i).getSurName() + "," + String.valueOf(test.DoctorList.get(i).getDateofBirth()) + "," + String.valueOf(test.DoctorList.get(i).getPhoneNumber()) + ","
                            + test.DoctorList.get(i).getSpecialisation() + ","
                            + String.valueOf(test.DoctorList.get(i).getMLN()) + "\n");
                    saveOb.flush();
                }

            } else {
            }
    }catch (IOException e){
        
    }}

    /**
     * Test of load method, of class Doctor.
     */
@Test
    public void testLoad() {

        String line;
        String spliter = ",";
        String[] employee;
        try {
            BufferedReader br = new BufferedReader(new FileReader("westminsterSkinConsultationManager\\src\\test\\java\\w1830958\\CourseWork\\testsaveDoctor.csv"));
            boolean retireveconfirm = false;
            while ((line = br.readLine()) != null) {
                WestminsterSkinConsultationManagerTest test=new WestminsterSkinConsultationManagerTest ();

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
                test.testAddDoctors(doctor);
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
    
    

