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
        assignments = new LinkedList<>();
    }
    
    //Public methods: 
    public String getName(){
      return this.name;  
    };
    public LinkedList<Assignment> getAssignments(){
      return this.assignments;  
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

    public LinkedList<Course> getCourses() {
        LinkedList<Course> courseList = new LinkedList<>();
        for(Assignment assignment : this.assignments){
            courseList.add(assignment.getCourse());
        };
        return courseList;
    }
    public LinkedList<Student> getStudents(){
        LinkedList<Student> studentList = new LinkedList<>();
        for(Course course : this.getCourses()){
            for (Student student : course.getStudents())
            {
                studentList.add(student);
            };
        };
        return studentList;
    }; 
    public LinkedList<Integer> getTeacherGroups(){
        LinkedList<Integer> teacherGroups =  new LinkedList<>();
        for(Assignment assignment : this.assignments){
            for(Integer group : assignment.getGroups()){
                teacherGroups.add(group);
            };    
        };
        return teacherGroups; 
    }
    
}
