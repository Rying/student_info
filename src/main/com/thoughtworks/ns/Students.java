package com.thoughtworks.ns;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ry on 14-1-13.
 */
public class Students {
    private List<Student> students;


    public Students() {
        students = new ArrayList();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public List<Student> getAllStudents() {
        return students;
    }

    public List<Student> getPassedStudents() {
        List<Student> passedStudents = new ArrayList();
        for (Student student : students) {
            if (student.getScore() > 60) {
                passedStudents.add(student);
            }
        }
        return passedStudents;
    }
}
