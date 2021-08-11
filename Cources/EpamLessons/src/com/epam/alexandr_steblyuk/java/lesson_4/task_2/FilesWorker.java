package com.epam.alexandr_steblyuk.java.lesson_4.task_2;

import com.epam.alexandr_steblyuk.java.lesson_4.task_1.MyFileReaderWriter;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FilesWorker {
    public String dirPath;
    public String filePath;

    public void createDirectory(String dirName) {
        File myDir = new File(".\\resources\\" + dirName);
        if(!myDir.exists()) {
            myDir.mkdir();
        }
        dirPath = myDir.getPath();
    }

    public void createFile(String fileName) throws IOException {
        File myFile = new File(dirPath + "\\" + fileName + ".txt");
        if(!myFile.exists()) {
            myFile.createNewFile();
        }
        filePath = myFile.getPath();
    }

    public void fillFileNumSeq(int[] inputInts) {
        try(OutputStreamWriter fileOutputStream = new OutputStreamWriter(
                new FileOutputStream(filePath), StandardCharsets.UTF_8)) {
            for(int i = 0; i < inputInts.length; i++) {
                fileOutputStream.write(String.valueOf(inputInts[i]));
                fileOutputStream.write(" ");
            }
        }
        catch (IOException e) {
            e.getMessage();
        }
    }

    public void getSortedIntSeqFromFile() {
        List<Integer> numList = new ArrayList<>();
        String outputString = MyFileReaderWriter.readStringFromFile(filePath);
        Pattern numPattern = Pattern.compile(ResourceBundle.getBundle("regex").getString("numbers"));
        Matcher matcher = numPattern.matcher(outputString);

        while (matcher.find()) {
            numList.add(Integer.valueOf(outputString.substring(matcher.start(), matcher.end())));
        }
        numList.sort(Integer::compare);

        System.out.println(Arrays.toString(numList.toArray()));
    }

}
