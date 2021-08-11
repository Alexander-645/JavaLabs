package org.rptp.java.SpamFilter.Output;

import org.rptp.java.SpamFilter.Interfaces.TextAnalyzer;
import org.rptp.java.SpamFilter.Label;

public class TextAnalyzeOuter {
    public static Label checkLabels(TextAnalyzer[] analyzers, String text) {
        for (TextAnalyzer analyzer:analyzers) {
            if (!analyzer.processText(text).equals(Label.OK)) {
                return analyzer.processText(text);
            }
        }
        return Label.OK;
    }
}
