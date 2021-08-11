package com.epam.alexandr_steblyuk.java.lesson_1.task_5.exceptions;

public class DynamicArrayCastException extends ClassCastException {
    public String getMessage() {
        return  "Cast to array type was failed! :(";
    }
}
