package com.epam.alexandr_steblyuk.java.lesson_1.task_3;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MaxNumberOfTermCalculator {
    public void calculateTermNumber() {
        Scanner scanner = new Scanner(System.in);
        int inputNumber = scanner.nextInt();
        int currentNum = inputNumber;
        int term = 1;
        List<Integer> termsList = new ArrayList<>();

        while (currentNum > 0){
            int buf = currentNum - term;
            if(buf!=term && !termsList.contains(buf)) {
                currentNum = buf;
                termsList.add(term);
            }
            term++;
        }

        System.out.println(termsList.size());
        for (Integer element:termsList) {
            System.out.print(element + " ");
        }
    }
}
