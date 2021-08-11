package com.epam.alexandr_steblyuk.java.lesson_1.task_3;

import java.util.InputMismatchException;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CalculatorHelper {

    public static void displayMenu() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("What do you want to do?:\n" +
                "Writes \'y\' to calculate expression;\n" +
                "Writes \'exit\' to exit.\n");
        while (true) {
            System.out.print("Your answer: ");
            try {
                String answer = scanner.next();
                if(answer.contains("y")) {
                    dispCalcMenu();
                } else if(answer.contains("exit")) {
                    System.exit(0);
                } else {
                    System.out.println("Illegal answer :(\n" +
                            "Try again, sweetie boy ;)\n");
                }
            } catch (InputMismatchException e) {
                System.out.println("OMG, it`s a very bad answer!\n" +
                                    "Common, give me a right answer.\n");
            }
            scanner = new Scanner(System.in);
        }
    }

    static void dispCalcMenu() {
        double[] arguments = new double[2];
        boolean reEn = false;

        while (true) {
            fillArguments(arguments, reEn);
            reEn = true;
        }
    }


    static void fillArguments(double[] arguments, boolean resEn) {
        Scanner scanner = new Scanner(System.in);
        String operation;
        String expression;
        Pattern operationPattern = Pattern.compile(ResourceBundle.getBundle("regex").getString("operation"));
        Pattern argumentPattern = Pattern.compile(ResourceBundle.getBundle("regex").getString("argument"));
        Matcher opMatcher;
        Matcher argMatcher;
        boolean expWriting = true;

        while (expWriting) {
            System.out.print("Input your expression: ");
            try {
                expression = scanner.nextLine();

                if(expression.equals("exit")) System.exit(0);

                argMatcher = argumentPattern.matcher(expression);
                opMatcher = operationPattern.matcher(expression);
                opMatcher.find();
                operation = expression.substring(opMatcher.start(), opMatcher.end());
                
                for (int i = (resEn)?1:0; i < 2 && argMatcher.find(); i++) {
                    arguments[i] = Double.parseDouble(expression.substring(argMatcher.start(), argMatcher.end()));
                }
                arguments[0] = Calculator.doCalculation(operation, arguments[0], arguments[1]);
                System.out.printf("Result of operation \'" + operation +
                        "\' is %.3f\n\n", arguments[0]);
                expWriting = false;

            } catch (InputMismatchException | IllegalStateException e) {
                System.out.println("OMG, invalid argument or operation! :(\n" +
                        "Try again, please.\n");
            }
            finally {
                scanner = new Scanner(System.in);
            }
        }
    }
}
