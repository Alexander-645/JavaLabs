package com.epam.alexandr_steblyuk.java.lesson_1.task_1;

import java.util.Arrays;

public class ArrayAggregator {

    public static int[] aggregateArray(int[] inputArray){
        int[] aggregatedArr = inputArray.clone();
        int maxId, minId;

        maxId = getMaxNegElemId(inputArray);
        minId = getMinPosElemId(inputArray);

        int buf;
        buf = aggregatedArr[maxId];
        aggregatedArr[maxId] = aggregatedArr[minId];
        aggregatedArr[minId] = buf;

        return aggregatedArr;
    }

    static int getMaxNegElemId(int[] arr){
        int max=-10, index = 0;
        for (int i = 0; i < arr.length; i++){
            if(arr[i] < 0 && max<=arr[i]){
                max = arr[i];
                index = i;
            }
        }
        return index;
    }

    static int getMinPosElemId(int[] arr){
        int min = 10, index = 0;
        for (int i = 0; i < arr.length; i++){
            if(arr[i] >= 0 && min>=arr[i]){
                min = arr[i];
                index = i;
            }
        }
        return index;
    }
}
