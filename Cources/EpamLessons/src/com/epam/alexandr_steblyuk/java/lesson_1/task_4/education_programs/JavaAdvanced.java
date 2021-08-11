package com.epam.alexandr_steblyuk.java.lesson_1.task_4.education_programs;

public enum JavaAdvanced implements EducationProgram {

    JAVA_IO("Java IO", 10){

    },

    JDBC("JDBC", 15){

    },

    JAXP("JAXP", 15){

    };

    public String courseName;
    public static String name = "Java Advanced";
    public int time;

    JavaAdvanced(String name, int time) {
        this.courseName = name;
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
        for (JavaAdvanced javaAdvanced: JavaAdvanced.values()) {
            programTime += javaAdvanced.time;
        }
        return programTime;
    }

}
