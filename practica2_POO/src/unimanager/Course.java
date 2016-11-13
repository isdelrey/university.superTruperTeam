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
        lectures = new LinkedList<>();
        enrollments = new LinkedList<>();
        assignments = new LinkedList<>();
    }
    
    // Public methods:
    //getters
     public String getName(){
        return this.name; 
    };
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
     public void setName(String NAME){
        this.name =  NAME; 
    };
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
    public void addEnrollment(Enrollment e){
       this.enrollments.add(e); 
    };
    public void addAssignment(Assignment a){
      this.assignments.add(a);  
    };
    public void addLecture(Lecture l){
      this.lectures.add(l);
    };
    //Queries:
    public LinkedList<Student> getStudents(){
        LinkedList<Student> studentList = new LinkedList<>();
        for(Enrollment enrollment : this.enrollments){
            studentList.add(enrollment.getStudent());
        };
        return studentList; 
    }
   
}
