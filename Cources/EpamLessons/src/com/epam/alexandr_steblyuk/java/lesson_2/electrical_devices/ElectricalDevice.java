package com.epam.alexandr_steblyuk.java.lesson_2.electrical_devices;

public abstract class ElectricalDevice {
    int power;
    double height;
    double weight;
    boolean isOn = false;
    String name;

    public void turnOnButton() {
        if(isOn) {
            isOn = false;
        } else {
            isOn = true;
        }
    };
    public int getPower() {
        return power;
    };
    public String getSize() {
        return new String(height + "x" + weight);
    };
    public double getHeight() {
        return height;
    }
    public double getWeight() {
        return weight;
    }
    public boolean getIsOn() {
        return isOn;
    }
    public String getName() {
        return name;
    }
}
