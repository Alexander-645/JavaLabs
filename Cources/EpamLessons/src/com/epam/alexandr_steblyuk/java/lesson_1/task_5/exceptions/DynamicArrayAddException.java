package com.epam.alexandr_steblyuk.java.lesson_1.task_5.exceptions;

public class DynamicArrayAddException extends RuntimeException{
    public String getMessage() {
        return "Add into Dynamic array was failed! :(";
    }
}
