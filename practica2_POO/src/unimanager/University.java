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
    private LinkedList<Teacher> teachers;
    private LinkedList<Student> students;
    private LinkedList<Course> courses;
    private LinkedList<Classroom> classrooms;
    
    public University() {
        this.teachers = Loader.loadTeachers();
        this.students = Loader.loadStudents();
        this.courses = Loader.loadCourses();
        Loader.loadLectures(courses, classrooms);
        Loader.loadEnrollments(courses, students);
        Loader.loadAssignments(courses, teachers);
    }
    public LinkedList<Teacher> getTeachers() {
        return teachers;
    }
    public LinkedList<Student> getStudents() {
        return students;
    }
    public LinkedList<Course> getCourses() {
        return courses;
    }
    public LinkedList<Classroom> getClassrooms() {
        return classrooms;
    }
}
