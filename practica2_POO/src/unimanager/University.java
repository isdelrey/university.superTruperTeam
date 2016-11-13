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
        this.classrooms = Loader.loadClassrooms();
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
                for(Course course : s.getCourses()) {
                    coursesList.add(course.getName());
                }; 
                break; 
            };         
        };
        return coursesList;
    };
    public LinkedList<String> studentsOfClassroom(double classroom, int timeSlot) {
        LinkedList<String> studentsList = new LinkedList<>();
        for(Classroom cl : this.classrooms)
            if(classroom == cl.getCode())
                for(Lecture l : cl.getLectures())
                    if(l.getTimeSlot() == timeSlot)
                        for(Enrollment e : l.getCourse().getEnrollments())
                            if(e.getGeneralGroup() == l.getGeneralGroup())
                                studentsList.add(e.getStudent().getName());
        return studentsList;
    }
    public String teacherOfClassroom(double classroom, int timeSlot) {
        String teacher = null;
        loop:for(Classroom cl : this.classrooms)
            if(classroom == cl.getCode())
                for(Lecture l : cl.getLectures())
                    for(Assignment e : l.getCourse().getAssignments())
                        for(Integer i : e.getGroups())
                            if(i == l.getGroup()) {
                                teacher = e.getTeacher().getName();
                                break loop;
                            }
        return teacher;
    }
}
