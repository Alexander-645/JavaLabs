package org.rptp.java.NumberSequenceFormatter;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class NumberSequenceFormatter {
    public static void format(InputStream inputStream) {
        List<Integer> integerArrayList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int i = 0;

        while (scanner.hasNext()) {
            int element = scanner.nextInt();
            if(i%2 != 0) {
                integerArrayList.add(element);
            }
            i++;
        }

        Collections.reverse(integerArrayList);

        integerArrayList.forEach(x -> System.out.print(x + " "));

    }
}
