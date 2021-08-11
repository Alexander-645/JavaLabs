package com.epam.alexandr_steblyuk.java.lesson_3.text;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Sentence extends Text{

    static Pattern pattern = Pattern.compile(ResourceBundle.getBundle("regex").getString("sentence"));

    public Sentence(String content) {
        this.content = content;
    }

    public static int compCountOfWords(String sentence) {
        Matcher matcher = Word.getPattern().matcher(sentence);
        int count = 0;
        while (matcher.find()) {
            count++;
        }
        return count;
    }

    public static List<Word> getListOfWords(String sentence) {
        Matcher matcher = Word.getPattern().matcher(sentence);
        List wordsList = new ArrayList<Word>();
        while (matcher.find()) {
            wordsList.add(new Word(sentence.substring(matcher.start(), matcher.end())));
        }
        return wordsList;
    }

    public static Pattern getPattern() {
        return pattern;
    }
}
