package com.minhhnn.basics;

/**
 * Java program to demonstrate What is nested static and non static class.
 * How to create instance of static and non static class and How to call
 * methods of nested static and Inner class in Java. Overall comparison of
 * static vs non static class.
 * Ref: http://www.java67.com/2012/10/nested-class-java-static-vs-non-static-inner.html
 */
public class StaticNestedClass{
    private static String message = "HelloWorld";

    // Static nested class
    private static class MessagePrinter{
        //Only static member of Outer class is directly accessible in nested static class

        public void printMessage(){
            // Compile time error if message field is not static
            System.out.println("Message from nested static class : " + message);
        }
    }

    //non static nested class - also called Inner class
    private class Inner{

        // Both static and non static member of Outer class is accessible in this Inner class
        public void display(){
            System.out.println(" Message from non static nested or Inner class : " + message);
        }
    }

    // How to create instance of static and non static nested class
    public static void main(String... args){

        // creating instance of nested Static class
        StaticNestedClass.MessagePrinter printer = new StaticNestedClass.MessagePrinter();

        //calling non static method of nested static class
        printer.printMessage();

        // creating instance of non static nested class or Inner class

        // In order to create instance of Inner class you need an Outer class instance

        StaticNestedClass outer = new StaticNestedClass(); //outer class instance for creating non static nested class

        StaticNestedClass.Inner inner  = outer.new Inner();

        //calling non static method of Inner class
        inner.display();

        // we can also combine above steps in one step to create instance of Inner class
        StaticNestedClass.Inner nonStaticIner = new StaticNestedClass().new Inner();

        // similarly you can now call Inner class method
        nonStaticIner.display();
    }

}