package com.epam.alexandr_steblyuk.java.lesson_3.utils.helpers;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.util.*;

public class IOFileHelper {

    public static void writeToFile(Path target, String inputString, boolean append) {
        try(FileOutputStream fileOutputStream = new FileOutputStream(target.toString(), append)) {
            fileOutputStream.write(inputString.getBytes(StandardCharsets.UTF_8));
        } catch (NoSuchFileException fe) {
            System.out.println("Sorry, your file was not found! :(");
        } catch (IOException ie) {
            System.out.println(("Unexpected problem!"));
        }
    }

    public static String readFromFile(Path source) {
        StringBuilder inputStringBuilder = new StringBuilder();

        try(FileInputStream fileInputStream = new FileInputStream(source.toString())) {
            Scanner scanner = new Scanner(fileInputStream);
            while (scanner.hasNextLine()) {
                inputStringBuilder.append(scanner.nextLine() + "\n");
            }
        } catch (NoSuchFileException fe) {
            System.out.println("Sorry, your file was not found! :(");
        } catch (IOException ie) {
            System.out.println(("Unexpected problem!"));
        }

        return inputStringBuilder.toString();
    }
}
