package com.minhhnn.tree;

public class BinarySearchTree<T extends Comparable<T>> {
    private Node<T> root;

    public void insertRecursive(T data) {
        root = insertRecursive(data, root);
    }

    private Node<T> insertRecursive(T data, Node<T> current) {
        if (current == null) {
            current = new Node<>(data);
        } else if (data.compareTo(current.data) <= 0) {
            current.left = insertRecursive(data, current.left);
        } else {
            current.right = insertRecursive(data, current.right);
        }

        return current;
    }

    public void insert(T data) {
        if (root == null) {
            root = new Node<>(data);
            return;
        }

        Node<T> current = root;
        while (current != null) {
            if (data.compareTo(current.data) <= 0) {
                if (current.left != null) {
                    current = current.left;
                } else {
                    current.left = new Node<>(data);
                    break;
                }
            } else {
                if (current.right != null) {
                    current = current.right;
                } else {
                    current.right = new Node<>(data);
                    break;
                }
            }
        }
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
