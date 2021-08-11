package com.epam.alexandr_steblyuk.java.lesson_3.task_1;

import java.util.Scanner;

public class BinFinder {
    public void calculate() {
        Scanner scanner = new Scanner(System.in);

        int arrSize = scanner.nextInt();
        int[] arrayOfNumbers = new int[arrSize];

        for (int i = 0; i < arrSize; i++) {
            arrayOfNumbers[i] = scanner.nextInt();
        }

        int secArrSize = scanner.nextInt();
        System.out.println();

        for(int i = 0; i < secArrSize; i++) {
            int startId = 0;
            int lastId = arrSize - 1;
            int currId = -1;
            int second = scanner.nextInt();

            for(int j = startId; j <= lastId && scanner.hasNextInt(); j++) {
                int m = (lastId+startId)>>1;
                int first = arrayOfNumbers[m];
                if(second < first) {
                    lastId = m-1;
                }
                else if(second > first) {
                    startId = m + 1;
                }
                else {
                    currId = m+1;
                    break;
                }
            }

            System.out.print(currId + " ");
        }



    }
}
