package com.epam.alexandr_steblyuk.java.lesson_2;

import com.epam.alexandr_steblyuk.java.lesson_2.electrical_devices.*;
import com.epam.alexandr_steblyuk.java.lesson_2.utils.ElectricalDeviceHelper;

public class MainLessonTwo {
    public static void main(String[] args) {
        ElectricalDevice[] devices = {new MicrowaveDevice(), new Fridge(), new Toaster(), new CoffeeMachine()};
        ElectricalDeviceHelper.writeSortedDeviceArray(devices);
        ElectricalDeviceHelper.writeCorrectDevice(devices, 5000, 500, 400);
    }
}
