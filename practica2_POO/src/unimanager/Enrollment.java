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
    private String seminarGroup;
    private Student student;
    private Course course;
    
    // Constructor:
    public Enrollment(String SEMINARGROUP, Student STUDENT) {
        seminarGroup = SEMINARGROUP;
    };
    
    // Public methods:
    //getters
    public String getSeminarGroup(){
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
    public void setCourse(Course c){
      this.course = c;   
    };
    
    
}
