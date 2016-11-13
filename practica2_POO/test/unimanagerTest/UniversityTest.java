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
    public void teachersNumberCheck() {
        assertEquals(17,university.getTeachers().size());
    }
    @Test
    public void snapeTeacher() {
        Boolean found = false;
        for(unimanager.Teacher t : university.getTeachers()) {
            found = "Severous Snape".equals(t.getName());
            if(found) break;
        }
    }
    public Boolean XIsEnrolledInY(String X, String Y) {
        Boolean found = false, found2 = false;
        for(unimanager.Course c : university.getCourses())
            if(Y.equals(c.getName()))
                for(unimanager.Enrollment e : c.getEnrollments()) 
                    if(found = X.equals(e.getStudent().getName())) break;
        
        for(unimanager.Student s : university.getStudents())
            if(X.equals(s.getName()))
                for(unimanager.Enrollment e : s.getEnrollments()) 
                    if(found2 = Y.equals(e.getCourse().getName())) break;
        
        return (found && found2);
    }
    @Test
    public void DracoIsEnrolledInPotions() {
        assertTrue(XIsEnrolledInY("Draco Malfoy","Potions"));
    }
    @Test
    public void HarryIsEnrolledInPotions() {
        assertTrue(XIsEnrolledInY("Harry Potter","Potions"));
    }
    @Test
    public void HermioneIsEnrolledInTransformations() {
        assertTrue(XIsEnrolledInY("Hermione Granger","Transformations"));
    }
    @Test
    public void directAddEnrollmentInStudent() {
        unimanager.Enrollment e =new unimanager.Enrollment(1,university.getStudents().getFirst(),university.getCourses().getFirst());
        university.getStudents().getFirst().addEnrollment(e);
        assertTrue(university.getStudents().getFirst().getEnrollments().contains(e));
    }
    public Boolean XTeachesY(String X, String Y) {
        Boolean found = false, found2 = false;
        loop:for(unimanager.Teacher t : university.getTeachers())
            if(X.equals(t.getName()))
                for(unimanager.Assignment a : t.getAssignments()) {
                    found = a.getCourse().getName().equals(Y);
                    if(found) break loop;
                }
        loop2:for(unimanager.Course c : university.getCourses())
            if(c.getName().equals(Y))
                for(unimanager.Assignment a : c.getAssignments()) {
                    found2 = X.equals(a.getTeacher().getName());
                    if(found2) break loop2;
                }
        return (found && found2);
    }
    @Test
    public void SnapeTeachesPotions() {
        assertTrue(XTeachesY("Severus Snape","Transformations"));
    }
    @Test
    public void AlbusTeachesTransformations() {
        assertTrue(XTeachesY("Albus Dumbledore","Transformations"));
    }
    @Test
    public void MinervaTeachesTransformations() {
        assertTrue(XTeachesY("Minerva McGonagall","Transformations"));
    }
}
