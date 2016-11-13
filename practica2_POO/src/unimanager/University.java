/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unimanager;

import java.util.LinkedList;

/**
 *
 * @author ivo
 */
public class University {
    
    // Attributes
    private LinkedList<Teacher> teachers;
    private LinkedList<Student> students;
    private LinkedList<Course> courses;
    private LinkedList<Classroom> classrooms;
    
    // Contructor
    public University() {
        this.teachers = Loader.loadTeachers();
        this.students = Loader.loadStudents();
        this.courses = Loader.loadCourses();
        Loader.loadLectures(courses, classrooms);
        Loader.loadEnrollments(courses, students);
        Loader.loadAssignments(courses, teachers);
    }
    
    
    //Public Methods
    public LinkedList<Teacher> getTeachers(){
        return this.teachers;
    };
    public LinkedList<Student> getStudents(){
        return this.students;
    };
    public LinkedList<Course> getCourses(){
        return this.courses;
    };
    
    /**
     *
     * @param student
     * @return
     */
    public LinkedList<String> coursesOfStudent(String student){
        LinkedList<String> coursesList = new LinkedList<>();
        for(Student s: this.students)
        {
            if(s.getName().equals(student)){
                for(Course course : s.getCourses() ){
                    coursesList.add(course.getName());
                }; 
                break; 
            };         
        };
        return coursesList;
    };
}
