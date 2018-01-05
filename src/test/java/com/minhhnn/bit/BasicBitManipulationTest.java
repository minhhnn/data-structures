package com.minhhnn.bit;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by @author minh on 05/01/2018.
 * Test some basic bit manipulation operations
 */
public class BasicBitManipulationTest {
    @Test
    public void testSetBit() {
        int num = 0b00000110;
        int index = 5;
        int expected = 0b00100110;
        Assert.assertThat("Must correctly set bit at position 5 to 1", BasicBitManipulation.setBit(num, index), CoreMatchers.equalTo(expected));
    }

    @Test
    public void testClearBit() {
        int num = 0b00100110;
        int index = 5;
        int expected = 0b00000110;
        Assert.assertThat("Must correctly clear bit at position 5 to 0", BasicBitManipulation.clearBit(num, index), CoreMatchers.equalTo(expected));
    }

    @Test
    public void testFlipBit() {
        int num = 0b00100110;
        int index = 5;
        int expected = 0b00000110;
        Assert.assertThat("Must correctly flip bit at position 5 to 0", BasicBitManipulation.flipBit(num, index), CoreMatchers.equalTo(expected));
    }

    @Test
    public void testGetBit() {
        int num = 0b00000110;
        int index = 2;
        int expected = 1;
        Assert.assertThat("Must correctly get bit at position 5", BasicBitManipulation.getBit(num, index), CoreMatchers.equalTo(expected));
    }
}
