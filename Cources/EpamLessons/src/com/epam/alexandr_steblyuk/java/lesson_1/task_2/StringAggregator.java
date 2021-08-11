package com.epam.alexandr_steblyuk.java.lesson_1.task_2;

import java.util.List;

public class StringAggregator {
    private static String longestString = "", shortestString;

    public static void findShortString(List<String> stringList) {
        shortestString = stringList.get(0);
        for(int i = 0; i < stringList.size(); i++) {
            String anyString = stringList.get(i);
            if(anyString.length() >= longestString.length()) {
                longestString = anyString;
            }

            if(anyString.length() <= shortestString.length()) {
                shortestString = anyString;
            }
        }
    }

    public static String getLongestString() {
        return longestString;
    }

    public static String getShortestString() {
        return shortestString;
    }
}
