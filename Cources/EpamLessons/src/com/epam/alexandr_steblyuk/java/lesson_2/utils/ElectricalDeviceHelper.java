package com.epam.alexandr_steblyuk.java.lesson_2.utils;

import com.epam.alexandr_steblyuk.java.lesson_2.electrical_devices.ElectricalDevice;

import java.util.Arrays;

public class ElectricalDeviceHelper {
    public static void writeSortedDeviceArray(ElectricalDevice[] devices) {
        ElectricalDevice[] sortDevices = Arrays.stream(devices)
                .sorted(new DeviceComparator())
                .toArray(ElectricalDevice[]::new);

        for (ElectricalDevice device:sortDevices) {
            System.out.println(device.getName() + " " + device.getPower());
        }
    }

    public static void writeCorrectDevice(ElectricalDevice[] devices, int power, double weight, double height) {
        ElectricalDevice[] correctDevices = Arrays.stream(devices)
                .filter(device ->  device.getPower() >= power && (device.getWeight()
                        * device.getHeight()) >= weight * height)
                .toArray(ElectricalDevice[]::new);

        for (ElectricalDevice device : correctDevices) {
            System.out.println(device.getName() + " " + device.getPower()+ " " + device.getSize());
        }
    }
}
