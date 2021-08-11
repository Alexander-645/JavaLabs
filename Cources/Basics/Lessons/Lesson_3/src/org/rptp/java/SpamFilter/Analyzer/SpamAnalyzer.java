package org.rptp.java.SpamFilter.Analyzer;

import org.rptp.java.SpamFilter.Interfaces.TextAnalyzer;
import org.rptp.java.SpamFilter.Label;

import java.util.Locale;

public class SpamAnalyzer extends KeywordAnalyzer {
    private String[] keywords;

    public SpamAnalyzer(String[] keywords) {
        this.keywords = keywords;
    }

    @Override
    protected String[] getKeywords() {
        return keywords;
    }

    @Override
    protected Label getLabel() {
        return Label.SPAM;
    }

}

