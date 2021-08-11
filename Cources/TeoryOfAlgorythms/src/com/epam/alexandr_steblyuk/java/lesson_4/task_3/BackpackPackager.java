package com.epam.alexandr_steblyuk.java.lesson_4.task_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BackpackPackager {
    int[][] D;
    int[] objWeight;
    int capacity;

    public void run() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inputParams = br.readLine().split(" ");
        capacity = Integer.parseInt(inputParams[0]);
        int numOfObj = Integer.parseInt(inputParams[1]);
        objWeight = new int[numOfObj];
        D = new int[capacity + 1][numOfObj + 1];

        String[] inObjects = br.readLine().split(" ");

        for (int i = 0; i < numOfObj; i++) {
            objWeight[i] = Integer.parseInt(inObjects[i]);
        }

        for (int w = 1; w <= capacity; w++) {
             for (int i = 1; i <= numOfObj; i++) {
                 D[w][i] = D[w][i-1];
                if(objWeight[i-1] <= w) {
                    D[w][i] = Math.max(D[w][i], D[w-objWeight[i-1]][i-1] + objWeight[i-1]);
                }
            }
        }

        System.out.println(D[capacity][numOfObj]);

    }

}
