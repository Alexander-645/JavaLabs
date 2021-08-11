package com.epam.alexandr_steblyuk.java.lesson_4.task_4;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class ContactsFileReaderWriter {

    public static void readContactsFromFile(String filePath) {
        StringBuilder contactsBuilder = new StringBuilder();

//        try(Reader reader = new FileReader(filePath)) {
//            while (reader.ready()) {
//                contactsBuilder.append((char) reader.read());
//            }
//        }
//        catch (IOException e) {
//            System.out.println("Sorry, file is not exists!");
//        }

        List<PhoneContact> currentList = new ArrayList<>();
        try(ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(filePath))) {
            currentList = (List<PhoneContact>) objectInputStream.readObject();
        }
        catch (IOException | ClassNotFoundException e) {
            System.out.println("Sorry, file is not exists!");
        }

        for(PhoneContact phoneContact:currentList) {
            contactsBuilder.append(phoneContact.contactName)
                    .append(" - ")
                    .append(phoneContact.phoneNumber)
                    .append(" \n");
        }

        System.out.println(contactsBuilder.toString());
    }

    public static void writeContactsToFile(String filePath, List<PhoneContact> contactList) {
//        StringBuilder contactsBuilder = new StringBuilder();
//
//        for(PhoneContact phoneContact:contactList) {
//            contactsBuilder.append(phoneContact.contactName).append(" - ");
//            contactsBuilder.append(phoneContact.phoneNumber).append(" \n");
//        }
//
//        char[] outputBuf = contactsBuilder.toString().toCharArray();
//
//        try(FileWriter fileWriter = new FileWriter(filePath)) {
//            fileWriter.write(outputBuf);
//        }
//        catch (IOException e) {
//            System.out.println("Sorry, unexpected error :(");
//        }

        try(ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(filePath))) {
            objectOutputStream.writeObject(contactList);
        }
        catch (IOException e) {
            System.out.println("Sorry, unexpected error :(");
            System.exit(0);
        }

        System.out.println("Contacts success written!");
    }
}
