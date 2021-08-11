package com.epam.alexandr_steblyuk.java.lesson_2.task_1.task_1_1.ierarchiOfNodes;

public class InnerNode extends Node {
    Node leftChild, rightChild;

    public InnerNode(Node leftChild, Node rightChild) {
        super(leftChild.value + rightChild.value);
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    @Override
    public void buildCode(String code) {
        super.buildCode(code);
        leftChild.buildCode(code + "0");
        rightChild.buildCode(code + "1");
    }
}
