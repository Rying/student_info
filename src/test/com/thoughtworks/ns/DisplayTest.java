package com.thoughtworks.ns;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static com.thoughtworks.ns.Display.wrap;
import static com.thoughtworks.ns.NumberType.ROMA;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class DisplayTest {
    Display display = new Display();
    private final List<Student> students = new ArrayList<Student>();

    @Before
    public void setUp() {
        students.add(new Student("A", 100));
        students.add(new Student("B", 80));
        students.add(new Student("C", 59));
    }

    @Test
    public void should_output_is_A100() {
        assertThat(wrap(new Student("A", 100)).text().show(), is("A,100"));
    }

    @Test
    public void should_output_different_students_information_in_different_line_extra() {
        assertThat(wrap(students).text().show(), is("A,100\nB,80\nC,59"));
    }

    @Test
    public void should_output_A100_in_json_right() {
        assertThat(wrap(new Student("A", 100)).json().show(), is("{A:100}"));
    }

    @Test
    public void should_output_all_students_in_json_right() {
        assertThat(wrap(students).json().show(), is("{A:100,B:80,C:59}"));
    }

    @Test
    public void should_output_A100_in_Roma_is_AC() {
        assertThat(wrap(new Student("A", 100)).text(ROMA).show(), is("A,C"));
    }

    @Test
    public void should_output_different_students_information_in_different_line_in_Roma() {
        assertThat(wrap(students).text(ROMA).show(), is("A,C\n" +
                "B,LXXX\n" +
                "C,LIX"));
    }

    @Test
    public void should_output_A100_in_JsonRoma_is_right() {
        assertThat(wrap(new Student("A", 100)).json(ROMA).show(), is("{A:C}"));
    }

    @Test
    public void should_out_all_students_information_in_JsonRoma_is_right() {
        assertThat(wrap(students).json(ROMA).show(), is("{A:C,B:LXXX,C:LIX}"));
    }
}
