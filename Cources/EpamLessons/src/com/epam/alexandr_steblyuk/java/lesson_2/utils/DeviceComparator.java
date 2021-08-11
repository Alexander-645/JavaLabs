package com.epam.alexandr_steblyuk.java.lesson_2.utils;

import com.epam.alexandr_steblyuk.java.lesson_2.electrical_devices.ElectricalDevice;

import java.util.Comparator;

public class DeviceComparator implements Comparator<ElectricalDevice> {
    @Override
    public int compare(ElectricalDevice o1, ElectricalDevice o2) {
        return (o1.getPower()>o2.getPower()) ? -1 : (o1.getPower() < o2.getPower()) ? 1 : 0;
    }
}
