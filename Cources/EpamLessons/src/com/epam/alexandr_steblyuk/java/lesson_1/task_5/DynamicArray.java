package com.epam.alexandr_steblyuk.java.lesson_1.task_5;

import com.epam.alexandr_steblyuk.java.lesson_1.task_5.exceptions.DynamicArrayAddException;
import com.epam.alexandr_steblyuk.java.lesson_1.task_5.exceptions.DynamicArrayCastException;
import com.epam.alexandr_steblyuk.java.lesson_1.task_5.exceptions.DynamicArrayRemoveException;

public class DynamicArray<T>{
    private T[] genericArray;
    final static int DEF_CAPACITY = 0;
    int currentCapacity = DEF_CAPACITY;


    public DynamicArray() {
        try {
            genericArray = (T[]) new Object[DEF_CAPACITY];
        } catch (DynamicArrayCastException e) {
            System.out.println(e.getMessage());
        }
    }

    @SafeVarargs
    public DynamicArray(T... elements) {
        currentCapacity = elements.length;
        genericArray = (T[]) new Object[currentCapacity];
        for (int i = 0; i < currentCapacity; i++) {
            genericArray[i] = elements[i];
        }
    }

    public void addElement(T element) {
        try {
            T[] oldGenericArray = genericArray.clone();
            genericArray = (T[]) new Object[++currentCapacity];
            for(int i = 0; i < currentCapacity - 1; i++) {
                genericArray[i] = oldGenericArray[i];
            }
            genericArray[currentCapacity-1] = element;
        } catch (DynamicArrayAddException | DynamicArrayCastException ex) {
            System.out.println(ex.getMessage());
        }

    }

    public void addElement(int index, T element) {
        try {
            if(index >= currentCapacity || index < 0)
                throw new DynamicArrayAddException();

            T[] oldGenericArray = genericArray.clone();
            genericArray = (T[]) new Object[++currentCapacity];
            if (index >= 0) System.arraycopy(oldGenericArray, 0, genericArray, 0, index);
            genericArray[index] = element;
            if (currentCapacity - index >= 0)
                System.arraycopy(oldGenericArray, index, genericArray, index + 1, currentCapacity - (index+1));
        } catch (DynamicArrayAddException | DynamicArrayCastException ex) {
            System.out.println(ex.getMessage());
        }

    }

    public T setElement(int index, T element) {
        T oldElement =(T) new Object();
        try {
            if (index >= currentCapacity || index < 0)
                throw new DynamicArrayAddException();
            oldElement = genericArray[index];
            genericArray[index] = element;
        } catch (DynamicArrayAddException | DynamicArrayCastException ex) {
            System.out.println(ex.getMessage());
        }

        return oldElement;
    }

    public T getElement(int index) {
        try {
            if (index >= currentCapacity || index < 0)
                throw new DynamicArrayAddException();
        } catch (DynamicArrayAddException | DynamicArrayCastException ex) {
            System.out.println(ex.getMessage());
        }

        return genericArray[index];
    }

    public String toString() {
        String elementsString = "[";

        for (T element:genericArray) {
            elementsString = elementsString + element;
        }
        elementsString = elementsString + "]";

        return elementsString;
    }

    public T removeElement(int index) {
        T oldElement =(T) new Object();
        try {
            if (index >= currentCapacity || index < 0)
                throw new DynamicArrayAddException();
            oldElement = genericArray[index];
            T[] oldGenericArray = genericArray.clone();
            genericArray = (T[]) new Object[--currentCapacity];
            System.arraycopy(oldGenericArray, 0, genericArray, 0, index);
            System.arraycopy(oldGenericArray,index+1, genericArray, index, currentCapacity-index);
        } catch (DynamicArrayRemoveException | DynamicArrayCastException ex) {
            System.out.println(ex.getMessage());
        }

        return oldElement;
    }

    public boolean containsElement(T element) {
        for(T elem: genericArray) {
            if (elem.equals(element))
                return true;
        }
        return false;
    }

    public int getSize() {
        return currentCapacity;
    }

}
