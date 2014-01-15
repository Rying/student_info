package com.thoughtworks.ns;

import com.google.common.base.Predicate;


import java.util.ArrayList;
import java.util.List;

import static com.google.common.collect.Collections2.filter;


public class Students {
    private List<Student> students;


    public Students() {
        students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public List<Student> getAllStudents() {
        return students;
    }

    public List<Student> getPassedStudents() {
        return new ArrayList<>(filter(students, getStudentsScoreMoreThan60()));
    }

    private Predicate<Student> getStudentsScoreMoreThan60() {
        return new Predicate<Student>() {
            public boolean apply(Student student) {
                return student.getScore() >= 60;
            }
        };
    }
}
