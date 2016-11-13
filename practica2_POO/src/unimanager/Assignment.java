/*
┌──────────────────────────────────────────────────────────────────────────────────┐
│                  Pràctica 2 - Programació Orientada a Objectes                   │
└──────────────────────────────────────────────────────────────────────────────────┘

Paula Bassagañas Odena, NIA: 158710
Ivo Sequeros del Rey, NIA: 183711

 */
package unimanager;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author ivo
 */
public class Assignment {
    
    //Attributes:
    private LinkedList<Integer> groups;
    private List<Teacher> teachers;
    private Course course; 
    
    // Constructor:
    public Assignment(LinkedList<Integer> GROUPS) {
        this.groups = GROUPS;
    };
    
    //Public methods:
    //getters
    public LinkedList<Integer> getGroups(){
        return this.groups;
    };
    public List<Teacher> getTeachers(){
        return this.teachers;
    };
    public Course getCourse(){
        return this.course;
    }; 
    
    //Setters/ add
    public  void setAssignment(LinkedList<Integer> groups){
        this.groups = groups;  
    };
    public  void addTeacher(Teacher t){
        teachers.add(t);
    }
    public  void addCourse(Course c){
        this.course = c;   
    };
    
            
        
}
