package com.epam.alexandr_steblyuk.java.lesson_3.utils.parsers;

import com.epam.alexandr_steblyuk.java.lesson_3.text.Sentence;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.regex.Matcher;

public class TextParser {

    public static String parseFileContent(String fileContent) {
        String result = fileContent.replaceAll(ResourceBundle.getBundle("regex")
                .getString("dblSpaceAndTab"), " ");
        return result;
    }

    public static List<Sentence> parseFileToSentences(String fileContent) {
        List sentenceList = new ArrayList<Sentence>();
        Matcher matcher = Sentence.getPattern().matcher(fileContent);
        while (matcher.find()) {
            sentenceList.add(new Sentence(fileContent.substring(matcher.start(), matcher.end())));
        }
        return sentenceList;
    }

}
