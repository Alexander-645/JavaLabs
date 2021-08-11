package org.rptp.java.AsciiCharSequence;

import java.util.Arrays;

public class AsciiCharSequence implements CharSequence {
    byte[] byteArray;
    public AsciiCharSequence(byte[] byteArray) {
        this.byteArray = byteArray;
    }

    @Override
    public int length() {

            return byteArray.length;

    }

    @Override
    public char charAt(int index) {

        return (char) byteArray[index];

    }

    @Override
    public AsciiCharSequence subSequence(int start, int end) {
        return new AsciiCharSequence(Arrays.copyOfRange(byteArray, start, end));
    }

    @Override
    public String toString() {
        String resultString = new String(byteArray);
        return resultString;
    }
}
