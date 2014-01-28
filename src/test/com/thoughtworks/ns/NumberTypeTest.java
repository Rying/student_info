package com.thoughtworks.ns;

import org.junit.Test;

import static com.thoughtworks.ns.NumberType.ARABIC;
import static com.thoughtworks.ns.NumberType.ROMA;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class NumberTypeTest {

    @Test
    public void should_get_100_Roma_score_is_C() {
        Student student = new Student("A", 100);
        assertThat(getRomaScore(student), is("C"));
    }

    @Test
    public void should_get_80_Roma_score_is_LXXX() {
        Student student = new Student("B", 80);
        assertThat(getRomaScore(student), is("LXXX"));
    }

    @Test
    public void should_get_59_Roma_score_is_LIX() {
        Student student = new Student("C", 59);
        assertThat(getRomaScore(student), is("LIX"));
    }

    @Test
    public void should_get_arabic_score(){
        Student student = new Student("A", 100);
        assertThat(ARABIC.scoreFinder().score(student.getScore()), is("100"));
    }

    private String getRomaScore(Student student) {
        return ROMA.scoreFinder().score(student.getScore());
    }
}
