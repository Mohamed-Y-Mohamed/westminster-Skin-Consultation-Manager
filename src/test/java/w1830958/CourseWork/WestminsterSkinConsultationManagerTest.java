/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package w1830958.CourseWork;

import java.util.ArrayList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Mo
 */
public class WestminsterSkinConsultationManagerTest {
     ArrayList<Doctor> DoctorList;


    public WestminsterSkinConsultationManagerTest() {
        DoctorList=new ArrayList<>();
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
        
    }



    /**
     * Test of addDoctors method, of class WestminsterSkinConsultationManager.
     */
    public void testAddDoctors(Doctor doctor) {
          DoctorList.add(doctor);
    }

  
 

   
    /**
     * Test of main method, of class WestminsterSkinConsultationManager.
     */

    
    
      /**
     * Test of Display method, of class WestminsterSkinConsultationManager.
     */
       @Test
    public void testDisplay() {
                 Date dob=new Date(02,03,2000);
        Doctor doctor;
        long num=07334433434;
        doctor = new Doctor("ali","jaber",dob,num, "skin",1);
        Doctor  doctor1 = new Doctor("ali","jaber",dob,num, "skin",4);
        Doctor  doctor2 = new Doctor("ali","jaber",dob,num, "skin",2);
        Doctor  doctor3 = new Doctor("ali","jaber",dob,num, "skin",3);

       DoctorList.add(doctor);
               DoctorList.add(doctor1);
       DoctorList.add(doctor2);
       DoctorList.add(doctor3);
        for (int i=0;i<DoctorList.size();i++){
            System.out.println(DoctorList.get(i));
        }
    }
}
