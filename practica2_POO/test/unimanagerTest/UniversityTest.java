/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unimanagerTest;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ivo
 */
public class UniversityTest {
    unimanager.University university;
    public UniversityTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        university = new unimanager.University();
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
    public void studentsNumberCheck() {
        assertEquals(20,university.getStudents().size());
    }
    
    @Test
    public void studentHermione() {
        Boolean found = false;
        for(unimanager.Student s : university.getStudents()) {
            if("Hermione Granger".equals(s.getName())) {
                found = true;
                break;
            }
        }
        assertTrue(found);
    }
    @Test
    public void coursePotions() {
        Boolean found = false;
        for(unimanager.Course c : university.getCourses()) {
            if("Potions".equals(c.getName())) {
                found = true;
                break;
            }
        }
        assertTrue(found);
    }
    @Test
    public void enrollmentsInPotionsNumberCheck() {
        for(unimanager.Course c : university.getCourses()) {
            if("Potions".equals(c.getName())) {
                assertEquals(10,c.getEnrollments().size());
                break;
            }
        }
    }
    @Test
    public void DracoIsEnrolledInPotions() {
        Boolean found = false;
        for(unimanager.Course c : university.getCourses())
            if("Potions".equals(c.getName()))
                for(unimanager.Enrollment e : c.getEnrollments()) 
                    if(found = "Draco Malfoy".equals(e.getStudent().getName())) break;
        assertTrue(found);
    }
}
