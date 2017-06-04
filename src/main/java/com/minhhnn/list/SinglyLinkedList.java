package com.minhhnn.list;

import java.lang.reflect.Array;

/**
 * Created by minh on 3/06/17.
 */
public class SinglyLinkedList<T>{

    private class Node<T> {
        T data;
        Node next;

        Node(T data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Node<?> node = (Node<?>) o;

            return data.equals(node.data);
        }

        @Override
        public int hashCode() {
            return data.hashCode();
        }
    }

    private Node head;
    private int size;

    /**
     * Return total number of items in the list
     * @return size of the list
     */
    public int size() {
        return size;
    }

    /**
     * Insert a new element to the list
     * @param data item to be inserted
     */
    public void insert(T data) {
        if (head == null) {
            head = new Node(data);
            size++;
        }
        else {
            Node current = head;
            // GO to the end of the list
            while (current.next != null) {
                current = current.next;
            }

            // Insert new item at the end of the list
            current.next = new Node(data);

            //Increase list size
            size++;
        }
    }

    /**
     * Delete an item from the list
     * @param data item to be deleted
     */
    public void delete(T data) {
        if (head != null) {
            if (head.data.equals(data)) {
                head = head.next;
                size--;
            }
            Node current = head;
            while (current.next != null) {
                if (current.next.data.equals(data)) {
                    current.next = current.next.next;
                    size--;
                }
                current = current.next;
            }
        }
    }

    /**
     * Convert a list to an array
     * @return an array containing all the elements in the list
     */
    public T[] toArray() {
        if (head == null) {
            return (T[]) new Object[0];
        }
        Node current = head;
        T[] result = createArray(head.data.getClass(), size);
        int i = 0;
        while (current != null) {
            result[i] = (T) current.data;
            current = current.next;
            i++;
        }
        return (T[]) result;
    }

    /**
     * Helper method to create an array of generic type
     * @param type
     * @param size
     * @return
     */
    private T[] createArray(Class type, int size){
        return (T[]) Array.newInstance(type, size);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        if (head == null) {
            result.append("List is empty");
        }
        else {
            result.append("List: ");
            Node current = head;
            while (current != null) {
                result.append(current.data).append(" ");
                current = current.next;
            }
        }

        return result.toString();
    }
}
