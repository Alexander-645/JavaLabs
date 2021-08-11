package com.epam.alexandr_steblyuk.java.lesson_1.task_6.with_streams;

import java.time.Month;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.function.UnaryOperator.identity;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class StreamMapTester<T,K> {
    public void viewMap(Map<T, K> inputMap) {
        inputMap.forEach((key, value) -> System.out.println(key + " is " + value));
    }

    public static Map<Month, Integer> generateMonthMap() {
        return Stream.of(Month.values()).collect(Collectors.toMap(e->e, e->e.toString().length()));
    }

    public static <K,T> Map<T,K> inverseMap(Map<K,T> inputMap) {
        return inputMap.entrySet().stream().collect(Collectors.toMap(Map.Entry::getValue, Map.Entry::getKey));
    }

    public static <K> Map<K, Integer> countDuplicates(List<K> inputList) {
        return inputList.stream()
                .collect(groupingBy(identity(), counting()))
                .entrySet()
                .stream()
                .filter(e->e.getValue()>1)
                .collect(Collectors.toMap(Map.Entry::getKey, e->e.getValue().intValue()));
    }
}
