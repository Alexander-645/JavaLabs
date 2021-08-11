package org.rptp.java.Integrator;

import java.util.function.DoubleUnaryOperator;

public class Integrator {
    public static double integrate(DoubleUnaryOperator f, double a, double b) {
        double h, minH = 10e-5;
        double resultH = 0.0;
        double resultMinH = 0.0;

        do {
            h = minH;
            minH = h/2;

            for (double i = a; i <= b; i = i + h) {
                resultH += f.applyAsDouble(i) * ((i + h) - i);
            }

            for (double i = a; i <= b; i = i + minH) {
                resultMinH += f.applyAsDouble(i) * ((i + minH) - i);
            }
        }
        while (resultH - resultMinH > 10e-4);

       return resultMinH;
    }
}
