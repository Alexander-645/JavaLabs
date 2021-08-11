package com.epam.alexandr_steblyuk.java.lesson_1.task_3;

public class Calculator {
    public static double doCalculation(String operation, double... arguments) {
        return Operation.getOperation(operation).calculate(arguments[0], arguments[1]);
    }
}
