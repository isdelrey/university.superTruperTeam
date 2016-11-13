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
        System.out.println(university.coursesOfStudent( "Nymphadora Tonks" ) ) ;
        System.out.println(university.getStudents().getFirst().getName());
    }
}
