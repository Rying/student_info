package com.thoughtworks.ns;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by ry on 14-1-14.
 */
public class StudentTest {
    @Test
    public void should_get_100_Roma_score_is_C() {
        Student student = new Student("A", 100);
        assertThat(student.getRomaScore(), is("C"));
    }

    @Test
    public void should_get_80_Roma_score_is_LXXX() {
        Student student = new Student("B", 80);
        assertThat(student.getRomaScore(), is("LXXX"));
    }

    @Test
    public void should_get_59_Roma_score_is_LIX() {
        Student student = new Student("C", 59);
        assertThat(student.getRomaScore(), is("LIX"));
    }
}
