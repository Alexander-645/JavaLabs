package com.epam.alexandr_steblyuk.java.lesson_1.task_5.exceptions;

public class DynamicArrayRemoveException extends IndexOutOfBoundsException{
    public String getMessage() {
        return "Remove element was failed!";
    }
}
