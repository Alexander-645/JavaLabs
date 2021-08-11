package com.epam.alexandr_steblyuk.java.lesson_1.task_2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class BagPackager {
    public void packBag() {
        Scanner scanner = new Scanner(System.in);
        int objectVol = scanner.nextInt();
        double bagCapacity = scanner.nextInt();
        double maxPriceInBag = 0;
        double[][] objectsSpecsMatrix = new double[objectVol][2];

        for (int i = 0; i < objectVol; i++) {
            objectsSpecsMatrix[i][0] = scanner.nextInt();
            objectsSpecsMatrix[i][1] = scanner.nextInt();
        }

        Arrays.sort(objectsSpecsMatrix, Comparator.comparingDouble(o-> o[1] / o[0]));
        System.out.println(Arrays.toString(objectsSpecsMatrix[0]));

        for(int i = 0; i < objectVol && bagCapacity!=0;) {
            double objPrice = objectsSpecsMatrix[i][0];
            double objWeight = objectsSpecsMatrix[i][1];
            if(bagCapacity >= objWeight) {
                maxPriceInBag += objPrice;
                bagCapacity -= objWeight;
                i++;
            }
            else {
                objectsSpecsMatrix[i][0] = objPrice*bagCapacity/objWeight;
                objectsSpecsMatrix[i][1] = bagCapacity;
            }
        }

        System.out.printf("%.3f",maxPriceInBag);
    }
}
