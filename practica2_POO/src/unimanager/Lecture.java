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
public class Lecture {
    
    //Attributes
    private String group;
    private int timeSlot;
    private int type;
    private Classroom classroom;
    private Course course; 
    
    //Contructor:
    public Lecture(String GROUP, int TIMESLOT, int TYPE) {
        this.group = GROUP; 
        this.timeSlot = TIMESLOT; 
        this.type = TYPE;
    }
    
    // Public methods:
    //getters
    public String getGroup(){
        return this.group;  
    };
    public int getTimeSlot(){
        return this.timeSlot;
    };
    public int getType(){
        return this.type;
    };
    
    
   //Adds and setters:
   public void addClassroom(Classroom c){
       this.classroom = c;
   };
   public void setGroup( String g){
       this.group = g;
   };
   public void setTimeSlot( int i){
       this.timeSlot = i;
   };
   public void setType(int i){
       this.type = i;
   };
   
   
}