package com.minhhnn.tree;

public class BinarySearchTree<T extends Comparable<T>> {
    private Node<T> root;

    public void insert(T data) {
        root = insert(data, root);
    }

    private Node insert(T data, Node<T> current) {
        if (current == null) {
            current = new Node<>(data);
        } else if (data.compareTo(current.data) <= 0) {
            current.left = insert(data, current.left);
        } else {
            current.right = insert(data, current.right);
        }

        return current;
    }

    public void printInOrder() {
        printInOrder(root);
    }

    private void printInOrder(Node<T> current) {
        if (current != null) {
            printInOrder(current.left);
            System.out.print(current.data + " ");
            printInOrder(current.right);
        }
    }

    private static class Node<T> {
        private Node<T> left;
        private Node<T> right;
        private T data;

        private Node(T data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return data.toString();
        }
    }
}
