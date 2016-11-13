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
public class Assignment {
    
    //Attributes:
    private LinkedList<String> groups;
    private Teacher teacher;
    private Course course; 
    
    // Constructor:
    public Assignment(LinkedList<String> GROUPS) {
        this.groups = GROUPS;
    };
    
    //Public methods:
    //getters
    public LinkedList<String> getGroups(){
        return this.groups;
    };
    public Teacher getTeacher(){
        return this.teacher;
    };
    public Course getCourse(){
        return this.course;
    }; 
    
    //Setters/ add
    public  void setAssignment(LinkedList<String> groups){
        this.groups = groups;  
    };
    public  void addTeacher(Teacher t){
        this.teacher = t;
    }
    public  void addCourse(Course c){
        this.course = c;   
    };
    
            
        
}
