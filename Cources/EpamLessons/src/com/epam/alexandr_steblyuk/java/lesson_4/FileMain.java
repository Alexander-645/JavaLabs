package com.epam.alexandr_steblyuk.java.lesson_4;

import com.epam.alexandr_steblyuk.java.lesson_3.utils.helpers.BackupHelper;
import com.epam.alexandr_steblyuk.java.lesson_4.task_1.MyFileReaderWriter;
import com.epam.alexandr_steblyuk.java.lesson_4.task_2.FilesWorker;
import com.epam.alexandr_steblyuk.java.lesson_4.task_3.MatrixReaderWriter;
import com.epam.alexandr_steblyuk.java.lesson_4.task_4.ContactsFileReaderWriter;
import com.epam.alexandr_steblyuk.java.lesson_4.task_4.PhoneContact;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class FileMain {
    public static void main(String[] args) {
        execTask4();
    }

    public static void execTask1() {
        System.out.println(MyFileReaderWriter.readStringFromFile(".\\resources\\backup\\book.bak"));
        MyFileReaderWriter.writeStringFromFile(".\\resources\\original\\book.txt", "Test string");
    }
    public static void execTask2() {
        FilesWorker filesWorker = new FilesWorker();

        filesWorker.createDirectory("TestDir");

        try {
            filesWorker.createFile("testFile");
        }
        catch (IOException e) {
            e.getMessage();
        }

        filesWorker.fillFileNumSeq(new int[] {1,3 ,0, 4, -1 ,4, 5, 65 ,100});
        filesWorker.getSortedIntSeqFromFile();
    }

    public static void execTask3() {
        int[][] matrix = MatrixReaderWriter.readMatrix(".\\resources\\TestDir\\matrix.txt");
        MatrixReaderWriter.writeMatrixInFile(matrix);
    }

    public static void execTask4() {
        PhoneContact oneContact = new PhoneContact("Alexey", "89-09-87");
        PhoneContact twoContact = new PhoneContact("Sasha", "89521295735");
        PhoneContact threeContact = new PhoneContact("Andrey", "32-29-26");

        List<PhoneContact> contactList = Arrays.stream(new PhoneContact[] {oneContact, twoContact, threeContact}).toList();
        FilesWorker filesWorker = new FilesWorker();
        filesWorker.createDirectory("contacts");
//        try {
//            filesWorker.createFile("contactsFile");
//        }
//        catch (IOException e) {
//            System.out.println("UPS");
//        }

        ContactsFileReaderWriter.writeContactsToFile(".\\resources\\contacts\\contactsFile.dat", contactList);
        ContactsFileReaderWriter.readContactsFromFile(".\\resources\\contacts\\contactsFile.dat");
    }
}
