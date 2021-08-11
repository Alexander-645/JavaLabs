package com.epam.alexandr_steblyuk.java.lesson_2.task_1.task_1_1.helpers;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class IOHelper {

    public static Map<Character, Integer> readCharsToMap(String filePath) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(filePath));
        Map<Character, Integer>  mapOfChars = new HashMap<>();
        int count = 0;

        while (scanner.hasNextLine()) {
            String currentLine = scanner.nextLine();
            for (int i = 0; i < currentLine.length(); i++) {
                char currentChar = currentLine.charAt(i);
                if(mapOfChars.containsKey(currentChar)) {
                    mapOfChars.put(currentChar, count++);
                }
                else {
                    count = 1;
                    mapOfChars.put(currentChar, count);
                }
            }
        }

        return mapOfChars;
    }

    public static String readStringFromFile(String filePath) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(filePath));
        StringBuilder stringBuilder = new StringBuilder();

        while (scanner.hasNextLine()) {
            stringBuilder.append(scanner.nextLine());
        }

        return stringBuilder.toString();
    }
}
