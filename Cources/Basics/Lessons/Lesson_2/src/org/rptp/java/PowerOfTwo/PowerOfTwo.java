package org.rptp.java.PowerOfTwo;

public class PowerOfTwo {
    public static boolean isPowerOfTwo(int value) {
        return Integer.bitCount((int)Math.abs(value)) == 1;
    }
}
