package org.rptp.java.ComplexNumber;

import java.util.Objects;

import static java.util.Objects.hash;

public class ComplexNumber {
    private final double re;
    private final double im;

    public ComplexNumber(double re, double im) {
        this.re = re;
        this.im = im;
    }

    public double getRe() {
        return re;
    }

    public double getIm() {
        return im;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o instanceof ComplexNumber &&
                this instanceof ComplexNumber &&
        this.im == ((ComplexNumber) o).im &&
                this.re == ((ComplexNumber) o).re) return true;
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(re, im);
    }


}
