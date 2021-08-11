package com.epam.alexandr_steblyuk.java.lesson_2.electrical_devices;

import java.util.SortedMap;

public class Fridge extends ElectricalDevice{
    public Fridge() {
        power = 20000;
        weight = 900;
        height = 1500;
        name = "Холодильничек";
    }

    public static void coolEverything(int celsi) {
        System.out.println("I`m coooooooooling everything!!!!!!!!!!!");
    }
}
