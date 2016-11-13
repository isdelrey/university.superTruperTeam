/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unimanager;

import java.util.LinkedList;
import unimanager.utilities.Utility;

/**
 *
 * @author ivo
 */
class Loader {
     public static LinkedList<Teacher> loadTeachers() {
            LinkedList<Teacher> r = new LinkedList<>();
            LinkedList< String[] > dteachers = Utility.readXML( "teacher" );
            for(String[] s : dteachers) r.add(new Teacher(s[0]));
            return r;
        }
        public static LinkedList<Student> loadStudents() {
            LinkedList<Student> r = new LinkedList<>();
            LinkedList<String[]> dstudent = Utility.readXML( "student" );
            for(String[] s : dstudent) r.add(new Student(s[0],Integer.parseInt(s[1])));
            return r;
        }
        public static LinkedList<Classroom> loadClassrooms() {
            LinkedList<Classroom> r = new LinkedList<>();
            LinkedList< String[] > dclassroom = Utility.readXML( "classroom" );
            for(String[] s : dclassroom) r.add(new Classroom(Double.parseDouble(s[0])));
            return r;
        }
        public static LinkedList<Course> loadCourses() {
            LinkedList<Course> r = new LinkedList<>();
            LinkedList< String[] > dcourse = Utility.readXML( "teacher" );
            for(String[] s : dcourse) r.add(new Course(s[0]));
            return r;
        }
        public static void loadLectures(LinkedList<Course> COURSES, LinkedList<Classroom> CLASSROOMS) {
            LinkedList< String[] > dlecture = Utility.readXML( "lecture" );
            for(String[] s : dlecture)
                for(Course c : COURSES)
                    if(c.getName() == s[1]) {
                        Lecture l = new Lecture(s[4],Integer.parseInt(s[2]),Integer.parseInt(s[3]));
                        for(Classroom cl : CLASSROOMS)
                            if(Double.parseDouble(s[0]) == cl.getCode())
                                l.addClassroom(cl);
                        c.addLecture(new Lecture(s[4],Integer.parseInt(s[2]),Integer.parseInt(s[3])));
                    }
        }
        public static void loadEnrollments(LinkedList<Course> COURSES, LinkedList<Student> STUDENTS) {
            LinkedList<String[]> denrollment = Utility.readXML( "enrollment" );
            for(String[] s : denrollment)
                for(Course c : COURSES)
                    if(c.getName() == s[1])
                        for(Student st : STUDENTS)
                            if(s[0] == st.getName())
                                c.addEnrollment(new Enrollment(s[2],st));
        }
        public static void loadAssignments(LinkedList<Course> COURSES, LinkedList<Teacher> TEACHERS) {
            LinkedList<String[]> denrollment = Utility.readXML( "assignment" );
            for(String[] s : denrollment)
                for(Course c : COURSES)
                    if(c.getName() == s[1])
                        for(Teacher tea : TEACHERS)
                            if(s[0] == tea.getName()) {
                                LinkedList<Integer> groups = new LinkedList<>();
                                groups.add(Integer.parseInt(s[2]));
                                groups.add(Integer.parseInt(s[3]));
                                groups.add(Integer.parseInt(s[4]));
                                groups.add(Integer.parseInt(s[5]));
                                groups.add(Integer.parseInt(s[6]));
                                c.addAssignment(new Assignment(groups));
                            }
        }
        
}
