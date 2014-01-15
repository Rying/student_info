package com.thoughtworks.ns;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class DisplayTest {
    Display display = new Display();
    private final List<Student> students = new ArrayList<>();

    @Before
    public void setUp() {
        students.add(new Student("A", 100));
        students.add(new Student("B", 80));
        students.add(new Student("C", 59));
    }

    @Test
    public void should_output_is_A100() {
        assertThat(display.displayInformation(new Student("A", 100)), is("A,100"));
    }

    @Test
    public void should_output_different_students_information_in_different_line() {
        assertThat(display.displayInformation(students), is("A,100\n" +
                "B,80\n" +
                "C,59"));
    }

    @Test
    public void should_output_A100_using_js_display() {
        assertThat(display.jsDisplay(new Student("A", 100)), is("{A:100}"));
    }

    @Test
    public void should_output_all_students_using_js_display() {
        assertThat(display.jsDisplay(students), is("{A:100,B:80,C:59}"));
    }

    @Test
    public void should_output_A100_in_Roma_is_AC() {
        assertThat(display.displayInformationInRoma(new Student("A", 100)), is("A,C"));
    }

    @Test
    public void should_output_different_students_information_in_different_line_in_Roma() {
        assertThat(display.displayInformationInRoma(students), is("A,C\n" +
                "B,LXXX\n" +
                "C,LIX\n"));
    }
}                   
