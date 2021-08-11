package org.rptp.java.AnimalSerialized;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class AnimalSerializer {
    public static ByteArrayOutputStream serializeAnimal(Animal[] animals) {
        ByteArrayOutputStream bais = new ByteArrayOutputStream();

       try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(bais)) {
           objectOutputStream.writeInt(animals.length);

           for (int i = 0; i < animals.length; i++) {
               objectOutputStream.writeObject(animals[i]);
           }

       } catch (Exception e) {
           throw new IllegalArgumentException(e);
       }


        return bais;
    }
}
