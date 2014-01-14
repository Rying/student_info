package com.thoughtworks.ns;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class StudentsTest {
    private final Student[] student_array = new Student[3];
    private final Students students = new Students();

    @Before
    public void setUp() {
        student_array[0] = new Student("A", 100);
        student_array[1] = new Student("B", 80);
        student_array[2] = new Student("C", 59);

        students.addStudent(student_array[0]);
        students.addStudent(student_array[1]);
        students.addStudent(student_array[2]);
    }

    @Test
    public void should_get_all_students() {
        List<Student> another_students = new ArrayList<>();
        another_students.add(student_array[0]);
        another_students.add(student_array[1]);
        another_students.add(student_array[2]);

        assertThat(students.getAllStudents(), is(another_students));
    }

    @Test
    public void should_get_students_score_more_than_60() {
        List<Student> another_students = new ArrayList<>();
        another_students.add(student_array[0]);
        another_students.add(student_array[1]);

        assertThat(students.getPassedStudents(), is(another_students));
    }
}
