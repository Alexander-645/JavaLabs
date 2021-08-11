package com.epam.alexandr_steblyuk.java.lesson_1.task_4.education_programs;

import java.util.stream.Stream;

public enum JavaBasics implements EducationProgram {

    JAVA_FUNDAMENTALS("Java Fundamentals", 14){

    },

    OOP("OOP",20){

    },

    DATA_HANDLING("Data Handling", 10){

    },

    EXCEPTIONS("Exceptions", 16){

    },

    COLLECTIONS("Collections", 20){

    };

    public String courseName;
    public int time;
    public String name = "Java Basics";

    JavaBasics(String name, int time) {
        courseName = name;
        this.time = time;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getName() {
        return name;
    }

    public int getTime() {
        return time;
    }

    public int getProgramTime() {
        int programTime = 0;
        for (JavaBasics javaBasics: JavaBasics.values()) {
            programTime += javaBasics.time;
        }
        return programTime;
    }

}
