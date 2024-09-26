package w1830958.CourseWork;

import java.io.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for Doctor class and integration with WestminsterSkinConsultationManager
 */
public class DoctorTest {

    private WestminsterSkinConsultationManager manager;

    @BeforeEach
    public void setUp() {
        manager = new WestminsterSkinConsultationManager();
    }

    @AfterEach
    public void tearDown() {
        manager = null;
    }

    /**
     * Test of Add method, of class Doctor.
     */
    @Test
    public void testAdd() {
        System.out.println("Testing Add method...");

        Date dob = new Date(2, 3, 2000);
        Doctor doctor = new Doctor("Ali", "Jaber", dob, 7334433434L, "skin", 1);

        manager.addDoctors(doctor);

        assertEquals(1, manager.getDoctorList().size());
        assertEquals("Ali", manager.getDoctorList().get(0).getFirstName());
    }

    /**
     * Test of Delete method, of class Doctor.
     */
    @Test
    public void testDelete() {
        System.out.println("Testing Delete method...");

        Date dob = new Date(2, 3, 2000);
        Doctor doctor = new Doctor("Ali", "Jaber", dob, 7334433434L, "skin", 1);

        manager.addDoctors(doctor);
        manager.deleteDoctor(1);  // Delete doctor with MLN 1

        assertEquals(0, manager.getDoctorList().size());
    }

    /**
     * Test of Save method, simulating file save.
     */
    @Test
    public void testSave() throws IOException {
        System.out.println("Testing Save method...");

        Date dob = new Date(2, 3, 2000);
        Doctor doctor = new Doctor("Ali", "Jaber", dob, 7334433434L, "skin", 1);
        manager.addDoctors(doctor);

        try (BufferedWriter saveOb = new BufferedWriter(new FileWriter("testsaveDoctor.csv"))) {
            if (manager.getDoctorList().size() > 0) {
                for (Doctor doc : manager.getDoctorList()) {
                    saveOb.write(doc.getFirstName() + "," + doc.getSurName() + "," + doc.getDateOfBirth() + "," + doc.getPhoneNumber() + ","
                            + doc.getSpecialisation() + "," + doc.getMLN() + "\n");
                }
            }
        }

        File file = new File("testsaveDoctor.csv");
        assertTrue(file.exists());
    }

    /**
     * Test of Load method, simulating file load.
     */
    @Test
    public void testLoad() throws IOException {
        System.out.println("Testing Load method...");

        File file = new File("testsaveDoctor.csv");
        if (!file.exists()) {
            testSave();  // Ensure we have saved data first
        }

        try (BufferedReader br = new BufferedReader(new FileReader("testsaveDoctor.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                Doctor doctor = new Doctor();
                doctor.setFirstName(data[0]);
                doctor.setSurName(data[1]);
                doctor.loadsetDateOfBirth(data[2]);
                doctor.loadPhoneNumber(data[3]);
                doctor.loadSpecialisation(data[4]);
                doctor.setMLN(Integer.parseInt(data[5]));
                manager.addDoctors(doctor);
            }
        }

        assertEquals(1, manager.getDoctorList().size());
        assertEquals("Ali", manager.getDoctorList().get(0).getFirstName());
    }

    @Test
    public void testDisplay() {
        System.out.println("Testing Display method...");

        Date dob = new Date(2, 3, 2000);
        Doctor doctor1 = new Doctor("Ali", "Jaber", dob, 7334433434L, "skin", 1);
        Doctor doctor2 = new Doctor("John", "Doe", dob, 7334433445L, "cardiology", 2);

        manager.addDoctors(doctor1);
        manager.addDoctors(doctor2);

        manager.Display();

        assertEquals(2, manager.getDoctorList().size());
    }
}
