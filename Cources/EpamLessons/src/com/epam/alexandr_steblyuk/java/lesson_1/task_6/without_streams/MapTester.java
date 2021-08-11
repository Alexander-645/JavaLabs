package com.epam.alexandr_steblyuk.java.lesson_1.task_6.without_streams;

import java.time.Month;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MapTester<T,K> {
    public void viewMap(Map<T,K> inputMap) {
        Set<Map.Entry<T,K>> entrySet = inputMap.entrySet();
        for (Map.Entry<T,K> entry : entrySet) {
            System.out.println(entry.getKey() + " is " + entry.getValue());
        }
    }

    public void generateMonthMap() {
        Map<Month, Integer> monthMap = new HashMap<>();
        for(Month month: Month.values()) {
            monthMap.put(month, month.getValue());
        }

        Set<Map.Entry<Month, Integer>> entrySet = monthMap.entrySet();
        for (Map.Entry<Month, Integer> entry : entrySet) {
            System.out.println(entry.getKey() + " is " + entry.getKey().toString().length());
        }
    }

    public static <K,T> Map<T,K> inverseMap(Map<K,T> inputMap) {
        Map<T,K> invMap = new HashMap<>();

        for(Map.Entry<K, T> entry:inputMap.entrySet()) {
            if(invMap.containsKey(entry.getValue())) {
                throw new IllegalArgumentException("Key " + entry.getValue() + " already exists!");
            }
            invMap.put(entry.getValue(), entry.getKey());
        }

        return invMap;
    }

    public static <K> Map<K,Integer> countDuplicates(List<K> inputList) {
        Map<K, Integer> resultMap = new HashMap<>();

        for (K element: inputList) {
            int count = 0;
            for (K dupElement:inputList) {
                if(element.equals(dupElement)) {
                    count++;
                }
            }
            if(count>1) {
                resultMap.put(element, count);
            }
        }

        return resultMap;
    }
}
