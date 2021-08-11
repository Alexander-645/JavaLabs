package org.rptp.java.SpamFilter.Analyzer;

import org.rptp.java.SpamFilter.Interfaces.TextAnalyzer;
import org.rptp.java.SpamFilter.Label;

import java.util.Locale;

public abstract class KeywordAnalyzer implements TextAnalyzer {
    protected abstract String[] getKeywords();
    protected abstract Label getLabel();

    @Override
    public Label processText(String text) {
        for (String keyword:getKeywords()) {
            if(text.contains(keyword.toLowerCase(Locale.ROOT))
                    || text.startsWith(keyword)
                    || text.endsWith(keyword)) {
                return getLabel();
            }
        }
        return Label.OK;
    }
}
