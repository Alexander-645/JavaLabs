package com.epam.alexandr_steblyuk.java.lesson_4.task_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EditingDistanceCalculator {
    char[] fstExpArray;
    char[] scdExpArray;
    int[][] D;

    public void run() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        fstExpArray = br.readLine().toCharArray();
        scdExpArray = br.readLine().toCharArray();
        D = new int[fstExpArray.length + 1][scdExpArray.length + 1];

        calculate();
        System.out.println(D[fstExpArray.length][scdExpArray.length]);
        getAnswer();
    }

    void calculate() {
        for (int i = 0; i <= fstExpArray.length; i++) {
            D[i][0] = i;
        }

        for (int j = 1; j <= scdExpArray.length; j++) {
            D[0][j] = j;
        }

        for (int i = 1; i <= fstExpArray.length; i++) {
            for (int j = 1; j <= scdExpArray.length; j++) {
                int c = diff(fstExpArray[i-1], scdExpArray[j-1]);
                D[i][j] = Math.min(D[i-1][j] + 1, Math.min(D[i][j-1] + 1, D[i-1][j-1] + c));
            }
        }
    }

    int diff(char el1, char el2) {
        if(el1==el2) {
            return 0;
        }
        return 1;
    }

    void getAnswer() {
        StringBuilder fstString = new StringBuilder();
        StringBuilder scdString = new StringBuilder();
        int i = fstExpArray.length, j = scdExpArray.length;

        while (i + j > 0) {
            if (i > 0 && j > 0) {
                int expr = D[i][j] - diff(fstExpArray[i - 1], scdExpArray[j - 1]);
                if (expr == D[i - 1][j - 1]) {
                    i--;
                    j--;
                    fstString.append(fstExpArray[i]);
                    scdString.append(scdExpArray[j]);
                } else if (expr == D[i - 1][j]) {
                    i--;
                    fstString.append(fstExpArray[i]);
                    scdString.append(" ");
                } else if (expr == D[i][j - 1]) {
                    j--;
                    fstString.append(" ");
                    scdString.append(scdExpArray[j]);
                }
            } else if (j > 0) {
                j--;
                fstString.append(" ");
                scdString.append(scdExpArray[j]);
            } else {
                i--;
                fstString.append(fstExpArray[i]);
                scdString.append(" ");
            }
        }

        if(i==0) {

        }

        System.out.println(fstString.reverse().toString());
        System.out.println(scdString.reverse().toString());
    }

}
