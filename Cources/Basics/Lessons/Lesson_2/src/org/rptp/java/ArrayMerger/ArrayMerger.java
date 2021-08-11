package org.rptp.java.ArrayMerger;


import java.util.Arrays;

public class ArrayMerger {
    public static int[] mergeArrays(int[] a1, int[] a2) {
        Arrays.sort(a1);
        Arrays.sort(a2);

        int[] resultArray = new int [a1.length + a2.length];
        int j, i, k;
        j = i = k = 0;

        while (i < a1.length && j < a2.length) {
            if (a1[i] <=  a2[j]) {
                resultArray[k++] = a1[i++];
            }
            else {
                resultArray[k++] = a2[j++];
            }
        }

        while (i < a1.length) {
            resultArray[k++] = a1[i++];
        }

        while (j < a2.length) {
            resultArray[k++] = a2[j++];
        }

        return resultArray;
    }

}

