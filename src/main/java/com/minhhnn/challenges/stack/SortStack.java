package com.minhhnn.challenges.stack;

import java.util.Stack;

/**
 * Created by @author minh on 30/12/17.
 * Write a program to sort a stack such that the smallest items are on the top. You can use
 * an additional temporary stack, but you may not copy the elements into any other data structure
 * (such as an array). The stack supports the following operations: push, pop, peek, and is Empty.
 */
public class SortStack {
    public static void main(String[] args) {
        Stack<Integer> originalStack = createTestData();

        Stack<Integer> sortedStack = sortStack(originalStack);

        System.out.println("Original stack");
        printStack(originalStack);
        System.out.println("");
        System.out.println("Sorted stack");
        printStack(sortedStack);
    }

    private static Stack<Integer> sortStack(final Stack<Integer> originalStack) {
        Stack<Integer> copiedStack = (Stack<Integer>) originalStack.clone();

        Stack<Integer> sortedStack = new Stack<>();

        while (!copiedStack.isEmpty()) {
            // pop the top element (num1) of the orginal stack  and compare it with the top element (num2) of the sorted stack
            // if the num1 < num2 which mean so far this number is the smallest
            // therefore we can just push it to the top of the sorted stack
            // otherwise if num1 > num2 which mean the smallest number is already sit on the top of the sorted stack
            // therefore we can't push this num1 to the top of the sorted Stack
            // we have to find the correct position in the sorted stack for this num1
            // we can do this by popping out all the numbers that are smaller than num1 from the sorted Stack
            // and put them back to the original Stack
            int num = copiedStack.pop();

            while (!sortedStack.isEmpty() && sortedStack.peek() < num) {
                copiedStack.push(sortedStack.pop());
            }

            sortedStack.push(num);
        }

        return sortedStack;
    }

    private static void printStack(Stack<Integer> originalStack) {
        Stack<Integer> copiedStack = (Stack<Integer>) originalStack.clone();

        while (!copiedStack.isEmpty()) {
            System.out.print(copiedStack.pop() + " ");
        }
    }

    private static Stack<Integer> createTestData() {
        Stack<Integer> testStack = new Stack<>();
        testStack.push(5);
        testStack.push(2);
        testStack.push(6);
        testStack.push(1);
        testStack.push(3);
        testStack.push(9);
        testStack.push(10);
        testStack.push(4);

        return testStack;
    }
}
