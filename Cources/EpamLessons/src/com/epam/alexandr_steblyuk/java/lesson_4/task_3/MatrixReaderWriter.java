package com.epam.alexandr_steblyuk.java.lesson_4.task_3;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatrixReaderWriter {

    public static int[][] readMatrix(String filePath) {
        Scanner scanner;
        List<List<Integer>> matrix = new ArrayList<>();
        Pattern numPattern = Pattern.compile(ResourceBundle.getBundle("regex").getString("numbers"));
        Matcher matcher;
        String currentRow;
        int rowNumber = -1;

        try(FileInputStream fileInputStream = new FileInputStream(filePath)) {
            scanner = new Scanner(fileInputStream);

            while (scanner.hasNextLine()) {
                currentRow = scanner.nextLine();
                matcher = numPattern.matcher(currentRow);
                rowNumber++;
                matrix.add(new ArrayList<>());
                while (matcher.find()) {
                    matrix.get(rowNumber).add(Integer.valueOf(currentRow.substring(matcher.start(), matcher.end())));
                }
            }
        }
        catch (IOException e) {
            System.out.println("Ups!");
        }

        int[][] outArray = new int[matrix.size()][matrix.get(0).size()];
        for(int i = 0; i < outArray.length; i++) {
            for(int j = 0; j < outArray[0].length; j++) {
                outArray[i][j] = matrix.get(i).get(j);
            }
        }

        return outArray;
    }

    public static void writeMatrixInFile(int[][] matrix) {
        int maxColElementSize = 0;
        StringBuilder rowBuilder = new StringBuilder();
        int elementLength = 0;
        String rightPadding;
        String leftPadding;

        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                maxColElementSize = getMaxElementLength(matrix, j);
                elementLength = String.valueOf(matrix[i][j]).length();
                leftPadding = " ".repeat((maxColElementSize - elementLength)/2);
                rowBuilder.append(leftPadding);
                rowBuilder.append(matrix[i][j]);
                rightPadding = " ".repeat(maxColElementSize - (elementLength + leftPadding.length()));
                rowBuilder.append(rightPadding);
            }
            rowBuilder.append("\n");
        }

        System.out.println(rowBuilder.toString());
    }

    static int getMaxElementLength(int[][] matrix, int colIndex) {
        int maxLength = String.valueOf(matrix[0][0]).length();
        int currentLength;

        for(int i = 0; i < matrix.length; i++) {
            currentLength = String.valueOf(matrix[i][colIndex]).length();
            if(maxLength < currentLength) {
                maxLength = currentLength;
            }
        }
        return maxLength;
    }
}
