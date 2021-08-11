package com.epam.alexandr_steblyuk.java.lesson_4.task_1;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Scanner;

public class MyFileReaderWriter {

//    public static String readStringFromFile(String filePath) {
//        StringBuilder outStringBuilder = new StringBuilder();
//
//        try(FileInputStream fileInputStream = new FileInputStream(filePath)) {
//            while(fileInputStream.available() > 0) {
//
//                outStringBuilder.append((char) fileInputStream.read());
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        return outStringBuilder.toString();
//    }

    public static String readStringFromFile(String filePath) {
        StringBuilder outStringBuilder = new StringBuilder();

        try(DataInputStream dataInputStream = new DataInputStream(new FileInputStream(filePath))) {
            while (dataInputStream.available() > 0) {
                outStringBuilder.append((char)dataInputStream.readByte());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return outStringBuilder.toString();
    }

    public static void writeStringFromFile(String filePath, String inputString) {
        byte[] inputBytes = inputString.getBytes(StandardCharsets.UTF_8);

        try(FileOutputStream fileOutputStream = new FileOutputStream(filePath, true)) {
            fileOutputStream.write("\n".getBytes(StandardCharsets.UTF_8));
            fileOutputStream.write(inputBytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(inputString);
    }
}
