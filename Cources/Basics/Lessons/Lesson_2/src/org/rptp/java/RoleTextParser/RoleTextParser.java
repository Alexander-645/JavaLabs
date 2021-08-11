package org.rptp.java.RoleTextParser;

public class RoleTextParser {
    public String printTextPerRole(String[] roles, String[] textLines) {
        StringBuilder resultString = new StringBuilder();

        for (int i = 0; i < roles.length; i++) {
            resultString.append(roles[i] + ":\n");
            for (int j = 0; j < textLines.length; j++) {
                if (textLines[j].startsWith(roles[i] + ":")) {
                    int strNum = j + 1;
                    resultString.append("" + strNum + ") " +
                            textLines[j].substring((roles[i].length() + 2)) + "\n");
                }
            }
            resultString.append("\n");
        }
        return resultString.toString();
    }
}
