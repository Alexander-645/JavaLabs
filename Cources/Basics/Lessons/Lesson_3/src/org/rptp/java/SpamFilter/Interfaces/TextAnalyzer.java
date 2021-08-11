package org.rptp.java.SpamFilter.Interfaces;

import org.rptp.java.SpamFilter.Label;

public interface TextAnalyzer {
    Label processText(String text);
}
