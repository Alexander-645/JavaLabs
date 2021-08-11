package com.epam.alexandr_steblyuk.java.lesson_1.task_6.without_streams;

import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CollectionsTester<T> {
    public void generateList() {
        List<Integer> arrayList = new ArrayList<Integer>();
        int element = 1;
        for (int i = 0; i < 100; i++) {
            arrayList.add(element++);
        }

        System.out.println(Arrays.toString(arrayList.toArray()));
    }

    public void delDuplicates(List<T> inputList) {
        for(int i = 0; i < inputList.size(); i++) {
            for(int j = i + 1; j < inputList.size(); j++) {
                if(inputList.get(i).equals(inputList.get(j))) {
                    inputList.remove(j);
                }
            }
        }
        System.out.println(Arrays.toString(inputList.toArray()));
    }

    public void findMinElement(List<Integer> inputList) {
        int min = inputList.get(0);

        for(Integer element:inputList) {
            if(element <= min)
                min = element.intValue();
        }

        System.out.println(min);
    }

    public void delElementsInOddPos(List<T> inputList) {
        for(int i = inputList.size() - 1; i >=0; i--) {
            if(i%2!=0)
                inputList.remove(i);
        }
        System.out.println(Arrays.toString(inputList.toArray()));
    }

    public void filterStringList(List<String> inputList) {
        Pattern pattern = Pattern.compile(ResourceBundle.getBundle("regex").getString("numbers"));
        Matcher matcher;
        for(int i = inputList.size() - 1; i >=0; i--) {
            matcher = pattern.matcher(inputList.get(i));
            if(!matcher.find())
                inputList.remove(i);
        }
        System.out.println(Arrays.toString(inputList.toArray()));
    }

    public void sortStringsForLength(List<String> inputList) {
        inputList.sort((o1, o2) -> Integer.compare(o2.length(), o1.length()));
        System.out.println(Arrays.toString(inputList.toArray()));
    }

    public void mixElementsOfList(List<T> inputList) {
        T element, oldElement;
        for(int i = 10; i < inputList.size(); i++) {
            int index = (int)(Math.random() * (inputList.size() - i) + i);
            if(index!=i) {
                element = inputList.get(i);
                oldElement = inputList.set(index, element);
                inputList.set(i, oldElement);
            }
        }
        System.out.println(Arrays.toString(inputList.toArray()));
    }
}
