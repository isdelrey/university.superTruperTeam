/*
┌──────────────────────────────────────────────────────────────────────────────────┐
│                  Pràctica 2 - Programació Orientada a Objectes                   │
└──────────────────────────────────────────────────────────────────────────────────┘

Paula Bassagañas Odena, NIA: 158710
Ivo Sequeros del Rey, NIA: 183711

 */
package unimanager;

/**
 *
 * @author ivo
 */
public class TestUniversity {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        University university = new University();
        System.out.println(university.coursesOfStudent( "Ron Weasley" ) ) ;
        System.out.println(university.getStudents().getFirst().getName());
        System.out.println(university.CoursesOfClassroom( 11.101 ) + "If the courses are repeated the repeatitions are omited");
        System.out.println(university.teachersOfCourse( "Filius Flitwick")+  "Filius Flitwick" ) ;
        System.out.println(university.studentsOfTeacher( "Horace Slughorn", 12.100)+  "Filius Flitwick" + "11.101" + " " + university.studentsOfTeacher( "Filius Flitwick", 11.101 ).size()) ;
        
        
    }
}
