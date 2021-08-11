package com.epam.alexandr_steblyuk.java.lesson_3.utils.out_data_generators;

import com.epam.alexandr_steblyuk.java.lesson_3.text.Sentence;
import com.epam.alexandr_steblyuk.java.lesson_3.text.Word;
import com.epam.alexandr_steblyuk.java.lesson_3.utils.parsers.TextParser;

import java.util.*;
import java.util.stream.Collectors;

public class TableGenerator {

    public String genTable(int maxSentenceLength, int paddingSize, String fileContent) {
        HashMap<String, Integer> sm = new HashMap();
        List<Sentence> sentenceList = TextParser.parseFileToSentences(fileContent);
        Set s;

        for (Sentence sentence: sentenceList) {
            sm.put(sentence.getContent(), Sentence.compCountOfWords(sentence.getContent()));
        }

        s = sm.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new))
                .entrySet();

        String title1 = "  №  ", title2 = "Sentences", title3 = " Word`s Count ";
        StringBuilder tableBuilder = new StringBuilder();
        int headLength = maxSentenceLength + 2*paddingSize + title1.length() + title3.length() + 1;

        tableBuilder.append("\n");
        tableBuilder.append(genTabHead(maxSentenceLength + 2*paddingSize, headLength, title1, title2, title3));
        tableBuilder.append(genTabBody(maxSentenceLength, s, paddingSize,
                        headLength, title1.length(), title3.length()));

        return tableBuilder.toString();
    }

    static String genTabHead(int sentenceLength, int headLength, String... titles) {
        StringBuilder tabHead = new StringBuilder();
        tabHead.append("|");
        String title1 = titles[0], title2 = titles[1], title3 = titles[2];

        for(int i = 0; i <= headLength; i++) {
            tabHead.append("=");
        }
        tabHead.append("|\n");
        tabHead.append("|" + title1 + "|");
        for(int j = 0; j <= sentenceLength; j++) {
            if(j == (sentenceLength -title2.length())/2) {
                tabHead.append(title2);
                j+=title2.length();
            }
            else tabHead.append(" ");
        }
        tabHead.append("|" + title3 + "|\n");
        tabHead.append(genRowSeparator('+', '=', headLength, title1.length(), title3.length()));
        return tabHead.toString();
    }

    static String genTabBody(int sentenceLength, Set s, int padding, int headLength, int... titleLengths) {
        StringBuilder tabBodyBuilder = new StringBuilder();
        Iterator i = s.iterator();
        int counter = 0;

        while (i.hasNext())
        {
            Map.Entry m = (Map.Entry)i.next();
            int value = (Integer)m.getValue();
            StringBuilder sentenceBuilder = new StringBuilder();
            List<Word> wordList = Sentence.getListOfWords(m.getKey().toString());
            int length = 0;
            for(Word s1: wordList) {
                length +=s1.getContent().length();
                if(length <= sentenceLength) {
                    sentenceBuilder.append(s1.getContent());
                    sentenceBuilder.append(" ");
                    length = sentenceBuilder.length();
                }
                else break;
            }
            counter++;
            String key = sentenceBuilder.toString();

            tabBodyBuilder.append("|" + counter);

            for(int k = 0; k < titleLengths[0] - String.valueOf(counter).length(); k++) {
                tabBodyBuilder.append(" ");
            }

            tabBodyBuilder.append("|");
            for (int j = 0; j <= sentenceLength + 2*padding; j++) {
                if(j == (sentenceLength - key.length())/2 + padding) {
                    tabBodyBuilder.append(key);
                    j+=key.length();
                }
                else tabBodyBuilder.append(" ");
            }

            tabBodyBuilder.append("|");

            for(int k = 0; k < titleLengths[1] - String.valueOf(value).length(); k++) {
                tabBodyBuilder.append(" ");
            }
            tabBodyBuilder.append(value + "|\n");
            if(i.hasNext())
                tabBodyBuilder.append(genRowSeparator('+', '-',
                        headLength, titleLengths[0], titleLengths[1]));
            else
                tabBodyBuilder.append(genRowSeparator('=', '=',
                        headLength, titleLengths[0], titleLengths[1]));
        }
        return tabBodyBuilder.append("\n").toString();
    }

    static String genRowSeparator(char colSepChar, char rowSepChar, int headLength, int... titleLengths) {
        StringBuilder sepBuilder = new StringBuilder();
        sepBuilder.append("|");
        for(int i = 0; i <= headLength; i++) {
            if ((i == titleLengths[0] || i == headLength - titleLengths[1])) {
                sepBuilder.append(colSepChar);
            } else {
                sepBuilder.append(rowSepChar);
            }
        }
        sepBuilder.append("|\n");

        return sepBuilder.toString();
    }
}
