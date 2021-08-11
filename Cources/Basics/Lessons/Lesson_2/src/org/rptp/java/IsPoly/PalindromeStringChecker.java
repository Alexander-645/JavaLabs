package org.rptp.java.IsPoly;

import java.util.Locale;

public class PalindromeStringChecker {
    public static boolean isPalindrome(String inputString) {
        String lowerString = inputString.replaceAll("[^a-zA-Z0-9]", "").toLowerCase(Locale.ENGLISH);
        StringBuilder newString = new StringBuilder();
        newString.append(lowerString);

        return lowerString.equals(newString.reverse().toString());
    }
}
