package com.epam.alexandr_steblyuk.java.lesson_2.task_1.task_1_1.ierarchiOfNodes;

public class Node implements Comparable<Node>{
    public final int value;
    public String code;

    public Node(int value) {
        this.value = value;
    }

    public void buildCode(String code) {
        this.code = code;
    }

    @Override
    public int compareTo(Node o) {
        return Integer.compare(value, o.value);
    }

}
