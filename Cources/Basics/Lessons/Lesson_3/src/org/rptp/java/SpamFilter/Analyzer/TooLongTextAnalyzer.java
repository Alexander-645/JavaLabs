package org.rptp.java.SpamFilter.Analyzer;

import org.rptp.java.SpamFilter.Interfaces.TextAnalyzer;
import org.rptp.java.SpamFilter.Label;

public class TooLongTextAnalyzer implements TextAnalyzer {
    private int maxLength;

    public TooLongTextAnalyzer(int commentLength) {
        this.maxLength = commentLength;
    }

    @Override
    public Label processText(String text) {
        return (text.length() <maxLength ) ? Label.OK : Label.TOO_LONG;
    }
}
