package com.epam.alexandr_steblyuk.java.lesson_3.task_4;

import java.io.*;
import java.util.Arrays;

public class CountSorter {

    int[] array;
    int[] sortedArray;
    int[] arrayOfCounts;

    public void run() throws IOException {
        BufferedReader bi = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(bi.readLine());
        array = new int[size];
        sortedArray = new int[size];
        String[] inputNumbers = bi.readLine().split(" ");

        for(int i = 0; i < size; i++) {
            array[i] = Integer.parseInt(inputNumbers[i]);
        }

        sort();

        for(int i = 0; i < size; i++) {
            System.out.print(sortedArray[i] + " ");
        }
    }

    void sort() {
        arrayOfCounts = new int[10];

        for(int j = 0; j < array.length; j++) {
            arrayOfCounts[array[j]-1] = arrayOfCounts[array[j]-1] + 1;
        }

        for(int i = 1; i < 10; i++) {
            arrayOfCounts[i] = arrayOfCounts[i] + arrayOfCounts[i - 1];
        }

        for(int j = array.length - 1; j >= 0; j--) {
            sortedArray[arrayOfCounts[array[j]-1] - 1] = array[j];
            arrayOfCounts[array[j] - 1 ] = arrayOfCounts[array[j] - 1] - 1;
        }
    }
}
