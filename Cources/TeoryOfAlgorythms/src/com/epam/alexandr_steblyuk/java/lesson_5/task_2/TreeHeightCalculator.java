package com.epam.alexandr_steblyuk.java.lesson_5.task_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TreeHeightCalculator {
    int[] nodesArray;

    public void run() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int size = Integer.parseInt(br.readLine());
        String[] inputNodes = br.readLine().split(" ");
        nodesArray = new int[size];

        for (int i = 0; i < nodesArray.length; i++) {
            nodesArray[i] = Integer.parseInt(inputNodes[i]);
        }

        System.out.println(getHeight(-1));
    }

    public int getHeight(int node) {
        int height = 0;

        for (int i = 0; i < nodesArray.length; i++) {
            if (nodesArray[i] == node) {
                height = Math.max(height, 1 + getHeight(i));
            }
        }
        return height;
    }
}
