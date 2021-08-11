package com.epam.alexandr_steblyuk.java.lesson_3;

import com.epam.alexandr_steblyuk.java.lesson_3.utils.helpers.BackupHelper;
import com.epam.alexandr_steblyuk.java.lesson_3.utils.helpers.IOFileHelper;
import com.epam.alexandr_steblyuk.java.lesson_3.utils.out_data_generators.TableGenerator;
import com.epam.alexandr_steblyuk.java.lesson_3.utils.parsers.TextParser;

import java.nio.file.Path;
import java.nio.file.Paths;

public class MainLesson3 {
    public static void main(String[] args) {
        Path sourceFile = Paths.get(".\\resources\\original\\book.txt");
        Path targetFile = Paths.get(".\\resources\\backup\\book.bak");
        String fileContent;
        BackupHelper.restoreFile(targetFile, sourceFile);
        //BackupHelper.backupFile(sourceFile, targetFile);

        fileContent = IOFileHelper.readFromFile(sourceFile);
        fileContent = TextParser.parseFileContent(fileContent);
        IOFileHelper.writeToFile(sourceFile, fileContent, false);
        IOFileHelper.writeToFile(sourceFile,new TableGenerator()
                .genTable(40, 16, fileContent), true);
    }
}

