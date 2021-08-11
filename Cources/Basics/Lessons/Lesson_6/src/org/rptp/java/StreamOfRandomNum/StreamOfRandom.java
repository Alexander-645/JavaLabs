package org.rptp.java.StreamOfRandomNum;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamOfRandom {
    public static IntStream runStream(int number) {
        return IntStream.iterate(number, n -> (n * n)/10%1000);
    }
}
