package com.minhhnn.bit;

/**
 * Created by @author minh on 05/01/2018.
 * Print Binary representation of a decimal number
 */
public class PrintBinaryRepresentation {
    public static void main(String[] args) {
        int num = 15;
        System.out.println("Binary representation of " + num + " = " + printBinary(num));
    }

    /**
     * Print binary representation of a decimal number
     * @param num input in decimal
     * @return binary form
     */
    private static String printBinary(int num) {
        StringBuilder result = new StringBuilder();
        while (num > 0) {
            result.append(num & 1);
            num = num >> 1;
        }
        return result.reverse().toString();
    }
}
