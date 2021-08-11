package com.epam.alexandr_steblyuk.java.lesson_5.task_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MaxStack {
    int[] stackOfValues;
    int[] maxStack;
    int topStackEl = -1, topMax = -1;


    public void run() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int number = Integer.parseInt(br.readLine());
        stackOfValues = new int[number];
        maxStack = new int[number];

        String[] inputCommands = new String[number];

        for (int i = 0; i < number; i++) {
            inputCommands[i] = br.readLine();
        }

        execCmd(inputCommands);
    }

    void execCmd(String[] cmdArray) {
        for (int i = 0; i < cmdArray.length; i++) {
            if (cmdArray[i].contains("push")) {
                push(Integer.parseInt(cmdArray[i].substring(5)));
            } else if (cmdArray[i].contains("pop")) {
                pop();
            } else if (cmdArray[i].contains("max")) {
                System.out.println(getTopMaxElement());
            }
        }
    }

    void push(int element) {
        stackOfValues[++topStackEl] = element;
        if (getTopMaxElement() < getTopStackEl()) {
            pushMax(element);
        }
    }

    void pushMax(int maxEl) {
        maxStack[++topMax] = maxEl;
    }

    int pop() {
        if (getTopMaxElement() == getTopStackEl()) {
            popMax();
        }

        return (topStackEl >= 0) ? stackOfValues[topStackEl--] : 0;
    }

    int popMax() {
        return (topMax >= 0) ? maxStack[topMax--] : 0;
    }

    int getTopStackEl() {
        return (topStackEl >= 0) ? stackOfValues[topStackEl] : 0;
    }

    int getTopMaxElement() {
        return (topMax >= 0) ? maxStack[topMax] : 0;
    }
}
