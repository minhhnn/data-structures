package com.minhhnn.challenges;

import com.minhhnn.tree.BinarySearchTree;

public class VerticalSumOfBinary {
    public static void main(String[] agrs) {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();

        bst.insert(50);
        bst.insert(30);
        bst.insert(20);
        bst.insert(40);
        bst.insert(70);
        bst.insert(60);
        bst.insert(80);

        bst.printInOrder();
    }
}
