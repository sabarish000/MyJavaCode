package com.my.learnings.polymorphism;

public class Client {
    public static void main(String[] args) {
        // it calls the float method
        // JVM does the implicit conversion from shorter to larger data types and calls float data type method
        // Here 1 & 2 are int data type, byte - 8 bits and short - 16 bits and int - 32 bits
        // So int is converted to float and Hence JVM calls float method
        // output is float
        System.out.println("out" + new Calculator().add(1,2));
    }
}
