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
    private int group;
    private int timeSlot;
    private int type;
    private Classroom classroom;
    private Course course; 
    
    //Contructor:
    public Lecture(int GROUP, int TIMESLOT, int TYPE, Course COURSE, Classroom CLASSROOM) {
        this.group = GROUP; 
        this.timeSlot = TIMESLOT; 
        this.type = TYPE;
        this.course = COURSE;
        this.classroom = CLASSROOM;
    }
    
    // Public methods:
    //getters
    public int getGroup(){
        return this.group;  
    };
    public int getTimeSlot(){
        return this.timeSlot;
    };
    public int getType(){
        return this.type;
    };
    public int getGeneralGroup(){
        return (this.group < 10)?this.group:((this.group < 100)?this.group/10:this.group/100);
    };
    public Course getCourse(){
        return this.course;
    };
   //Adds and setters:
   public void addClassroom(Classroom c){
       this.classroom = c;
   };
   public void setGroup(int g){
       this.group = g;
   };
   public void setTimeSlot( int i){
       this.timeSlot = i;
   };
   public void setType(int i){
       this.type = i;
   };
   
   
}