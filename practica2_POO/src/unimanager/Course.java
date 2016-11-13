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
public class Course {
    private String name;
    private LinkedList<Enrollment> enrollments; 
    private LinkedList<Assignment> assignments;
    private LinkedList<Lecture> lectures; 
    
    // Contructor:
    public Course(String NAME) {
        name = NAME;
    }
    
    // Public methods:
    //getters
    public LinkedList<Enrollment> getEnrollments(){
      return this.enrollments;  
    };
    public LinkedList<Assignment>  getAssignments(){
        return this.assignments; 
    };
    public LinkedList<Lecture> getLectures(){
        return this.lectures; 
    };
    
    //setters
    public void setEnrollments(LinkedList<Enrollment> enrollments){
        this.enrollments = enrollments; 
    };
    public void setAssignments(LinkedList<Assignment> assignments){
        this.assignments = assignments;
    }
    public void setLectures(LinkedList<Lecture> lectures){
        this.lectures = lectures;
    };
    
    //Add 1 enrollment, assignment or lecture to the current ones.
    public void addEnrollments(Enrollment e){
       this.enrollments.add(e); 
    };
    public void addAssignments(Assignment a){
      this.assignments.add(a);  
    };
    public void addLecture(Lecture l){
      this.lectures.add(l);
    };
   
}
