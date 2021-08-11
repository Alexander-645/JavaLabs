package com.epam.alexandr_steblyuk.java.lesson_3.text;

import java.util.ResourceBundle;
import java.util.regex.Pattern;

public class Word extends Text{

    static Pattern pattern = Pattern.compile(ResourceBundle.getBundle("regex").getString("word"));

    public Word(String content) {
        this.content = content;
    }

    public static Pattern getPattern() {
        return pattern;
    }

}
