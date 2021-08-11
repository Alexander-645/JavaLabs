package com.epam.alexandr_steblyuk.java.lesson_1.task_1;

public class ArrayGenerator {
    private int[] myArray;

    public ArrayGenerator(int capacity){
        myArray = new int[capacity];
        for (int i = 0; i < capacity; i++){
            myArray[i] = (int)((Math.random()+0.1) * 20 -11);
        }
    }

    public int[] getArray(){
        return myArray;
    }
}
