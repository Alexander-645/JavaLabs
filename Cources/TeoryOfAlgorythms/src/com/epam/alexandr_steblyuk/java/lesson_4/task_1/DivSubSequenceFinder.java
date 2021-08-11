package com.epam.alexandr_steblyuk.java.lesson_4.task_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DivSubSequenceFinder {
    int[] arrayA;
    int[] arrayD;
    int max = 0;

    public void run() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int size = Integer.parseInt(br.readLine());
        arrayA = new int[size];
        arrayD = new int[size];
        String[] A = br.readLine().split(" ");

        for (int i = 0; i < size; i++) {
            arrayA[i] = Integer.parseInt(A[i]);
        }


        for (int i = 0; i < size; i++) {
            arrayD[i] = 1;
            for (int j = 0; j <= i - 1; j++) {
                if (arrayA[j] >= arrayA[i] && arrayD[j] + 1 > arrayD[i])
                    arrayD[i] = arrayD[j] + 1;
            }
        }

        for (int i = 0; i < size; i++) {
            if(arrayD[i] > max) max = arrayD[i];
        }

        System.out.println(max);
        getIds();
    }

    void getIds() {
        StringBuilder sb = new StringBuilder();

        for(int i = 1; i < arrayA.length; i++) {
            if(arrayD[i] == arrayD[i-1] + 1 && arrayA[i-1] >= arrayA[i]) {
                sb.append(i).append(" ");
                if(i+1==arrayA.length)
                    sb.append(i+1);
            }
        }
        if(sb.toString().equals("")) sb.append(1);

        System.out.println(sb.toString());
    }
}
