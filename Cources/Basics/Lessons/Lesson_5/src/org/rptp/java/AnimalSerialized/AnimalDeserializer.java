package org.rptp.java.AnimalSerialized;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class AnimalDeserializer {
    public static Animal[] deserializeAnimalArray(byte[] data) {
        Animal[] deserializedAnimals;
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new ByteArrayInputStream(data))) {
            int size = objectInputStream.readInt();
            deserializedAnimals = new Animal[size];
            for (int i = 0; i < size; i++) {
                deserializedAnimals[i] = (Animal) objectInputStream.readObject();
            }

        } catch (Exception e) {
            throw new IllegalArgumentException(e);
        }

        return deserializedAnimals;
    }
}
