package com.thoughtworks.ns;

import com.google.common.collect.Lists;

import java.util.List;

import static com.thoughtworks.ns.NumberType.ARABIC;

public class Display {

    private final List<Student> students;
    private String representation = "";

    public Display(List<Student> students) {
        this.students = Lists.newArrayList(students);
    }

    public static Display wrap(Student... student) {
        return new Display(Lists.newArrayList(student));
    }

    public static Display wrap(List<Student> students) {
        return new Display(students);
    }


    public Display text() {
        return text(ARABIC);
    }

    public Display json() {
        return json(ARABIC);
    }

    public String show() {
        return this.representation;
    }

    public Display text(NumberType type) {
        joinWith(",", "\n", type.getScoreFinder());
        removeLastCharacter();
        return this;
    }

    public Display json(NumberType type) {
        representation += "{";
        joinWith(":", ",", type.getScoreFinder());
        removeLastCharacter();
        representation += "}";
        return this;
    }

    private void removeLastCharacter() {
        representation = representation.substring(0, representation.length() - 1);
    }

    private void joinWith(String middle, String last, Score score) {
        for (Student student : students) {
            representation += student.getName() + middle + score.getScore(student.getScore()) + last;
        }
    }
}

