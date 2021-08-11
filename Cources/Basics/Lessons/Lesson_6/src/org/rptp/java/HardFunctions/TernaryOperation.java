package org.rptp.java.HardFunctions;

import java.util.Objects;
import java.util.function.Function;
import java.util.function.Predicate;

public class TernaryOperation {
    public static <T, U> Function<T,U> calculateTernaryOperation(
            Predicate<? super T> condition,
            Function<? super T, ? extends U> ifTrue,
            Function<? super T, ? extends U> ifFalse) {

        return x -> (condition.test(x)) ? ifTrue.apply(x) : ifFalse.apply(x);
    }
}

