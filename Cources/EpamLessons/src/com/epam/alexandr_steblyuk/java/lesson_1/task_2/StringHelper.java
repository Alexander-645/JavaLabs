package com.epam.alexandr_steblyuk.java.lesson_1.task_2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StringHelper {
    public static List<String> readStrings() {
        List stringList = new ArrayList<String>();
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextLine()) {
            stringList.add(scanner.nextLine());
        }
        return stringList;
    }
}
