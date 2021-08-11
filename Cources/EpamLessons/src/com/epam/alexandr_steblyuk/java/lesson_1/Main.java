package com.epam.alexandr_steblyuk.java.lesson_1;

import com.epam.alexandr_steblyuk.java.lesson_1.task_1.ArrayAggregator;
import com.epam.alexandr_steblyuk.java.lesson_1.task_1.ArrayGenerator;
import com.epam.alexandr_steblyuk.java.lesson_1.task_1.ArrayHelper;
import com.epam.alexandr_steblyuk.java.lesson_1.task_2.StringAggregator;
import com.epam.alexandr_steblyuk.java.lesson_1.task_2.StringHelper;
import com.epam.alexandr_steblyuk.java.lesson_1.task_3.CalculatorHelper;
import com.epam.alexandr_steblyuk.java.lesson_1.task_4.EducationPlan;
import com.epam.alexandr_steblyuk.java.lesson_1.task_4.Student;
import com.epam.alexandr_steblyuk.java.lesson_1.task_4.education_programs.JavaAdvanced;
import com.epam.alexandr_steblyuk.java.lesson_1.task_4.education_programs.JavaBasics;
import com.epam.alexandr_steblyuk.java.lesson_1.task_5.DynamicArray;
import com.epam.alexandr_steblyuk.java.lesson_1.task_6.with_streams.StreamCollectionsTester;
import com.epam.alexandr_steblyuk.java.lesson_1.task_6.with_streams.StreamMapTester;
import com.epam.alexandr_steblyuk.java.lesson_1.task_6.without_streams.CollectionsTester;
import com.epam.alexandr_steblyuk.java.lesson_1.task_6.without_streams.MapTester;

import java.time.LocalDateTime;
import java.util.*;

public class Main {

    public static void main(String[] args) {
	// write your code here
        execTask6();
    }


    static void execTask1() {
        ArrayGenerator arrayGenerator = new ArrayGenerator(20);
        ArrayHelper.outputArray(arrayGenerator.getArray());
        ArrayHelper.outputArray(ArrayAggregator.aggregateArray(arrayGenerator.getArray()));
    }

    static void execTask2() {
        StringAggregator.findShortString(StringHelper.readStrings());
        System.out.println("The longest string is: " + StringAggregator.getLongestString() + " with length "
                + StringAggregator.getLongestString().length());
        System.out.println("The shortest string is: " + StringAggregator.getShortestString() + " with length "
                + StringAggregator.getShortestString().length());
    }

    static void execTask3() {
        CalculatorHelper.displayMenu();
    }

    static void execTask4() {
        Student steblyukStudent = new Student("Александр Стеблюк");
        Student alexStudent = new Student("Алексий Телкин");

        EducationPlan educationPlan = new EducationPlan(Arrays.asList(steblyukStudent, alexStudent),
                Arrays.asList(JavaBasics.values(), JavaAdvanced.values()));
        LocalDateTime date = LocalDateTime.now();

        System.out.println(educationPlan.getEducationPlan(date));
    }

    static void execTask5() {
        DynamicArray<Integer> dynamicArray = new DynamicArray<>(1,2,3,4);
        System.out.println(dynamicArray.toString());
        dynamicArray.addElement(5);
        System.out.println(dynamicArray.toString());
        dynamicArray.removeElement(2);
        System.out.println(dynamicArray.toString());
        boolean contains = dynamicArray.containsElement(1);
        System.out.println(contains);
        dynamicArray.addElement(1, 6);
        System.out.println(dynamicArray.toString());
        System.out.println(dynamicArray.getElement(1));
        dynamicArray.setElement(2, 7);
        System.out.println(dynamicArray.toString());
        System.out.println(dynamicArray.getSize());

    }

    static void execTask6() {
        CollectionsTester collectionsTester = new CollectionsTester();
        //collectionsTester.generateList();

        StreamCollectionsTester streamCollectionsTester = new StreamCollectionsTester();
        streamCollectionsTester.generateList();

       List<String> testList = new ArrayList<>(Arrays.asList("Саша", "Masha", "Dasha",
               "Sasha", "Саша", "Sasha12", "Masha", "Masha"));
//        collectionsTester.delDuplicates(testList);
      List<Integer> testIntList = new ArrayList<>(Arrays.asList(-1, 1, 5 ,4, -10, 20, 5, 7, 4, 6 ,1, 2 ,3 ,4 ,5 ,6));
//      streamCollectionsTester.delDuplicates(testIntList);
//      streamCollectionsTester.findMinElement(testIntList);
//      streamCollectionsTester.delElementsInOddPos(testIntList);
//      streamCollectionsTester.filterStringList(testList);
//      streamCollectionsTester.sortStringsForLength(testList);
//      streamCollectionsTester.mixElementsOfList(testIntList);
//        collectionsTester.findMinElement(testIntList);
//        collectionsTester.delElementsInOddPos(testList);
//        collectionsTester.filterStringList(testList);
//        collectionsTester.sortStringsForLength(testList);
//        collectionsTester.mixElementsOfList(testIntList);

        MapTester mapTester = new MapTester();
        StreamMapTester streamMapTester = new StreamMapTester();
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "One");
        map.put(2, "Two");
        map.put(3, "Three");
        map.put(4, "Three");
        //mapTester.viewMap(map);
        //mapTester.generateMonthMap();
        //mapTester.viewMap(MapTester.inverseMap(map));
        //mapTester.viewMap(MapTester.countDuplicates(testList));
        streamMapTester.viewMap(StreamMapTester.countDuplicates(testList));

    }
}
