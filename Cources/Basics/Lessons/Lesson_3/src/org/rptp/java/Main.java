package org.rptp.java;

import org.rptp.java.SpamFilter.Analyzer.NegativeTextAnalyzer;
import org.rptp.java.SpamFilter.Analyzer.SpamAnalyzer;
import org.rptp.java.SpamFilter.Analyzer.TooLongTextAnalyzer;
import org.rptp.java.SpamFilter.Interfaces.TextAnalyzer;
import org.rptp.java.SpamFilter.Output.TextAnalyzeOuter;

public class Main {

    public static void main(String[] args) {
	// write your code here
//        execTask1();
//        execTask2();
//        execTask3();
//
        execTask5();

    }

//    public static void execTask1() {
//        Robot.moveRobot(new Robot(), 5, 8);
//    }

//    public static void execTask2() {
//        ComplexNumber number1 = new ComplexNumber(2, 4);
//        ComplexNumber number2 = new ComplexNumber(2, 4);
//        System.out.println(number1.equals(number2));
//    }

//    public static void execTask3() {
//        System.out.println(Integrator.integrate(x -> 1, 0, 10));//10.0
//        System.out.println(Integrator.integrate(x -> x + 2, 0, 10));//70.0
//        System.out.println(Integrator.integrate( x -> Math.sin(x) / x , 1, 5));//0.603848
//    }

//    public static void execTask4() {
//        byte[] example = {72, 101, 108, 108, 111, 33};
//        AsciiCharSequence answer = new AsciiCharSequence(example);
//        System.out.println("Последовательность - " + answer.toString());//Hello!
//        System.out.println("Размер её - " + answer.length());//6
//        System.out.println("Символ под № 1 - " + answer.charAt(1));//e
//        System.out.println("Подпоследовательность - " + answer.subSequence(1, 5));//ello
////проверка на нарушение инкапсуляции private поля
//        System.out.println(answer.toString());//Hello!
//        example[0] = 74;
//        System.out.println(answer.toString());//Hello!
//    }

    public static void execTask5() {
        String message = "Выгодно предложение, акции покупаем, на рыб налетаем :( !!!!!";
        String[] spamKeywords = {"Продажа", "Акция", "Компенсация",
                "Скидки", "Выгодное предложение", "Не спам"};
        TextAnalyzer[] analyzers = {new NegativeTextAnalyzer(), new SpamAnalyzer(spamKeywords),
                new TooLongTextAnalyzer(1000)};
        System.out.println(TextAnalyzeOuter.checkLabels(analyzers, message));
    }
}
