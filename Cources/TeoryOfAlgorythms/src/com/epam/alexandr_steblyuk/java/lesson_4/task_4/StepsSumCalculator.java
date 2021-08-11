package com.epam.alexandr_steblyuk.java.lesson_4.task_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class StepsSumCalculator {
    int[] stepsPrices;
    int[] resultPrices;

    public void run() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int stepsCount = Integer.parseInt(br.readLine());
        String[] inputPrices = br.readLine().split(" ");
        stepsPrices = new int[stepsCount];
        resultPrices = new int[stepsCount];

        for (int i = 0; i < stepsCount; i++) {
            stepsPrices[i] = Integer.parseInt(inputPrices[i]);
        }

        calculate();
        System.out.println(resultPrices[stepsCount-1]);
    }

    void calculate() {
        resultPrices[0] = stepsPrices[0];

        for (int i = 1; i < stepsPrices.length; i++) {
            int curSumm = stepsPrices[i] + resultPrices[i-1];
            if(curSumm >= resultPrices[i-1]) {
                resultPrices[i] = curSumm;
            } else {
                resultPrices[i] = resultPrices[i-1];
            }
        }
    }

}
