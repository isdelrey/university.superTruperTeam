/*
┌──────────────────────────────────────────────────────────────────────────────────┐
│                  Pràctica 2 - Programació Orientada a Objectes                   │
└──────────────────────────────────────────────────────────────────────────────────┘

Paula Bassagañas Odena, NIA: 158710
Ivo Sequeros del Rey, NIA: 183711

 */
package unimanager;

import java.util.LinkedList;

/**
 *
 * @author ivo
 */
public class Enrollment {
    
    // Attributes 
    private int seminarGroup;
    private Student student;
    private Course course; 
    
    // Constructor:
    public Enrollment(int SEMINARGROUP, Student STUDENT, Course course) {
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
    public Course getCourse(){
        return this.course;
    };
    //Adding, are setters indeed in this case. 
    public void setStudent (Student s){
      this.student = s;  
    };
    
    
}
