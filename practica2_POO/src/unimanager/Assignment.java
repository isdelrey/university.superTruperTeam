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
    private Teacher teacher;
    private Course course; 
    
    // Constructor:
    public Assignment(Course COURSE,LinkedList<Integer> GROUPS,Teacher TEACHER) {
        this.course = COURSE;
        this.groups = GROUPS;
        this.teacher = TEACHER;
    };
    
    //Public methods:
    //getters
    public LinkedList<Integer> getGroups(){
        return this.groups;
    };
    public Teacher getTeacher(){
        return this.teacher;
    };
    public Course getCourse(){
        return this.course;
    }; 
    
    //Setters/ add
    public  void setAssignment(LinkedList<Integer> groups){
        this.groups = groups;  
    };
    public  void addCourse(Course c){
        this.course = c;   
    };
    public  void addGroup(Integer c){
        this.groups.add(Integer.SIZE);
    };
    
            
        
}
