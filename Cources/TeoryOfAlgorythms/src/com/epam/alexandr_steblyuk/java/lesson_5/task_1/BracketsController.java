package com.epam.alexandr_steblyuk.java.lesson_5.task_1;

import java.io.*;

public class BracketsController {
    Object[][] bracketsStack;
    int topId = -1;

    public void run() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inputStringSymbols = br.readLine().split("");
        bracketsStack = new Object[inputStringSymbols.length][2];

        for (int i = 0; i < inputStringSymbols.length; i++) {
            String currSymbol = inputStringSymbols[i];

            if(OpenBrackets.isInEnum(currSymbol)) {
                push(currSymbol, i + 1);
            } else if (CloseBrackets.isInEnum(currSymbol)) {
                if (!isEmpty() && isCouple(getTop(), currSymbol)) {
                    pop();
                } else {
                    System.out.println(i + 1);
                    System.exit(0);
                }
            }
        }

        if (isEmpty())
            System.out.println("Success");
        else
            System.out.println(bracketsStack[topId][1]);
    }

    void push(String curBrackets, int id) {
        bracketsStack[++topId][0] = curBrackets;
        bracketsStack[topId][1] = id;
    }

    String pop() {
        if (!isEmpty()) {
            return bracketsStack[topId--][0].toString();
        }

        return null;
    }

    String getTop() {
        return (!isEmpty()) ? bracketsStack[topId][0].toString() : null;
    }

    boolean isEmpty() {
        return (topId<0);
    }

    boolean isCouple(String stackSymbol, String inputSymbol) {
        return OpenBrackets.getName(stackSymbol).toString()
                .equals(CloseBrackets.getName(inputSymbol).toString());
    }
}

enum OpenBrackets {
    ROUND_BRACKET("(") {

    },
    FIGURE_BRACKET("{") {

    },
    RECT_BRACKET("[") {

    };

    String symbol;

    OpenBrackets(String symbol) {
        this.symbol = symbol;
    }

    static boolean isInEnum(String inputSymbol) {
        return inputSymbol.equals(ROUND_BRACKET.symbol)
                || inputSymbol.equals(RECT_BRACKET.symbol)
                || inputSymbol.equals(FIGURE_BRACKET.symbol);
    }

    static OpenBrackets getName(String inputSymbol) {
        if (inputSymbol.equals(ROUND_BRACKET.symbol))
            return ROUND_BRACKET;
        else if (inputSymbol.equals(RECT_BRACKET.symbol))
            return RECT_BRACKET;
        else if (inputSymbol.equals(FIGURE_BRACKET.symbol))
            return FIGURE_BRACKET;

        return null;
    }
}

enum CloseBrackets {
    ROUND_BRACKET(")") {

    },
    FIGURE_BRACKET("}") {

    },
    RECT_BRACKET("]") {

    };

    String symbol;

    CloseBrackets(String symbol) {
        this.symbol = symbol;
    }

    static boolean isInEnum(String inputSymbol) {
        return inputSymbol.equals(ROUND_BRACKET.symbol)
                || inputSymbol.equals(RECT_BRACKET.symbol)
                || inputSymbol.equals(FIGURE_BRACKET.symbol);
    }

    static CloseBrackets getName(String inputSymbol) {
        if (inputSymbol.equals(ROUND_BRACKET.symbol))
            return ROUND_BRACKET;
        else if (inputSymbol.equals(RECT_BRACKET.symbol))
            return RECT_BRACKET;
        else if (inputSymbol.equals(FIGURE_BRACKET.symbol))
            return FIGURE_BRACKET;

        return null;
    }
}
