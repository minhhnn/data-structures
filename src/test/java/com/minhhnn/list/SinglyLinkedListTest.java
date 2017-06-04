package com.minhhnn.list;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
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

        // Fill our list with n random integers
        for (Integer num : testList) {
            list.insert(num);
        }

        Assert.assertThat("Size of list must equal to n", list.size(), CoreMatchers.equalTo(testList.size()));
        Assert.assertThat("List data must equal to testList", compartTwoArrays(list.toArray(), testList.toArray()), CoreMatchers.equalTo(true));
    }

    @Test
    public void testDeleteHead() {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        Assert.assertThat("List is empty", list.size(), CoreMatchers.equalTo(0));

        //Generate test list
        List<Integer> testList = generateTestList();

        // Fill our list with n random integers
        for (Integer num : testList) {
            list.insert(num);
        }

        //Delete the head element from the testList
        //Element to be deleted
        Integer data = testList.get(0);

        testList.remove(0);

        //Delete the head element from our list
        list.delete(data);

        Assert.assertThat("Size of list must equal to size of test list", list.size() , CoreMatchers.equalTo(testList.size()));
        Assert.assertThat("List data must equal to testList", Arrays.equals(list.toArray(), testList.toArray()), CoreMatchers.equalTo(true));

    }

    @Test
    public void testDeleteARandomIndex() {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        Assert.assertThat("List is empty", list.size(), CoreMatchers.equalTo(0));

        //Generate test list
        List<Integer> testList = generateTestList();

        // Fill our list with n random integers
        for (Integer num : testList) {
            list.insert(num);
        }

        //Pick a random element to delete
        int indexOfElementToBeDeleted = randomGenerator.nextInt(testList.size());
        System.out.println("index = " + indexOfElementToBeDeleted);

        //Delete an element from the testList
        Integer data = testList.get(indexOfElementToBeDeleted);
        testList.remove(data);

        //Delete an element from our list
        list.delete(data);

        Assert.assertThat("Size of list must equal to size of test list", list.size() , CoreMatchers.equalTo(testList.size()));
        Assert.assertThat("List data must equal to testList", Arrays.equals(list.toArray(), testList.toArray()), CoreMatchers.equalTo(true));

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
     * Helper method to compare 2 arrays
     * @param arr1
     * @param arr2
     * @return true if 2 arrays are equals, and false otherwise
     */
    private boolean compartTwoArrays(Object[] arr1, Object[] arr2) {
        if (arr1.length != arr2.length) {
            return false;
        }
        else {
            for (int i = 0; i < arr1.length; i++) {
                if (arr1[i].getClass() != arr2[i].getClass() || !arr1[i].equals(arr2[i])){
                    return false;
                }
            }
            return true;
        }
    }

    /**
     * Helper class to generate random number
     * @return a random int number
     */
    private int generateRandomNumber() {
        return randomGenerator.nextInt(Integer.MAX_VALUE);
    }
}
