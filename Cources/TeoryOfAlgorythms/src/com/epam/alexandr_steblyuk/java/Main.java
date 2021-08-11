package com.epam.alexandr_steblyuk.java;

import com.epam.alexandr_steblyuk.java.lesson_2.task_1.task_1_1.helpers.IOHelper;
import com.epam.alexandr_steblyuk.java.lesson_2.task_1.task_1_1.ierarchiOfNodes.InnerNode;
import com.epam.alexandr_steblyuk.java.lesson_2.task_1.task_1_1.ierarchiOfNodes.LeafNode;
import com.epam.alexandr_steblyuk.java.lesson_2.task_1.task_1_1.ierarchiOfNodes.Node;
import com.epam.alexandr_steblyuk.java.lesson_2.task_2.CommandReader;
import com.epam.alexandr_steblyuk.java.lesson_2.task_2.MinHeap;
import com.epam.alexandr_steblyuk.java.lesson_3.task_1.BinFinder;
import com.epam.alexandr_steblyuk.java.lesson_3.task_2.InversionCounter;
import com.epam.alexandr_steblyuk.java.lesson_3.task_3.SegmentsSorter;
import com.epam.alexandr_steblyuk.java.lesson_3.task_4.CountSorter;
import com.epam.alexandr_steblyuk.java.lesson_4.task_1.DivSubSequenceFinder;
import com.epam.alexandr_steblyuk.java.lesson_4.task_2.EditingDistanceCalculator;
import com.epam.alexandr_steblyuk.java.lesson_4.task_3.BackpackPackager;
import com.epam.alexandr_steblyuk.java.lesson_4.task_4.StepsSumCalculator;
import com.epam.alexandr_steblyuk.java.lesson_5.task_1.BracketsController;
import com.epam.alexandr_steblyuk.java.lesson_5.task_2.TreeHeightCalculator;
import com.epam.alexandr_steblyuk.java.lesson_5.task_4.MaxStack;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws IOException {
	// write your code here
//        DotsOnSegments dotsOnSegments = new DotsOnSegments();
//        dotsOnSegments.getDots();

//        BagPackager bagPackager = new BagPackager();
//        bagPackager.packBag();

//        MaxNumberOfTermCalculator maxNumberOfTermCalculator = new MaxNumberOfTermCalculator();
//        maxNumberOfTermCalculator.calculateTermNumber();
        new Main().execTask13();
    }

    public void execTask1() {
        Map<Character, Integer> charMap = null;

        try {
            charMap = IOHelper.readCharsToMap(".\\resources\\FileForCodding");
        } catch (FileNotFoundException e) {
            System.out.println("File not exists!");
            System.exit(0);
        }
        String string = new String();

        try {
            string = IOHelper.readStringFromFile(".\\resources\\FileForCodding");
        }
        catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }



        PriorityQueue<Node> priorityQueue = new PriorityQueue<>();
        Map<Character, Node> nodeMap = new HashMap<>();

        for (Map.Entry<Character, Integer> entry:charMap.entrySet()) {
            LeafNode leafNode = new LeafNode(entry.getValue(), entry.getKey());
            priorityQueue.add(leafNode);
            nodeMap.put(entry.getKey(), leafNode);
        }

        int sum = 0;

        if(priorityQueue.size() == 1) {
            Node left = priorityQueue.poll();
            InnerNode inNode = new InnerNode(left, new Node(0));
            priorityQueue.add(inNode);
            sum += inNode.value;
        }
        else {
            while (priorityQueue.size() > 1) {
                Node left = priorityQueue.poll();
                Node right = priorityQueue.poll();
                InnerNode inNode = new InnerNode(left, right);
                priorityQueue.add(inNode);
                sum += inNode.value;
            }
        }

        sum += priorityQueue.peek().value;

        System.out.println(charMap.size() + " " + sum);

        priorityQueue.peek().buildCode("");

        StringBuilder stringBuilder = new StringBuilder();


        for (char curChar:string.toCharArray()) {
            stringBuilder.append(nodeMap.get(curChar).code);
        }

        System.out.println(stringBuilder.toString());

    }

    public void execTask2() {
        MinHeap minHeap = new MinHeap();

        for (String command: CommandReader.readCommands()) {
            if(command.contains("Insert")) {
                minHeap.insertNode(Integer.parseInt(command.substring(7)));
            }
            else if (command.contains("ExtractMax")) {
                minHeap.extractMaxValue();
            }
        }

//        MaxHeap minHeap = new MaxHeap();
//
//        for (String command: CommandReader.readCommands()) {
//            if(command.contains("Insert")) {
//                minHeap.insertNode(Integer.parseInt(command.substring(7)));
//            }
//            else if (command.contains("ExtractMax")) {
//                minHeap.extractMaxValue();
//            }
//        }

    }

    public void execTask3() {
        BinFinder binFinder = new BinFinder();
        binFinder.calculate();
    }

    public void execTask4() throws IOException {
        new InversionCounter().calcCountOfInversions();
    }

    public void execTask5() throws IOException {
        new SegmentsSorter().run();
    }

    public void execTask6() throws IOException {
        new CountSorter().run();
    }

    public void execTask7() throws IOException {
        new DivSubSequenceFinder().run();
    }

    public void execTask8() throws IOException {
        new EditingDistanceCalculator().run();
    }

    public void execTask9() throws IOException {
        new BackpackPackager().run();
    }

    public void execTask10() throws IOException {
        new StepsSumCalculator().run();
    }

    public void execTask11() throws IOException {
        new BracketsController().run();
    }

    public void execTask12() throws IOException {
        new TreeHeightCalculator().run();
    }

    public void execTask13() throws IOException {
        new MaxStack().run();
    }



//    public static void test() {
//        BigInteger[] n = new BigInteger[2];
//        Scanner scanner = new Scanner(System.in);
//        for(int j = 0; j < 2; j++) {
//            n[j] = scanner.nextBigInteger();
//        }
//        List<Integer> F = new ArrayList<>();
//        int current = 1, previous = 0;
//        int buf;
//        F.add(previous);
//        F.add(current);
//        BigInteger i;
//        for(i = new BigInteger("2"); i.compareTo(n[0]) < 1; i = i.add(BigInteger.ONE)) {
//            buf = (current + previous) % n[1].intValue();
//
//            if(buf == 1 && current == 0) {
//                F.remove(F.lastIndexOf(0));
//                break;
//            }
//
//            previous = current;
//            current = buf;
//            F.add(current);
//        }
//        int index = F.size();
//        System.out.println(F.get(n[0].mod(BigInteger.valueOf(index)).intValue()));
//    }
}
