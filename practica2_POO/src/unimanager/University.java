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
    LinkedList<Teacher> teachers;
    LinkedList<Student> students;
    LinkedList<Course> courses;
    LinkedList<Classroom> classrooms;
    
    public University() {
        teachers = Loader.loadTeachers();
        students = Loader.loadStudents();
        courses = Loader.loadCourses();
        Loader.loadLectures(courses, classrooms);
        Loader.loadEnrollments(courses, students);
        Loader.loadAssignments(courses, teachers);
    }
}
