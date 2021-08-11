package com.company;

import com.company.lesson_1.Quiz;

public class Main {

    public static void main(String[] args) {
        // write your code here
        System.out.println("Hello world!");
        try {
            Quiz.say();
        }
        catch (Exception e) {
            System.out.println("ERROR");
        }
    }
}
