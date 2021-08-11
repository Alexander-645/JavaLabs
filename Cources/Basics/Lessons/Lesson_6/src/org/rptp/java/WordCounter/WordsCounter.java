package org.rptp.java.WordCounter;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

import static java.util.function.UnaryOperator.identity;
import static java.util.stream.Collectors.*;

public class WordsCounter {
    public static void calculateWords(InputStream inputStream) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
        reader.lines()
                .flatMap(s -> Arrays.stream(s.split("\\s*[-|,|!|\\.| |\\r\\n|\\n]")))
                .map(String::toLowerCase)
                .collect(groupingBy(identity(), counting()))
                .entrySet()
                .stream()
                .sorted((x,y)->(x.getValue() > y.getValue())?-1:((x.getValue() == y.getValue()))?x.getKey().compareTo(y.getKey()):1)
                .map(z->z.getKey())
                .limit(10)
                .forEach(System.out::println);
    }
}
