package com.epam.alexandr_steblyuk.java.lesson_1.task_3;

import java.util.Arrays;

public enum Operation {
    SUB("-"){
        @Override
        double calculate(double x, double y) {
            return x - y;
        }
    },

    ADD("+") {
        @Override
        double calculate(double x, double y) {
            return x + y;
        }
    },

    MUL("*") {
        @Override
        double calculate(double x, double y) {
            return x * y;
        }
    },

    DIV("/") {
        @Override
        double calculate(double x, double y) {
            try {
                return x / y;
            } catch (ArithmeticException e) {
                return Double.NaN;
            }
        }

    },

    SQRT("sqrt") {
        @Override
        double calculate(double x, double y) {
            return Math.sqrt(x);
        }
    },

    GRADE("^") {
        @Override
        double calculate(double x, double y) {
            return Math.pow(x, y);
        }
    },

    UNSPECIFIED("\u0000") {
        @Override
        double calculate(double x, double y) {
            return Double.NaN;
        }
    };

    private String operation;
    abstract double calculate(double x, double y);

    Operation(String operation) {
        this.operation = operation;
    }

    public String getOperationChr() {
        return operation;
    }

    public static Operation getOperation(String operation) {
        for (Operation element: Operation.values()) {
            if(element.getOperationChr().equals(operation)) return element;
        }
        return UNSPECIFIED;
    }
}
