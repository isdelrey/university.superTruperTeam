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
public class Teacher {
    
    // Attributes: 
    private String name;
    private LinkedList<Assignment> assignments;
    
    // Contructor:
    public Teacher(String NAME) {
        name = NAME;
    }
    
    //Public methods: 
    public String getName(){
      return this.name;  
    };
    public LinkedList<Assignment> assignments(){
        return this.assignments;
    };
    
    // Add and setter
    public void setName(String n){
        this.name = n;
    };
    public void addAssignment(Assignment a){
        this.assignments.add(a);
    };
}
