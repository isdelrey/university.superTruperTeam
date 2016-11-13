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
public class Student {
    
    // Attributes: 
    String name;
    int nia;
    LinkedList<Enrollment> enrollments; 
   
    //Contructor:
    public Student(String NAME,int NIA) {
        nia = NIA;
        name = NAME;
        enrollments = new LinkedList<>();
    }
    
    // Public methods: 
    //getters
    public String getName(){
        return this.name;
    };
    public int getNia(){
        return this.nia;
    }; 
    public LinkedList<Enrollment> getEnrollments(){
        return this.enrollments;
    };
    
    //Adds and setters:
    public void setName(String n){
        this.name = n;
    };
    public void setNia(int n){
        this.nia = n;
    };
    public void addEnrollment(Enrollment e){
        this.enrollments.add(e);
    };
    public LinkedList<Course> getCourses(){
        LinkedList<Course> courseList = new LinkedList<>();
        for(Enrollment enroll : this.enrollments){
            courseList.add(enroll.getCourse());
        };
        return courseList; 
    };

}
