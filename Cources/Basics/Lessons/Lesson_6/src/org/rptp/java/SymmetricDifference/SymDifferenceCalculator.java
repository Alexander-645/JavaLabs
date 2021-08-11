package org.rptp.java.SymmetricDifference;

import java.util.HashSet;
import java.util.Set;

public class SymDifferenceCalculator {
    public static <T> Set<T> calculateDifference(Set<? extends T> set1, Set<? extends T> set2) {
        Set<T> resultSet = new HashSet<>();
        for (T element: set2) {
            if(!set1.contains(element)) {
                resultSet.add(element);
            }
        }

        for (T element: set1) {
            if(!set2.contains(element)) {
                resultSet.add(element);
            }
        }

        return resultSet;
    }
}
