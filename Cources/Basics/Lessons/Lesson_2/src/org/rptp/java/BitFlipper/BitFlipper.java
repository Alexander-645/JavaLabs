package org.rptp.java.BitFlipper;

public class BitFlipper {
    public static int flipBit(int value, int bitIndex) {
        return ((int)Math.pow(2, bitIndex-1) ^ value);
    }
}
