package com.my.learnings.polymorphism;

public class Calculator {
    public byte add(byte a, byte b) {
        System.out.println("byte");
        return b;
    }

    public short add(short a, short b) {
        System.out.println("short");
        return a;
    }

    public float add(float a, float b) {
        System.out.println("float");
        return a + b;
    }
}
