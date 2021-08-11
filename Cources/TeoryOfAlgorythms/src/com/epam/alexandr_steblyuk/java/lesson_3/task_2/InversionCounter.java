package com.epam.alexandr_steblyuk.java.lesson_3.task_2;

import java.io.*;

public class InversionCounter {
    long count;
    int[] temp;
    int[] a;

    public void calcCountOfInversions() throws IOException {
        BufferedReader bi = new BufferedReader(new InputStreamReader(System.in));

        int arrSize = Integer.parseInt(bi.readLine());
        a = new int[arrSize];

        String[] tokens = bi.readLine().split(" ");

        for(int i = 0; i < tokens.length; i++) {
            a[i] = Integer.parseInt(tokens[i]);
        }
        temp = new int[arrSize];

        sortArray(0, arrSize);

        System.out.println(count);

    }

    void sortArray(int l, int r) {
        int m = (l + r) >> 1;
        if(r <= l + 1)  return;

        sortArray(l, m);
        sortArray(m, r);
        mergeArr(l, m, r);
    }

    void mergeArr(int l, int m, int r) {
        int i = l, j = m;

        for(int index = l; index < r; index++) {
            if(j == r || (i < m && a[i] <= a[j])) {
                temp[index] = a[i];
                i++;
            } else {
                count += m - i;
                temp[index] = a[j];
                j++;
            }
        }

        System.arraycopy(temp, l, a, l, r - l);
    }
}
