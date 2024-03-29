/*
┌──────────────────────────────────────────────────────────────────────────────────┐
│                  Pràctica 2 - Programació Orientada a Objectes                   │
└──────────────────────────────────────────────────────────────────────────────────┘

Paula Bassagañas Odena, NIA: 158710
Ivo Sequeros del Rey, NIA: 183711

 */
package unimanager;
import java.text.DecimalFormat;
import java.util.LinkedList;

/**
 *
 * @author ivo
 */
public class Classroom {
    
    // Attributes
    private double code;
    private LinkedList<Lecture> lectures;
    
    // Constructor
    public Classroom(double CODE) {
        code = CODE;
        lectures = new LinkedList<>();
    };
    
    //Public methods 
    //getters
    public double getCode(){
        return this.code;
    };
    public String getCodeAsString(){
        DecimalFormat df = new DecimalFormat("#0.000");
        return df.format(code);
    };
    public LinkedList<Lecture> getLectures(){
        return this.lectures;
    };
    //setter and add
    public void setCode(int i){
        this.code = i;
    };
    public void addLecture(Lecture l){
        this.lectures.add(l);
    };

    public LinkedList<Course> getCourses() {
        LinkedList<Course> courseList = new LinkedList<>();
        for (Lecture lecture : this.lectures){
            courseList.add(lecture.getCourse());
        }
       return courseList;
    };
}
