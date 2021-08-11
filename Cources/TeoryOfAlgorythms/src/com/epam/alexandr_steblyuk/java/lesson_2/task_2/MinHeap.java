package com.epam.alexandr_steblyuk.java.lesson_2.task_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinHeap {
    public List<Integer> minHeapArray;
    int nodeCount, maxValueId;

    public MinHeap() {
        minHeapArray = new ArrayList<>();
    }

    public void insertNode(int nodeValue) {
        int parentValue, parentIndex;
        minHeapArray.add(nodeValue);
        int curIndex = minHeapArray.indexOf(nodeValue);
        parentIndex = (curIndex-1)/2;
        while (curIndex!=0 && nodeValue < minHeapArray.get(parentIndex)) {
            parentValue = minHeapArray.set(parentIndex, nodeValue);
            minHeapArray.set(curIndex, parentValue);
            curIndex = parentIndex;
            parentIndex = (curIndex-1)/2;
        }
    }

    public void extractMaxValue() {
        nodeCount = minHeapArray.size();
        maxValueId = 0;
        for(int i = 1; i < nodeCount; i++) {
            if(minHeapArray.get(maxValueId) <= minHeapArray.get(i)) {
                maxValueId = i;
            }
        }

        System.out.println(minHeapArray.remove(maxValueId));
    }



//    public void writeTree() {
//        System.out.println(Arrays.toString(minHeapArray.toArray()));
//    }
}
