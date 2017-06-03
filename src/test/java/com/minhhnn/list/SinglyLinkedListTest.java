package com.minhhnn.list;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by minh on 3/06/17.
 */
public class SinglyLinkedListTest {
    private Random randomGenerator = new Random();

    @Test
    public void testInsert() {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        Assert.assertThat("List is empty", list.size(), CoreMatchers.equalTo(0));

        //Generate test list
        List<Integer> testList = generateTestList();

        // Fill the list with n random integers
        StringBuilder expectedOutput = new StringBuilder("List: ");
        for (Integer num : testList) {
            expectedOutput.append(num).append(" ");
            list.insert(num);
        }

        Assert.assertThat("Size of list must equal to n", list.size(), CoreMatchers.equalTo(testList.size()));
        Assert.assertThat("List output must equal to expectedOutput", list.toString(), CoreMatchers.equalTo(expectedOutput.toString()));

    }

    /**
     * Helper method, used to generate a list of Integer using built-in List/ArrayList
     * @return test list
     */
    private List<Integer> generateTestList() {
        List<Integer> testList = new ArrayList<>();
        int maxCapacity = 100;

        //Generate total number of elements to be inserted
        int n = randomGenerator.nextInt(maxCapacity) + 1;

        // Fill the list with n random integers
        for (int i = 0; i < n; i++) {
            int randomNumber = generateRandomNumber();
            testList.add(randomNumber);
        }

        return testList;
    }

    /**
     * Helper class to generate random number
     * @return a random int number
     */
    private int generateRandomNumber() {
        return randomGenerator.nextInt(Integer.MAX_VALUE);
    }
}
