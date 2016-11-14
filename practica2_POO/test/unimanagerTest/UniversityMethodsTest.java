/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unimanagerTest;

import java.util.LinkedList;
import org.hamcrest.CoreMatchers;
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
public class UniversityMethodsTest {
    
    public UniversityMethodsTest() {
    }
    unimanager.University university;
    
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
    public void coursesOfClassroom_CoursesOf11100() {
        LinkedList<String> list = university.coursesOfClassroom( 11.101 );
        assertEquals(6,list.size());
        assertThat(list,CoreMatchers.hasItems("Black Magic Defense","Transformations","Enchantments","Potions","Flight","Astronomy"));
    }
    @Test
    public void classroomOfStudent_harryPotterIsAtTimeSlot0In10100() {
        assertEquals("10.100",university.classroomOfStudent("Harry Potter",0));
    }
    @Test
    public void teacherTeachesCourse_snapeTeachesEnchantments() {
        assertFalse(university.teacherTeachesCourse("Severus Snape", "Enchantments"));
    }
    @Test
    public void classroomOfTeacher_filiusTeachesAt11100AtTimeSlot11() {
        assertEquals("11.100",university.classroomOfTeacher( "Filius Flitwick", 11));
    }
    @Test
    public void studentIsEnrolledInCourse_harryIsEnrolledInFlight() {
        assertTrue(university.studentIsEnrolledInCourse("Harry Potter", "Flight"));
    }
    @Test
    public void teachersOfStudent_teachersOfNymphadora() {
        LinkedList<String> list = university.teachersOfStudent("Nymphadora Tonks");
        assertEquals(3,list.size());
        assertThat(list,CoreMatchers.hasItems("Albus Dumbledore","Filius Flitwick","Madame Rolanda Hooch"));
    }
    @Test
    public void studentsOfTeacher_studentsOfHoraceSlughorn() {
        LinkedList<String> list = university.studentsOfTeacher("Horace Slughorn");
        assertEquals(10,list.size());
        assertThat(list,CoreMatchers.hasItems("Luna Lovegood","Marietta Edgecombe","Gregory Goyle","Pancy Parkinson","Vincent Crabbe","Harry Potter","Hermione Granger","Lee Jordan","Hannah Abbott","Cedric Diggory"));
    }
}
