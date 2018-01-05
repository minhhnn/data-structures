package com.minhhnn.bit;

/**
 * Created by @author minh on 05/01/2018.
 * Implement some basic bit manipulation operations
 */
public class BasicBitManipulation {

    /**
     * Set bit at position index to 1
     * i.e. num = 0000 0110, index = 5 (from right to left starting 0)
     * ==> return 0010 0110
     * @param num input
     * @param index position
     * @return new num after set bit
     */
    public static int setBit(int num, int index) {
        int mask = 1 << index;
        return num | mask;
    }

    /**
     * Clear bit == Set bit at position index to 0
     * i.e. num = 0010 0110, index = 5 (from right to left starting 0)
     * ==> return 0000 0110
     * @param num input
     * @param index position
     * @return new num after clear bit
     */
    public static int clearBit(int num, int index) {
        int mask = 1 << index;
        return num & ~mask;
    }

    /**
     * Flip bit == Set 1 to 0 or 0 to 1 at position index
     * i.e. num = 0000 0110, index = 5 (from right to left starting 0)
     * ==> return 0010 0110
     * @param num input
     * @param index position
     * @return new num after flip bit
     */
    public static int flipBit(int num, int index) {
        int mask = 1 << index;
        return num ^ mask;
    }

    /**
     * Get bit at position index
     * i.e. num = 00000110, index = 2 (from right to left starting 0)
     * ==> return 1
     * @param num input
     * @param index position
     * @return bit at position index
     */
    public static int getBit(int num, int index) {
        int shifted = num >> index;
        return shifted & 1;
    }
}
