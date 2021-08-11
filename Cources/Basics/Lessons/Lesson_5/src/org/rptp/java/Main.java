package org.rptp.java;

import org.rptp.java.AnimalSerialized.Animal;
import org.rptp.java.AnimalSerialized.AnimalDeserializer;
import org.rptp.java.AnimalSerialized.AnimalSerializer;
import org.rptp.java.ByteStream.ByteStreamAggregator;
import org.rptp.java.ByteToStringConverter.ByteToStringConverter;
import org.rptp.java.DoubleFromTextParser.DoubleFromTextParser;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
	// write your code here
//        execTask2();

//        try {
//            execTask3();
//        } catch (IOException e) {
//            System.out.println("ERROR");
//        }

//        execTask3();
//        execTask4();

    }

//    public static void execTask2() {
//        ByteStreamAggregator.aggregateByteStream();
//    }

//    public static void execTask3() throws IOException{
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        byte[] a = bufferedReader.readLine().getBytes(StandardCharsets.UTF_8);
//        for(byte b : a) {
//            System.out.print(Byte.toUnsignedInt(b) + " ");
//        }
//
//    }

//    public static void execTask3() {
//        try {
//            System.out.println(ByteToStringConverter.readAsString(new ByteArrayInputStream(new byte[] {48, 49, 50, 51}),
//                    StandardCharsets.US_ASCII));
//        } catch (IOException e) {
//            System.out.println("ERROR");
//        }
//
//    }

//    public static void  execTask4() {
//        Animal[] animals = {new Animal("Fox"), new Animal("Elephant"),
//                            new Animal("Tiger"), new Animal("Snake")};
//        Animal[] deserializedAnimals;
//        byte[] bytes;
//        try (ByteArrayOutputStream outputStream = AnimalSerializer.serializeAnimal(animals)) {
//            bytes = outputStream.toByteArray();
//            deserializedAnimals = AnimalDeserializer.deserializeAnimalArray(bytes);
//            for (Animal animal: deserializedAnimals) {
//                System.out.println(animal.getName());
//            }
//        } catch (IOException e) {
//            System.out.println("ERROR");
//        }
//
//    }




}
