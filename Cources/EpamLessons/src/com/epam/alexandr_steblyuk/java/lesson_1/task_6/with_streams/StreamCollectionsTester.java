package com.epam.alexandr_steblyuk.java.lesson_1.task_6.with_streams;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class StreamCollectionsTester<T> {
    public void generateList() {
        Stream<Integer> stream = Stream.iterate(1, n -> n + 1).limit(100);
        System.out.println(Arrays.toString(stream.toArray()));
    }

    public void delDuplicates(List<T> inputList) {
        System.out.println(Arrays.toString(Stream.of(inputList.toArray()).distinct().toArray()));
    }

    public void findMinElement(List<Integer> inputList) {
        System.out.println(Stream.of(inputList.toArray()).min(Comparator.comparingInt(i -> (Integer) i)).get());
    }

    public void delElementsInOddPos(List<T> inputList) {
        AtomicInteger index = new AtomicInteger();
        System.out.println(Arrays.toString(Stream.iterate(inputList.get(0), n -> inputList.get(index.incrementAndGet()))
                .limit(inputList.size())
                .filter(n->index.get()%2==0)
                .toArray()));
    }

    public void filterStringList(List<String> inputList) {
        Pattern pattern = Pattern.compile(ResourceBundle.getBundle("regex").getString("numbers"));
        Matcher matcher;
        AtomicInteger index = new AtomicInteger();
        System.out.println(Arrays.toString(Stream.iterate(inputList.get(0), n -> inputList.get(index.incrementAndGet()))
                .limit(inputList.size())
                .filter(t-> pattern.matcher(t).find()).toArray()));
    }

    public void sortStringsForLength(List<String> inputList) {
        AtomicInteger index = new AtomicInteger();

        Stream<String> stream = Stream.iterate(inputList.get(0), n -> inputList.get(index.incrementAndGet()))
                .limit(inputList.size())
                .sorted((o1, o2) -> Integer.compare(o2.length(), o1.length()));
        System.out.println(Arrays.toString(stream.toArray()));
    }

    public void mixElementsOfList(List<T> inputList) {
        AtomicInteger index = new AtomicInteger();

        List<T> resultList = Stream.iterate(inputList.get(0), n -> inputList.get(index.incrementAndGet()))
                .limit(inputList.size())
                .skip(10)
                .sorted((o1, o2) -> (int)(Math.random() * 2 - 2))
                .toList();

        for(int i = 10; i < inputList.size(); i++) {
            inputList.remove(i);
        }
        inputList.addAll(resultList);

        System.out.println(Arrays.toString(inputList.toArray()));
    }
}
