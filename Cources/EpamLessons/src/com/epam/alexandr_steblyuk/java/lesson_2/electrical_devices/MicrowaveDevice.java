package com.epam.alexandr_steblyuk.java.lesson_2.electrical_devices;

public class MicrowaveDevice extends ElectricalDevice {
    private double radiation = 10000000000.0;

    public MicrowaveDevice() {
        power = 2000;
        weight = 400;
        height = 500;
        name = "Микроволновочка";
    }

    public void setPower(int newPower) {
        power = newPower;
    }

    public void cookFood(int time, String food) {
        while (time-- > 1) {
            System.out.println(time);
        }
        System.out.println("BEEEEEEEEEEEEEEEEEEEP!\n" + "Your " + food + " was cooked! :)");
    }

    public double getRadiation() {
        return radiation;
    }

}
