package com.epam.alexandr_steblyuk.java.lesson_3.task_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;

public class SegmentsSorter {
    int[][] segmentsArr;
    int[] dotsArr;
    int m;
    int count = 0;

    public void run() throws IOException {
        BufferedReader bi = new BufferedReader(new InputStreamReader(System.in));
        int segmentsCount, dotsCount;

        String[] inputParams = bi.readLine().split(" ");

        segmentsCount = Integer.parseInt(inputParams[0]);
        dotsCount = Integer.parseInt(inputParams[1]);

        dotsArr = new int[dotsCount];
        segmentsArr = new int[segmentsCount][2];

        for(int i = 0; i < segmentsCount; i++) {
            String[] segments = bi.readLine().split(" ");
            for (int j = 0; j < segments.length; j++) {
                segmentsArr[i][j] = Integer.parseInt(segments[j]);
            }
        }

        String[] dots = bi.readLine().split(" ");
        for (int j = 0; j < dotsCount; j++) {
            dotsArr[j] = Integer.parseInt(dots[j]);
        }

        sort(0, segmentsCount);
        findInclusion();
    }

    void sort(int l, int r) {
        if(l >= r) return;

        int index = (int)(Math.random() * segmentsArr.length);
        swap(l, index);
        partition(l, r);

        sort(l, m);
        sort(m+1, r);
    }

    void partition(int l, int r) {
        int j = l, i = j + 1;

        for(int k = l + 1; k < r; k++) {
            if(segmentsArr[k][1] <= segmentsArr[l][1]) {
                j++;
                swap(k, j);
            }
        }

        swap(l, j);
        m = j;
    }

    void swap(int l, int index) {
        int[] temp = segmentsArr[l];

        segmentsArr[l] = segmentsArr[index];
        segmentsArr[index] = temp;

    }

    void findInclusion() {
        for(int j = 0; j < dotsArr.length; j++) {
            for(int i = 0; i < segmentsArr.length; i++) {
                if(dotsArr[j] <= segmentsArr[i][1] && dotsArr[j] >= segmentsArr[i][0]) {
                    count++;
                }
            }
            System.out.print(count + " ");
            count = 0;
        }
    }
}
