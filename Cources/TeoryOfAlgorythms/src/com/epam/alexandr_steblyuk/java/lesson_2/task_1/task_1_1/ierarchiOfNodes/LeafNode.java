package com.epam.alexandr_steblyuk.java.lesson_2.task_1.task_1_1.ierarchiOfNodes;

import com.epam.alexandr_steblyuk.java.lesson_2.task_1.task_1_1.ierarchiOfNodes.Node;

public class LeafNode extends Node {
    char content;

    public LeafNode(int value, char content) {
        super(value);
        this.content = content;
    }

    @Override
    public void buildCode(String code) {
        super.buildCode(code);
        System.out.println(content + " : " + this.code);
    }

}
