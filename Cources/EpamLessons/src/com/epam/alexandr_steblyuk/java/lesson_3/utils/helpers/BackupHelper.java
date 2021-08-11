package com.epam.alexandr_steblyuk.java.lesson_3.utils.helpers;

import java.io.IOException;
import java.nio.file.*;

public class BackupHelper {
    public static void backupFile(Path source, Path target) {
        try{
            Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("File backup done!");
        } catch (NoSuchFileException e) {
            System.out.println("File is not found!");
        }
        catch (IOException e) {
            System.out.println("File is not backup!");
        }
    }

    public static void restoreFile(Path source, Path target) {
        try{
            Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("File restored done!");
        } catch (NoSuchFileException e) {
            System.out.println("File is not found!");
        } catch (IOException e) {
            System.out.println("File is not restore!");
        }
    }
}
