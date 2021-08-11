package org.rptp.java.DoubleFromTextParser;

import java.io.InputStream;
import java.io.Reader;
import java.util.InputMismatchException;
import java.util.Scanner;

import static java.lang.Double.parseDouble;

public class DoubleFromTextParser {
    public static void parseText(Reader reader) {
        Scanner scanner = new Scanner(reader);
        double sum = 0;
        while (scanner.hasNext()) {
            try {
                sum += parseDouble(scanner.next());
            } catch (InputMismatchException e) {
                continue;
            }
        }

        System.out.printf("%.6f", sum);
    }
}
