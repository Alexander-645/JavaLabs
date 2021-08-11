package com.epam.alexandr_steblyuk.java.lesson_2.task_2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CommandReader {
    public static List<String> readCommands() {
        Scanner scanner = new Scanner(System.in);
        List<String> commandList = new ArrayList<>();
        int commandNum = scanner.nextInt();
        for(int i = 0; i <= commandNum; i++) {
            commandList.add(scanner.nextLine());
        }

        return commandList;
    }
}
