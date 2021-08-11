package org.rptp.java.GenericPair;

import java.util.Objects;

public class Pair <T, K> {
    private T variableT;
    private K variableK;

    private Pair(T var1, K var2) {
        this.variableT = var1;
        this.variableK = var2;
    }

    public static Pair of(Object value1, Object value2) {
        return new Pair(value1, value2);
    }

    public T getFirst() {
        return variableT;
    }

    public K getSecond() {
        return variableK;
    }

//    @Override
//    public boolean equals(Object obj) {
//        if(obj != null) {
//            if (obj instanceof Pair) {
//                return this.variableK == ((Pair<?, ?>) obj).variableK &&
//                        this.variableT == ((Pair<?, ?>) obj).variableT;
//            }
//        }
//        return false;
//    }
//
//    @Override
//    public int hashCode() {
//        int hash = 17;
//        hash = 37 * hash + variableK.hashCode();
//        hash = 37 * hash + variableT.hashCode();
//        return hash;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (getClass() != o.getClass()) return false;
        Pair<?, ?> pair = (Pair<?, ?>) o;
        return Objects.equals(variableT, pair.variableT) && Objects.equals(variableK, pair.variableK);
    }

    @Override
    public int hashCode() {
        return Objects.hash(variableT, variableK);
    }
}
