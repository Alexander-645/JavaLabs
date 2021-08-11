package org.rptp.java.SpamFilter.Analyzer;

import org.rptp.java.SpamFilter.Interfaces.TextAnalyzer;
import org.rptp.java.SpamFilter.Label;

import java.util.Locale;

public class NegativeTextAnalyzer extends KeywordAnalyzer {
    private String[] keywords = {"=(", ":(", ":|", "=|"};

    @Override
    protected String[] getKeywords() {
        return keywords;
    }

    @Override
    protected Label getLabel() {
        return Label.NEGATIVE_TEXT;
    }

}
