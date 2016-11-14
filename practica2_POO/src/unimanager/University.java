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
    public LinkedList<String> coursesOfStudent(String student) {
        LinkedList<String> coursesList = new LinkedList<>();
        for(Student s: this.students)
        {
            if(s.getName().equals(student)){
                for(Course course : s.getCourses()) {
                    coursesList.add(course.getName());
                }
                break; 
            }
        }
        return coursesList;
    };
    public LinkedList<String> studentsOfClassroom(double classroom, int timeSlot) {
        LinkedList<String> studentsList = new LinkedList<>();
        for(Classroom cl : this.classrooms) 
            if(classroom == cl.getCode()) {
                for(Lecture l : cl.getLectures())
                    if(l.getTimeSlot() == timeSlot)
                        for(Enrollment e : l.getCourse().getEnrollments())
                            if(e.getGeneralGroup() == l.getGeneralGroup())
                                studentsList.add(e.getStudent().getName());
            break;
            }
        return studentsList;
    }

    public LinkedList <String> coursesOfClassroom (double code) {
        LinkedList<String> coursesList = new LinkedList<>();
        for(Classroom classroom : this.classrooms){
            if(classroom.getCode() == code){
                for(Course course : classroom.getCourses()){
                    String courseName = course.getName();
                    if(!coursesList.contains(courseName))
                        coursesList.add(course.getName());
                }
                break;
            }
        }
        return coursesList;
    };
    public LinkedList <String> coursesOfClassroom (double code, int timeSlot) {
        LinkedList<String> coursesList = new LinkedList<>();
        for(Classroom classroom : this.classrooms) {
            if(classroom.getCode() == code) {
                for(Lecture l : classroom.getLectures())
                    if(l.getTimeSlot() == timeSlot) {
                        String courseName = l.getCourse().getName();
                        if(!coursesList.contains(courseName))
                           coursesList.add(courseName);
                    }
            break;
            }
        }
        return coursesList;
    }

    public String teacherOfClassroom(double classroom, int timeSlot) {
        String teacher = null;
        loop:for(Classroom cl : this.classrooms)
            if(classroom == cl.getCode()) {
                for(Lecture l : cl.getLectures())
                    for(Assignment e : l.getCourse().getAssignments())
                        for(Integer i : e.getGroups())
                            if(i == l.getGroup()) {
                                teacher = e.getTeacher().getName();
                                break loop;
                            }
                break;
            }
        return teacher;
    }
    
    public LinkedList<String> teachersOfCourse(String courseName) {
        LinkedList<String> teachersList = new LinkedList<>();
        for(Course c : getCourses())
            if(c.getName().equals(courseName)) {
                for(Assignment a : c.getAssignments())
                    if(!teachersList.contains(a.getTeacher().getName()))
                        teachersList.add(a.getTeacher().getName());
                break;
            }
                        
        return teachersList;
    }
    public LinkedList<String> coursesOfTeacher(String teacherName) {
        LinkedList<String> coursesList = new LinkedList<>();
        for(Teacher teacher : teachers)
            if(teacher.getName().equals(teacherName)) {
                for(Course course : teacher.getCourses())
                    coursesList.add(course.getName());
                break;
            }
        return coursesList;
    }
    public LinkedList<String> studentsOfTeacher (String teacherName) {
        LinkedList<String> studentsList = new LinkedList<>();
        for(Teacher teacher : teachers)
            if(teacher.getName().equals(teacherName)) {
                for(Assignment a : teacher.getAssignments())
                    for(Enrollment e : a.getCourse().getEnrollments())
                        for(Integer g : a.getGroups())
                            if(((g < 10)?g:((g < 100)?g/10:g/100)) == e.getGeneralGroup() && !studentsList.contains(e.getStudent().getName()))
                                studentsList.add(e.getStudent().getName());
                break;
            }
        return studentsList; 
    }
    public LinkedList<String> teachersOfStudent(String studentName) {
        LinkedList<String> teachersList = new LinkedList<>();
        for(Student s : students)
            if(s.getName().equals(studentName)) {
                for(Enrollment e : s.getEnrollments())
                    loop:for(Assignment a : e.getCourse().getAssignments())
                        for(Integer g : a.getGroups())
                            if(e.getGeneralGroup() == g && !teachersList.contains(a.getTeacher().getName())) {
                                teachersList.add(a.getTeacher().getName());
                                break loop;
                            }
                break;
            }
        return teachersList; 
    }
    
    public String classroomOfTeacher(String teacherName, int timeSlot) {
        String classroom = null;
        loop:for(Teacher teacher : this.teachers) 
            if(teacher.getName().equals(teacherName)) {
                for(Assignment a : teacher.getAssignments())
                    for(Lecture lecture: a.getCourse().getLectures())
                        if(lecture.getTimeSlot() == timeSlot && a.getGroups().contains(lecture.getGroup())) {
                            classroom = lecture.getClassroom().getCodeAsString();
                            break loop;
                        }
                break;
            }
        return classroom;
        
        
    }
    
     public String classroomOfStudent(String studentName, int timeSlot) {
        String classroom = null;
        loop:for(Student s : students)
            if(s.getName().equals(studentName)) {
                for(Enrollment e : s.getEnrollments())
                    for(Lecture lecture: e.getCourse().getLectures())
                        if(lecture.getTimeSlot() == timeSlot && e.getGeneralGroup() == lecture.getGeneralGroup()) {
                            classroom = lecture.getClassroom().getCodeAsString();
                            break loop;
                        }
                break;
            }
        return classroom;
    }
    public Boolean teacherTeachesCourse(String teacherName, String courseName) {
        Boolean found = false;
        loop:for(unimanager.Teacher t : getTeachers())
            if(teacherName.equals(t.getName())) {
                for(unimanager.Assignment a : t.getAssignments()) {
                    found = a.getCourse().getName().equals(courseName);
                    if(found) break loop;
                }
                break;
            }
        return found;
    }
    public Boolean studentIsEnrolledInCourse(String studentName, String courseName) {
        Boolean found = false;
        for(unimanager.Course c : getCourses())
            if(courseName.equals(c.getName())) {
                for(unimanager.Enrollment e : c.getEnrollments()) 
                    if(found = studentName.equals(e.getStudent().getName())) break;
                break;
            }
        return found;
    }
}
