package com.epam.alexandr_steblyuk.java.lesson_2.task_2;

import java.util.ArrayList;
import java.util.List;

public class MaxHeap {
    public List<Integer> maxHeapArray;
    int nodeCount, maxValue;

    public MaxHeap() {
        maxHeapArray = new ArrayList<>();
    }

    public void insertNode(int nodeValue) {
        int parentValue, parentIndex;
        maxHeapArray.add(nodeValue);
        int curIndex = maxHeapArray.indexOf(nodeValue);
        parentIndex = (curIndex-1)/2;
        while (maxHeapArray.get(curIndex) > maxHeapArray.get(parentIndex)) {
            parentValue = maxHeapArray.get(parentIndex);
            maxHeapArray.set(parentIndex, maxHeapArray.get(curIndex));
            maxHeapArray.set(curIndex, parentValue);
            curIndex = parentIndex;
            parentIndex = (curIndex-1)/2;
        }
    }

    public void extractMaxValue() {
        maxValue = maxHeapArray.get(0);
        nodeCount = maxHeapArray.size();
        int curElement = maxHeapArray.get(nodeCount - 1);
        maxHeapArray.set(0, curElement);
        maxHeapArray.remove(nodeCount-1);
        siftDown(0);
        System.out.println(maxValue);
    }

    public void siftDown(int i) {
        int left, right, j;
        while (2 * i + 1 < maxHeapArray.size()) {
            left = 2 * i + 1;
            right = 2 * i + 2;
            j = left;
            if(right < maxHeapArray.size() && maxHeapArray.get(right) > maxHeapArray.get(left)) {
                j = right;
            }

            if(maxHeapArray.get(i) >= maxHeapArray.get(j)) {
                break;
            }

            int temp = maxHeapArray.get(i);
            maxHeapArray.set(i, maxHeapArray.get(j));
            maxHeapArray.set(j, temp);
            i = j;
        }
    }
}

