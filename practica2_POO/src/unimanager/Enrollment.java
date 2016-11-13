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
public class Enrollment {
    
    // Attributes 
    private int seminarGroup;
    private Student student;
    
    // Constructor:
    public Enrollment(int SEMINARGROUP, Student STUDENT) {
        seminarGroup = SEMINARGROUP;
        student = STUDENT;
    };
    
    // Public methods:
    //getters
    public int getSeminarGroup(){
        return this.seminarGroup; 
    };
    public Student getStudent(){
        return this.student;
    };
    //Adding, are setters indeed in this case. 
    public void setStudent (Student s){
      this.student = s;  
    };
    
    
}
