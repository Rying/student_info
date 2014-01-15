package com.thoughtworks.ns;

import com.google.common.base.Function;
import com.google.common.base.Joiner;

import java.util.List;

import static com.google.common.collect.Lists.transform;

public class Display {

    public String displayInformation(Student student) {
        return student.getName() + "," + student.getScore();
    }

    public String displayInformation(List<Student> students) {
        return Joiner.on("").join(transform(students, getEachStudentInformation()));
    }

    private Function<Student, String> getEachStudentInformation() {
        return new Function<Student, String>() {
            @Override
            public String apply(Student student) {
                return displayInformation(student) + "\n";
            }
        };
    }

    public String jsDisplay(Student student) {
        return "{" + student.getName() + ":" + student.getScore() + "}";
    }

    public String jsDisplay(List<Student> students) {
        String output = "{" + students.get(0).getName() + ":" + students.get(0).getScore();

        for (int i = 1; i < students.size(); i++) {
            output += "," + students.get(i).getName() + ":" + students.get(i).getScore();
        }

        return output + "}";
    }

    public String displayInformationInRoma(Student student) {
        return student.getName() + "," + student.getRomaScore();
    }

    public String displayInformationInRoma(List<Student> students) {
        String str = "";

        for (Student student : students) {
            str += displayInformationInRoma(student) + "\n";
        }
        return str;
    }
}
