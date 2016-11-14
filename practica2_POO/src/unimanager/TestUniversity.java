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
        System.out.println("Only a few quick tests are included here. Run Unit Test UniversityTest.java to get the full test.\n");
        System.out.println("Ron Weasley's courses:");
        university.coursesOfStudent( "Ron Weasley" ).forEach((s) -> {
            System.out.println(s);
        });
        System.out.println("-----");
        
        System.out.println("Name of the first student on the list:");
        System.out.println(university.getStudents().getFirst().getName());
        System.out.println("-----");
        System.out.println("Courses of classroom 12.100:");
        university.coursesOfClassroom( 12.100 ).forEach((s) -> {
            System.out.println(s);
        });
        System.out.println("Albus Dumbledore's courses:");
        university.coursesOfTeacher("Albus Dumbledore").forEach((s) -> {
            System.out.println(s);
        });
        System.out.println("-----");
        System.out.println("Courses of classroom 12.100 at time-slot 11:");
        university.coursesOfClassroom( 12.100,17 ).forEach((s) -> {
            System.out.println(s);
        });
        System.out.println("-----");
        System.out.println("Teacher of classroom 10.100 at time-slot 0");
        System.out.println(university.teacherOfClassroom(10.100, 0));
        
        System.out.println("-----");
        System.out.println("Teachers of Potions:");
        university.teachersOfCourse("Potions").forEach((s) -> {
            System.out.println(s);
        });
        System.out.println("-----");
        System.out.println("Students of 11.101 at time-slot 7:");
        university.studentsOfClassroom(11.101, 7).forEach((s) -> {
            System.out.println(s);
        });
        System.out.println("-----");
        System.out.println("Minerva McGonagall's students:");
        university.studentsOfTeacher("Minerva McGonagall").forEach((s) -> {
            System.out.println(s);
        });
        System.out.println("-----");
        
        System.out.println("Where does Albus Dumbledore lecture at the time-slot 7?");
        System.out.println(university.classroomOfTeacher( "Albus Dumbledore", 7));
        
        System.out.println("-----");
        
        System.out.println("Is Harry enrolled in Enchantments?");
        System.out.println(university.studentIsEnrolledInCourse("Harry Potter", "Enchantments")?"Yes":"No");
        
        System.out.println("-----");
        
        System.out.println("Is Harry enrolled in Black Magic Defense?");
        System.out.println(university.studentIsEnrolledInCourse("Harry Potter", "Black Magic Defense")?"Yes":"No");
        
        System.out.println("-----");
        
        System.out.println("Does Snape teach Potions?");
        System.out.println(university.teacherTeachesCourse("Severus Snape", "Potions")?"Yes":"No");
        
        
    }
}
